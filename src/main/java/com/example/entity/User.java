package com.example.entity;

public class User {
    private int ID;
    private String username;
    private String password;
    private int identify;

    public int getIdentify() {
        return identify;
    }

    public void setIdentify(int identify) {
        this.identify = identify;
    }

    public User(int ID, String username, String password, int identify) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.identify = identify;
    }

    public User() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin(){
        if (this.identify>1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", identify=" + identify +
                '}';
    }
}
