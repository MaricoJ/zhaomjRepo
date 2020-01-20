package com.evan.wj.controller;

import org.zeromq.ZMQ;

public class debug {
    public static void main(String[] args) {
            ZMQ.Context context = ZMQ.context(1);
            ZMQ.Socket socket = context.socket(ZMQ.REQ);
            socket.connect("tcp://127.0.0.1:8443");
            String rsi = "{\"type\":102,\"rsi_type\":1,\"rsi_level\":1,\"rsi_content\":\"test\",\"latitude\":2,\"longitude\":3,\"sendtime\":\"2019-12-23 09:19:21\",\"event_position\":\"test\",\"event_radius\":1,\"media_type\":1,\"media_url\":\"\"}";
            String rsm = "{\"type\":103,\"elevation\":1,\"latitude\":2,\"longitude\":3,\"rsm_type\":1,\"rsm_level\":1,\"sendtime\":\"2019-12-23 09:19:21\",\"rsm_content\":\"test\",\"detect_type\":1,\"partner_num\":1,\"partner_ids\":1,\"partner_type\":1,\"plateno\":\"粤B\",\"gpstime\":\"2019-12-23 09:37:45\",\"vehicle_elevation\":1,\"vehicle_longitude\":1,\"vehicle_latitude\":1,\"speed\":1,\"heading\":1,\"acc_lng\":1,\"vehicle_width\":1,\"vehicle_len\":1,\"media_type\":1,\"media_url\":\"\"}";
            socket.send(rsi.getBytes());
            byte[] response = socket.recv();
            System.out.println("Request recv1:\t" + new String(response));
            socket.send(rsm.getBytes());
            byte[] response2 = socket.recv();
            System.out.println("Request recv2:\t" + new String(response2));
            //关闭
          //  socket.close();
          //  context.term();
        }
    }

