package com.example.entity;


public class Msg {
    private int res;
    private String text;
    private Object data;

    public Msg(int res, String text, Object data) {
        this.res = res;
        this.text = text;
        this.data = data;
    }

    public Msg() {
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "res=" + res +
                ", text='" + text + '\'' +
                ", data=" + data +
                '}';
    }
}
