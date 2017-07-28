/*
 * huiguan.com Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.rpc.demo.service.impl;

import com.rpc.demo.service.HelloService;

/**
 * TODO desc
 *
 * @author huangchunbo
 * @since $$Revision:1.0.0, $$Date: 2017/7/28 13:33 $$
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHi(String name) {
       return "hello,"+name;
    }
}
