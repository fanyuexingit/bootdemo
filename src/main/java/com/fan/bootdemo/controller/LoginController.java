/**
 * @description:
 * @author: Andy
 * @time: 2021/02/24 15:28
 */
package com.fan.bootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fanyuexin on 2021/02/24
 */
@Controller
public class LoginController {
//    @GetMapping(value = "/test")
//    public String test(Model model){
//        model.addAttribute("name", "fanyuexin");
//        return "test";
//    }

    @GetMapping(value = "/login")
    @ResponseBody
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model){



        return "login";
    }
}
