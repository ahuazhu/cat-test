package com.smzdm.caller;

/**
 * Created by zhengwenzhu on 16/10/13.
 */
public class TestResult {
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return String.format("[id=%d, name=%s]", id, name);
    }
}
