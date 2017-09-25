/*
 * huiguan.com Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package rule;

/**
 * 规则pojo类
 *
 * @author huangchunbo
 * @since $$Revision:1.0.0, $$Date: 2017/9/25 17:47 $$
 */

public  abstract class Rule implements Comparable<Rule>{

    private Long id;

    private int priority;

    private boolean exclusive;

    private boolean multipleTimes;

    private String description;

    private String title;

    private String type;

    private boolean vaild;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isExclusive() {
        return exclusive;
    }

    public void setExclusive(boolean exclusive) {
        this.exclusive = exclusive;
    }

    public boolean isMultipleTimes() {
        return multipleTimes;
    }

    public void setMultipleTimes(boolean multipleTimes) {
        this.multipleTimes = multipleTimes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isVaild() {
        return vaild;
    }

    public void setVaild(boolean vaild) {
        this.vaild = vaild;
    }
}
