package com.evan.wj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zeromq.ZMQ;

import java.util.Map;

@Controller
public class TestController {
    @ResponseBody
    @PostMapping(value = "api/device/testPub")
    public String debug(@RequestBody Map<String,String> params) {
        int types = Integer.valueOf(params.get("type"));
        if(types==3){
            params.remove("label");
        }
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(types);
        socket.connect(params.get("ipaddress"));
        socket.send(params.get("json").getBytes());
        byte[] response = socket.recv();
      //  System.out.println("Request recv1:\t" + new String(response));
        //关闭
        socket.close();
        context.term();
        return new String(response);
    }
}