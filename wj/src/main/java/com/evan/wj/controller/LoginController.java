package com.evan.wj.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.evan.wj.result.Result;
import com.evan.wj.result.ResultFactory;
import com.evan.wj.service.UserService;
import com.evan.wj.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import com.evan.wj.pojo.User;

import java.util.Objects;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,requestUser.getPassword());
      try {
          subject.login(usernamePasswordToken);
          return ResultFactory.buildSuccessResult(usernamePasswordToken);
      }catch (AuthenticationException e){
          String message = "账号密码错误";
          return ResultFactory.buildFailResult(message);
      }

      //    Object obj=userService.selectObj(new EntityWrapper<User>()
      //           .eq(StringUtils.isNotEmpty(username),"username",username)
      //          .eq(StringUtils.isNotEmpty(password),"password",password));
      //   if(obj==null){
      //      return new Result(400);
      //   }else {
      //       return new Result(200);
      //  }
    }
}