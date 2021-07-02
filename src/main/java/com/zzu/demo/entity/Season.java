package com.zzu.demo.entity;

public enum Season {
    Spring("春天"), Summer("夏天"), Autumn("秋天"), Winter("冬天");

    private String name;

    Season(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
