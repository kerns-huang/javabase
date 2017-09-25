/*
 * huiguan.com Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.javascript;
import java.util.Date;
/**
 * TODO desc
 *
 * @author huangchunbo
 * @since $$Revision:1.0.0, $$Date: 2017/9/25 17:22 $$
 */
public class Item {

    private Long id;

    private Date dishTimes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDishTimes() {
        return dishTimes;
    }

    public void setDishTimes(Date dishTimes) {
        this.dishTimes = dishTimes;
    }
}
