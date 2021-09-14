package com.example.entity;

public class ContentInfo {
    private int ID;
    private String username;
    private String time;
    private String text;
    private int zan;

    public ContentInfo() {
    }

    public ContentInfo(int ID, String username, String time, String text, int zan) {
        this.ID = ID;
        this.username = username;
        this.time = time;
        this.text = text;
        this.zan = zan;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getZan() {
        return zan;
    }

    public void setZan(int zan) {
        this.zan = zan;
    }

    @Override
    public String toString() {
        return "ContentInfo{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", time='" + time + '\'' +
                ", text='" + text + '\'' +
                ", zan='" + zan + '\'' +
                '}';
    }
}
