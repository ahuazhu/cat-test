package com.smzdm.cat;

import com.dianping.cat.Cat;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhengwenzhu on 16/10/12.
 */
public class Context implements Cat.Context {

    Map<String, String> map = new HashMap<String, String>();

    public void addProperty(String key, String value) {
        map.put(key, value);
    }

    public String getProperty(String key) {
        return map.get(key);
    }

    public Map<String, String> getMap() {
        return map;
    }
}
