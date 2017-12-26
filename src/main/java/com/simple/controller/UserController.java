package com.simple.controller;

import com.simple.common.ServerResponse;
import com.simple.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Create by S I M P L E on 2017/12/26
 */
@RequestMapping(value = "/user/")
@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    //注册
    @RequestMapping(value = "register.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> register(@RequestBody Map map) {
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        String email = (String) map.get("email");
        String phone = (String) map.get("phone");
        String question = (String) map.get("question");
        String answer = (String) map.get("answer");
        return iUserService.register(username, password, question, answer, phone, email);
    }
}
