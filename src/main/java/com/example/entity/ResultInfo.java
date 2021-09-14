package com.example.entity;

public class ResultInfo {
    private int ID;
    private String title;
    private String author;
    private String text;
    private String time;
    private int zan;
    public ResultInfo(int ID, String title, String author, String text, String time,int zan) {
        this.ID = ID;
        this.title = title;
        this.author = author;
        this.text = text;
        this.time = time;
        this.zan = zan;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
