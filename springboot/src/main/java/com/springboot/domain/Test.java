package com.springboot.domain;

public class Test {
    private String x;
    private String y;
    private String value;

    public Test() {
    }

    public Test(String x, String y, String value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Test{" +
                "x='" + x + '\'' +
                ", y='" + y + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
