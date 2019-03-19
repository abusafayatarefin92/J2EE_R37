package com.stssecuritycrud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.stssecuritycrud.entity.User;
import com.stssecuritycrud.repository.UserRepo;

@Controller
public class HomeController {
	@Autowired
    private UserRepo userRepo;
	
	@GetMapping(value="/dashboard")
	public String dashboard(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        User user = userRepo.findByUsername(auth.getName());
        model.addAttribute("name", user.getName());
		return "dashboard";
	}
}
