package cn.ylj.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : yanglujian
 * create at:  2021/1/21  6:00 下午
 */
@RestController
@RequestMapping("/user")
public class UserController {

    //调用此方法要求当前用户必须具有add权限
    @PreAuthorize("hasAuthority('add')")
    @RequestMapping("/add")
    public String addInfo(){
        System.out.println("添加用户");
        return "add success";
    }

    //该方法需要ROLE_ADMIN角色
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/delete")
    public String delete(){
        System.out.println("删除用户成功");
        return "delete success";
    }
}