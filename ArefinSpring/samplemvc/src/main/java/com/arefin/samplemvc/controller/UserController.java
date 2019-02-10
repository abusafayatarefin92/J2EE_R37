package com.arefin.samplemvc.controller;

import com.arefin.samplemvc.entity.User;
import com.arefin.samplemvc.image.ImageOptimizer;
import com.arefin.samplemvc.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Controller
public class UserController {
    //Save the uploaded file to this folder
    private static final String UPLOADED_FOLDER = "D:/git/J2EE_R37/ArefinSpring/samplemvc/src/main/resources/static/images";

    @Autowired
    private ImageOptimizer imageOptimizer;

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("list", this.userRepo.findAll());
        this.userRepo.findAll().forEach((c)->{
            System.out.println(c.toString());
        });
        return "index";
    }

    @GetMapping(value = "/add")
    public String showAddUser(User user){
        return "add-user";
    }

    @PostMapping(value = "/add")
    public String addUser(@Valid User user, BindingResult bindingResult, Model model, @RequestParam("file")MultipartFile file){
        if(bindingResult.hasErrors()){
            return "add-user";
        }
        user.setRegiDate(new Date());

        try {
            //////////////////////For Image Upload start /////////////////////
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());

            Files.write(path, bytes);
            user.setFileName("new-" + file.getOriginalFilename());
            user.setFileSize(file.getSize());
            user.setFilePath("images/" + "new-" + file.getOriginalFilename());
            user.setFileExtention(file.getContentType());
            //////////////////////For Image Upload end/////////////////////
            this.userRepo.save(user);
            model.addAttribute("user", new User());
            model.addAttribute("successmsg", "You Have Successfully add user");
            imageOptimizer.optimizeImage(UPLOADED_FOLDER, file,  1.0f, 100, 100);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "add-user";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        if(id != null){
            this.userRepo.deleteById(id);
        }
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String editView(Model model, @PathVariable("id") Long id){
        model.addAttribute("user", this.userRepo.getOne(id));
        return "edit-user";
    }

    @PostMapping(value = "/edit/{id}")
    public String edit(@Valid User user, BindingResult bindingResult, @PathVariable("id") Long id){
       if(bindingResult.hasErrors()){
           return "edit-user";
       }
       this.userRepo.save(user);
       return "redirect:/";
    }
}
