package com.smzdm.callee.com.smzdm.monitor;

import com.dianping.cat.status.StatusExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by zhengwenzhu on 2016/11/8.
 */
public class Monitor implements StatusExtension {
    public String getId() {
        return "Test";
    }

    public String getDescription() {
        return "";
    }

    public Map<String, String> getProperties() {
        Map<String, String> status = new LinkedHashMap<String, String>();

        String id = "Test";
        status.put(id + "-1", Integer.toString(new Random().nextInt(30)));
        status.put(id + "-2", Integer.toString(new Random().nextInt(30)));
        status.put(id + "-3", Integer.toString(new Random().nextInt(30)));

        return status;
    }
}
