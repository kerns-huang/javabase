/*
 * huiguan.com Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.rpc.main;

import com.rpc.base.service.Server;
import com.rpc.base.service.impl.ServiceCenter;
import com.rpc.client.RPCClient;
import com.rpc.demo.service.HelloService;
import com.rpc.demo.service.impl.HelloServiceImpl;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * TODO desc
 *
 * @author huangchunbo
 * @since $$Revision:1.0.0, $$Date: 2017/7/28 13:53 $$
 */
public class RPCTest {

    public static void main(String[] args) throws IOException {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Server serviceServer = new ServiceCenter(8088);
                    serviceServer.register(HelloService.class, HelloServiceImpl.class);
                    serviceServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        HelloService service = RPCClient
                .getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 8088));
        System.out.println(service.sayHi("test"));
    }
}
