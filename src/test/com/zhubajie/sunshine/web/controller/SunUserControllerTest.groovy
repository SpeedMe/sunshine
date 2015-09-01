package com.zhubajie.sunshine.web.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext
import spock.lang.Specification

import javax.annotation.Resource

/**
 * @description:
 * @author: HuangLei
 * date: 2015/9/1
 */
class SunUserControllerTest extends Specification {

    @Autowired
    private SunUserController sunUserController;

    private ApplicationContext ac = null;

    void setup() {
        ac = new ClassPathXmlApplicationContext("config/spring.xml");
        sunUserController = ac.getBean("sunUserController");
    }

    def "GetUserById"() {
        expect:
        println (sunUserController.getUserById("19").toString());
    }
}
