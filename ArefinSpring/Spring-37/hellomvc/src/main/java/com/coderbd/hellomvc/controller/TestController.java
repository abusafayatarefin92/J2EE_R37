package com.coderbd.hellomvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    @GetMapping(value = "/tt")
    public @ResponseBody String test(@RequestParam(value = "ms", required = true,
            defaultValue = "Hello World") String msg){
        return msg;
    }

}
