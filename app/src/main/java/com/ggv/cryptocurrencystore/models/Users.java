package com.ggv.cryptocurrencystore.models;

public class Users {
    private String Username;
    private String Name;
    private String Email;

    public Users(){

    }

    public Users(String Username, String Name, String Email){
        this.Username = Username;
        this.Name = Name;
        this.Email = Email;

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
