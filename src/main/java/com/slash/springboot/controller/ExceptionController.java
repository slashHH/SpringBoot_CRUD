package com.slash.springboot.controller;

import com.slash.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler({UserNotExistException.class})
    public String myException(Exception e,HttpServletRequest request){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        request.setAttribute("javax.servlet.error.status_code","500");
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
