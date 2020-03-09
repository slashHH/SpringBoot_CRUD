package com.slash.springboot.controller;

import com.slash.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session) {

        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        } else {
            map.put("msg","用户和密码错误！");
            return "login";
        }
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String User(@RequestParam("user") String username){
        if (username.equals("aaa")){
            throw new UserNotExistException();
        }
        return "Wrong user!";
    }
}
