package com.arefin.webmvcthymeleaf.controller;

import com.arefin.webmvcthymeleaf.entity.User;
import com.arefin.webmvcthymeleaf.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    private UserRepo userRepo;

//    @GetMapping(value = "/")
//    public ModelAndView index(){
//        ModelAndView mv = new ModelAndView();
//       // mv.addObject("title", "Home ! SunShine Farm Inc");
//        mv.addObject("user", new User());
//        mv.setViewName("index");
//        return mv;
//    }
//
//    @PostMapping(value = "/")
//    public ModelAndView add(@Valid User user){
//        ModelAndView mv = new ModelAndView();
//        //mv.addObject("title", "Home ! SunShine Farm Inc");
//        if(user.getName() != null){
//            this.userRepo.save(user);
//            mv.addObject("successmsg", "Successfully Saved");
//            mv.addObject("user", new User());
//        }
//        mv.setViewName("index");
//        return mv;
//    }


}
