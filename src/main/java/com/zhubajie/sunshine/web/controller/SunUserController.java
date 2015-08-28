package com.zhubajie.sunshine.web.controller;

import com.zhubajie.sunshine.core.entity.FeResponse;
import com.zhubajie.sunshine.web.model.SunShineUser;
import com.zhubajie.sunshine.web.service.userservice.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    public FeResponse<SunShineUser> register(SunShineUser sunShineUser, HttpSession session) {
        FeResponse<SunShineUser> response;

        try {
            userService.addUser(sunShineUser);

            //还是安全点好
            sunShineUser.setPassword("********");

            session.setAttribute("sunShineUser", sunShineUser);
            response = new FeResponse<SunShineUser>(HttpStatus.OK.value(),"注册成功",sunShineUser);
        }catch (Exception e){
            logger.error(e.getMessage());
            response = new FeResponse<SunShineUser>(HttpStatus.NOT_IMPLEMENTED.value(),e.getMessage(),null);
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
    public FeResponse<Boolean> login(SunShineUser sunShineUser, HttpSession session){
        FeResponse<Boolean> response;

        try{
            boolean success = userService.login(sunShineUser);

            //还是安全点好
            sunShineUser.setPassword("********");

            session.setAttribute("sunShineUser", sunShineUser);
            response = new FeResponse<Boolean>(HttpStatus.OK.value(),"登录成功",success);
        }catch (Exception e){
            logger.error(e.getMessage());
            response = new FeResponse<Boolean>(HttpStatus.NOT_IMPLEMENTED.value(), e.getMessage(),null);
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

        if (session.getAttribute("sunShineUser") != null){
            response = new FeResponse<SunShineUser>(HttpStatus.OK.value(),"已登录",(SunShineUser)session.getAttribute("sunShineUser"));
        }else {
            response = new FeResponse<SunShineUser>(HttpStatus.NOT_EXTENDED.value(), "未登录", null);
        }

        return response;
    }

    /**
     * 根据id得到用户信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public FeResponse<SunShineUser> getUserById(@PathVariable String userId){
        FeResponse<SunShineUser> response;

        try{
            SunShineUser sunShineUser = userService.getUserById(Integer.parseInt(userId));

            //还是安全点好
            sunShineUser.setPassword("********");

            response = new FeResponse<SunShineUser>(HttpStatus.OK.value(),"查找成功", sunShineUser);
        }catch (Exception e){
            logger.error(e.getMessage());
            response = new FeResponse<SunShineUser>(HttpStatus.NOT_IMPLEMENTED.value(),e.getMessage(),null);
        }
        return response;
    }

    /**
     * 根据名字模糊查找用户
     * @param nickname
     * @return
     */
    @RequestMapping(value = "/queryUserByName", method = RequestMethod.GET)
    @ResponseBody
    public FeResponse<List> queryUserByName(String nickname){
        FeResponse<List> response;

        try{
            List<SunShineUser> sunShineUsers = userService.queryUserByName(nickname);

            response = new FeResponse<List>(HttpStatus.OK.value(),"查找成功", sunShineUsers);
        }catch (Exception e){
            logger.error(e.getMessage());
            response = new FeResponse<List>(HttpStatus.NOT_IMPLEMENTED.value(),e.getMessage(),null);
        }

        return response;
    }

}
