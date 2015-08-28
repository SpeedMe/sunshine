package com.zhubajie.sunshine.web.controller;

import com.zhubajie.sunshine.core.entity.FeResponse;
import com.zhubajie.sunshine.web.model.SunShineUser;
import com.zhubajie.sunshine.web.service.userservice.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author: HuangLei
 * date: 2015/8/27
 */
@Controller
@RequestMapping("/sunUser")
public class SunUserController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource(name = "userService")
    private UserService userService;

    /**
     * 注册
     * @param sunShineUser
     * @param session
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public FeResponse<SunShineUser> register(@RequestBody SunShineUser sunShineUser, HttpSession session) {
        FeResponse<SunShineUser> response;

        System.out.println("**************************");
        System.out.println("nickname: " + sunShineUser.getNickname());
        System.out.println("email: " + sunShineUser.getEmail());
        System.out.println("password: " + sunShineUser.getPassword());

        try {
            userService.addUser(sunShineUser);
            session.setAttribute("sunShineUser", sunShineUser);
            response = new FeResponse<SunShineUser>(HttpStatus.OK.value(),"注册成功");
        }catch (Exception e){
            logger.error(e.getMessage());
            response = new FeResponse<SunShineUser>(HttpStatus.NOT_IMPLEMENTED.value(),e.getMessage());
        }

        return response;
    }

    /**
     * 登录
     * @param sunShineUser
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public FeResponse<String> login(@RequestBody SunShineUser sunShineUser, HttpSession session){
        FeResponse<String> response;

        try{
            userService.login(sunShineUser);
            session.setAttribute("sunShineUser", sunShineUser);
            response = new FeResponse<String>(HttpStatus.OK.value(),"登录成功");
        }catch (Exception e){
            logger.error(e.getMessage());
            response = new FeResponse<String>(HttpStatus.NOT_IMPLEMENTED.value(), e.getMessage());
        }

        return response;
    }

    /**
     * 获取登录状态
     * @param session
     * @return
     */
    @RequestMapping(value = "/loginState", method = RequestMethod.GET)
    @ResponseBody
    public FeResponse<SunShineUser> getLoginState(HttpSession session){
        FeResponse<SunShineUser> response;

        if (session != null){
            response = new FeResponse<SunShineUser>(HttpStatus.OK.value(),"已登录",(SunShineUser)session.getAttribute("sunShineUser"));
        }else {
            response = new FeResponse<SunShineUser>(HttpStatus.NOT_EXTENDED.value(), "未登录", null);
        }

        return response;
    }
}
