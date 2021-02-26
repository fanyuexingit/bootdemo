/**
 * @description:
 * @author: Andy
 * @time: 2021/02/24 15:28
 */
package com.fan.bootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model, HttpSession session){
        if (!StringUtils.isEmpty(username) && "admin123".equals(password)){
            session.setAttribute("loginSession", username);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg", "用户名或密码为空");
            return "login";
        }

    }
}
