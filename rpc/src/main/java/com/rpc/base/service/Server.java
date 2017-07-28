/*
 * huiguan.com Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.rpc.base.service;

import java.io.IOException;

/**
 * TODO desc
 *
 * @author huangchunbo
 * @since $$Revision:1.0.0, $$Date: 2017/7/28 13:35 $$
 */
public interface Server {
    //TODO 服务停止
    public void stop();
    //TODO 服务启动
    public void start() throws IOException;
    //TODO 服务注册
    public void register(Class serviceInterface, Class impl);
    //TODO 检测服务是否运行着
    public boolean isRunning();
    //TODO 获取端口号
    public int getPort();
}
