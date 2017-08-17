package com.nlp.controller;

import com.alibaba.fastjson.JSONObject;
import com.nlp.model.User;
import com.nlp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WSnL on 2017/8/16.
 */

@RestController
@RequestMapping("/controller/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        System.out.println("1");
    }

    //模拟请求命令： curl -X POST -H "Content-Type: application/json" -d "{\"name\": \"xiaohong\",\"password\": \"123456\"}" "http://localhost:8080/controller/user/"
    @PostMapping("")
    public Object add(@RequestBody User user) {
        if (userService.findByName(user.getName()) != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("message","用户名已被使用");
            return jsonObject;
        }
        return userService.add(user);
    }

}
