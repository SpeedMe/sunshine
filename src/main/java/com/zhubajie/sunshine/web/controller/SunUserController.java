package com.zhubajie.sunshine.web.controller;

import com.zhubajie.sunshine.web.model.SunShineUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author: HuangLei
 * date: 2015/8/27
 */
@Controller
@RequestMapping("/sunUser")
public class SunUserController {

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public SunShineUser register(@RequestBody SunShineUser sunShineUser, HttpSession session) {
        System.out.println("**************************");
        System.out.println("nickname: " + sunShineUser.getNickname());
        System.out.println("email: " + sunShineUser.getEmail());
        System.out.println("password: " + sunShineUser.getPassword());

        session.setAttribute("user", sunShineUser);

        return sunShineUser;
    }
}
