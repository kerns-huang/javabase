/*
 * huiguan.com Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.javascript;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
/**
 * TODO desc
 *
 * @author huangchunbo
 * @since $$Revision:1.0.0, $$Date: 2017/9/25 11:32 $$
 */
public class Engine {

    public static  void main(String[] args) throws Exception {
        ScriptEngineManager scriptEngineManager=new ScriptEngineManager();
        ScriptEngine nashorn=scriptEngineManager.getEngineByName("nashorn");
        InputStream inputStream= Engine.class.getResourceAsStream("/strategy.js");
        InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"UTF-8");
        nashorn.eval(inputStreamReader);
        Invocable invocable = (Invocable) nashorn;
        Map strategy=new HashMap();
        List<String> specifiedDayList=new ArrayList<String>();
        specifiedDayList.add("2017-09-25");
        specifiedDayList.add("2017-09-27");
        strategy.put("specifiedDays",specifiedDayList);
        List<Long> productIdList=new ArrayList<Long>();
        productIdList.add(1l);
        strategy.put("productIds",productIdList);
        List<Integer> dayOfWeekList=new ArrayList<Integer>();
        dayOfWeekList.add(2);
        strategy.put("daysOfWeek",dayOfWeekList);

        Item input=new Item();
        input.setId(1l);
        input.setDishTimes(new Date());
        Object result = invocable.invokeFunction("item", input,strategy);
        Map map=(Map)result;
        System.out.println(map.get("errorCode"));
        System.out.println(result.getClass());


    }
}
