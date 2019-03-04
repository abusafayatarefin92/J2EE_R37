package com.springsecuritymysql.controller;

import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;
import com.springsecuritymysql.entity.Role;
import com.springsecuritymysql.entity.User;
import com.springsecuritymysql.repo.RoleRepo;
import com.springsecuritymysql.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/users/")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    private static String USER_NAME = "arefinsafayat92";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = ""; // GMail password

    @GetMapping(value = "user-list")
    public String userList(Model model){
        model.addAttribute("userlist", this.userRepo.findAll());
        return "users/user-list";
    }

    @GetMapping(value = "add")
    public String addUserView(User user, Model model){
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "users/add";
    }

    @PostMapping(value = "add")
    public String addUser(@Valid User user, BindingResult bindingResult, Model model, HttpServletRequest httpServletRequest){
        // Lookup user in database by e-mail
        User userExists = userRepo.findByEmail(user.getEmail());

        System.out.println(userExists);

        if(userExists != null){
            model.addAttribute("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");
            bindingResult.reject("email");
            return "users/add";
        }

        if(bindingResult.hasErrors()){
            return "users/add";
        }else { // new user so we create user and send confirmation e-mail

            // Disable user until they click on confirmation link in email
            user.setEnabled(false);

            // Generate random 36-character string token for confirmation link
            user.setConfirmationToken(UUID.randomUUID().toString());

            this.userRepo.save(user);

            String appUrl = httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName()+":"+"8008";
            //email sending

            String from = USER_NAME;
            String pass = PASSWORD;
            String[] to = {user.getEmail()}; // list of recipient email addresses
            String subject = "Registration Confirmation";
            String body = "To confirm your e-mail address, please click the link below:\n"
                    + appUrl + "/confirm?token=" + user.getConfirmationToken();

            sendFromGMail(from, pass, to, subject, body);

            model.addAttribute("user", new User());
            model.addAttribute("rolelist", this.roleRepo.findAll());
            model.addAttribute("successuser", "You Have Successfully add user");
            model.addAttribute("confirmationMessage", "A confirmation e-mail has been sent to " + user.getEmail());
            return "users/add";
        }
    }

    @GetMapping(value = "edit/{id}")
    public String editUserView(Model model, @PathVariable("id") Integer id){
        model.addAttribute("userone", this.userRepo.getOne(id));
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "users/edit";
    }

    @PostMapping(value = "edit/{id}")
    public String editUser(@Valid User user, BindingResult bindingResult, @PathVariable("id") Integer id, Model model){
        if(bindingResult.hasErrors()){
            return "users/edit";
        }else {
            this.userRepo.save(user);
            model.addAttribute("user", new User());
            model.addAttribute("rolelist", this.roleRepo.findAll());
            model.addAttribute("successuser", "You Have Successfully add user");
            return "users/user-list";
        }
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        if(id != null){
            this.userRepo.deleteById(id);
        }
        return "users/user-list";
    }

    @Autowired
    public UserController(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    // Process confirmation link
    @RequestMapping(value="/confirm", method = RequestMethod.GET)
    public ModelAndView confirmRegistration(ModelAndView modelAndView, @RequestParam("token") String token) {

        User user = userRepo.findByConfirmationToken(token);

        if (user == null) { // No token found in DB
            modelAndView.addObject("invalidToken", "Oops!  This is an invalid confirmation link.");
        } else { // Token found
            modelAndView.addObject("confirmationToken", user.getConfirmationToken());
        }

        modelAndView.setViewName("public/confirm");
        return modelAndView;
    }

    // Process confirmation link
    @RequestMapping(value="/confirm", method = RequestMethod.POST)
    public ModelAndView confirmRegistration(ModelAndView modelAndView, BindingResult bindingResult, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {

        modelAndView.setViewName("public/confirm");

        Zxcvbn passwordCheck = new Zxcvbn();

        Strength strength = passwordCheck.measure(requestParams.get("password"));

        if (strength.getScore() < 3) {
            //modelAndView.addObject("errorMessage", "Your password is too weak.  Choose a stronger one.");
            bindingResult.reject("password");

            redir.addFlashAttribute("errorMessage", "Your password is too weak.  Choose a stronger one.");

            modelAndView.setViewName("redirect:confirm?token=" + requestParams.get("token"));
            //	System.out.println(requestParams.get("token"));
            return modelAndView;
        }

        // Find the user associated with the reset token
        User user = userRepo.findByConfirmationToken(requestParams.get("token"));

        // Set new password
        user.setPassword(passwordEncoder.encode(requestParams.get("password")));

        // Set user to enabled
        user.setEnabled(true);

        // Save user
        this.userRepo.save(user);

        modelAndView.addObject("successMessage", "Your password has been set!");
        return modelAndView;
    }

    private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress("arefinsafayat92@gmail.com", "Confirmation for SunSfineFarm Inc."));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Email sending Success!!!");
        } catch (AddressException ae) {
            ae.printStackTrace();
        } catch (MessagingException me) {
            me.printStackTrace();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
