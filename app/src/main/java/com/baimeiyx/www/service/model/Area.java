package com.baimeiyx.www.service.model;

public class Area {
    private String name;
    private int id;
    private String code;

    public Area(String name, int id, String code) {
        this.code = code;
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
