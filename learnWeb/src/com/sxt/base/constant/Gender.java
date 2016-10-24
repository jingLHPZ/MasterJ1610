package com.sxt.base.constant;

public enum Gender {
    UNKNOWN("未知"),
    MALE("男"),
    FEMALE("女");

    private String label;

    private Gender(String label) {
        this.label = label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String label() {
        return this.label;
    }

}
