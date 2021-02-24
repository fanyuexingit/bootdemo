/**
 * @description:
 * @author: Andy
 * @time: 2021/02/24 15:28
 */
package com.fan.bootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by fanyuexin on 2021/02/24
 */
@Controller
public class Test {

    @GetMapping(value = "/test")
    public String test(Model model){
        model.addAttribute("name", "fanyuexin");
        return "test";
    }
}
