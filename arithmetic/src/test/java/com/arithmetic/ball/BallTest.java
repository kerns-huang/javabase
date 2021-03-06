/*
 * huiguan.com Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.arithmetic.ball;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * TODO desc
 *
 * @author huangchunbo
 * @since $$Revision:1.0.0, $$Date: 2017/9/1 11:27 $$
 */
public class BallTest {

    private List<Ball> list;

    @Before
    public void setup() {
        list = new ArrayList<Ball>();
        list.add(new Ball(1l, "红色", 2l, 3l));
        list.add(new Ball(2l, "蓝色"));
        list.add(new Ball(3l, "黄色"));
        list.add(new Ball(4l, "黑色"));
        list.add(new Ball(5l, "白色"));
        Collections.sort(list);
    }

    /**
     * 测试有多少种可能性
     */
    @Test
    public void test() {
        List<Ball> chance = new ArrayList<Ball>();
        for (Ball ball : list) {
            chance.add(ball);
        }

    }




}
