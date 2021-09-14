package com.example.entity;

public class SearchInfo {
    private int ID;
    private String title;
    private String date;

    public SearchInfo(int ID, String title, String date) {
        this.ID = ID;
        this.title = title;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SearchInfo{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
