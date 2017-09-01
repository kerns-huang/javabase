/*
 * huiguan.com Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.arithmetic.ball;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO desc
 *
 * @author huangchunbo
 * @since $$Revision:1.0.0, $$Date: 2017/9/1 11:21 $$
 */
@Setter
@Getter
public class Ball implements Comparable<Ball> {

    private Long id;

    private String name;

    private List<Long> mutexIdList;

    public Ball(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Ball(Long id, String name, Long... mutexIds) {
        this.id = id;
        this.name = name;
        mutexIdList = new ArrayList<Long>();
        for (Long mutexId : mutexIds) {
            mutexIdList.add(mutexId);
        }
    }

    @Override
    public String toString() {
        return "Ball{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mutexIds=" + mutexIdList +
                '}';
    }

    @Override
    public int compareTo(Ball o) {
        return 0;
    }
}
