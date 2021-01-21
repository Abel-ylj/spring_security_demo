package cn.ylj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : yanglujian
 * create at:  2021/1/21  2:17 下午
 */
@RestController
public class LoginController {

    //当form中action="/login.do"触发时，不会传到这里来
    //login-processing-url="/login.do" 是给框架的，给框架处理登录的逻辑取的路径
    @RequestMapping("/login")
    public String login(){
        System.out.println("账号密码认证通过。。。");
        return "ROLE_ADMIN";
    }
}