package com.ggv.cryptocurrencystore.models;

public class Users {
    private String Username;
    private String Name;
    private String Email;

    public Users(){

    }

    public Users(String username, String name, String email){
        this.Username = username;
        this.Name = name;
        this.Email = email;

    }



    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


}
