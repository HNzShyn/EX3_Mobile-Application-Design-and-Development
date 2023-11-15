package com.example.ex3;

public class Contact {

    private int id;
    private String name;
    private String dob;
    private String phone;
    private String email;
    private byte[] image;

    public Contact() {
    }

    public Contact(String name, String dob, String phone, String email, byte[] image) {
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}

