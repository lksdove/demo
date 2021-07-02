package com.zzu.demo.entity;

/**
 * @author 14377
 */
public enum SexEnum {
    FEMAL(1, "女"),
    MALE(0, "男"),
    OTHER(2, "其他");
    private int a;
    private String sex;

    SexEnum(int a, String sex) {
        this.a = a;
        this.sex = sex;
    }

    public static SexEnum getABySex(String sex) {
        SexEnum[] values = SexEnum.values();
        for (SexEnum sexEnum : values
        ) {
            if (sexEnum.getSex().equals(sex)) {
                return sexEnum;
            }
        }
        return null;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public int getA() {
        return a;
    }
}
