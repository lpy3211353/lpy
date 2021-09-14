package com.example.entity;

public class IndexInfo {
    private int ID;
    private String title;
    private String img;
    private int zan;

    public IndexInfo() {
    }

    public IndexInfo(int ID, String title, String img, int zan) {
        this.ID = ID;
        this.title = title;
        this.img = img;
        this.zan = zan;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getID(){
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getZan() {
        return zan;
    }

    public void setZan(int zan) {
        this.zan = zan;
    }
    
    @Override
    public String toString() {
        return "IndexInfo{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", zan=" + zan +
                '}';
    }
}
