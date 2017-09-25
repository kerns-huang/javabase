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

/**
 * @TODO 美团的规则引擎是怎么做的？
 *https://tech.meituan.com/maze-framework.html
 * @author huangchunbo
 * @since $$Revision:1.0.0, $$Date: 2017/9/25 11:32 $$
 */
public class Engine {

    public static void main(String[] args) throws Exception {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");//jdk 8才引入的，比v8引擎稍微差点
        InputStream inputStream = Engine.class.getResourceAsStream("/hello.js");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        nashorn.eval(inputStreamReader);
        Invocable invocable = (Invocable) nashorn;
        invocable.invokeFunction("hello", "Peter Parker");
    }
}
