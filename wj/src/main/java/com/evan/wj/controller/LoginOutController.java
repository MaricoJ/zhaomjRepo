package com.evan.wj.controller;

import com.evan.wj.result.Result;
import com.evan.wj.result.ResultFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginOutController {
    @CrossOrigin
    @ResponseBody
    @GetMapping("api/logout")
    public Result loginOut(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        String message = "成功登出";
        return ResultFactory.buildSuccessResult(message);
    }
}
