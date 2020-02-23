package com.androidclass.contactlist;

import java.util.ArrayList;

public class Contact {
    String name,address,phone,email,age;
    ArrayList<String> info;

    public Contact(String name, String address, String phone, String email, String age) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.age = age;
        makeList();
    }

    private void makeList(){
        info = new ArrayList<>();
        info.add(name);
        info.add(address);
        info.add(phone);
        info.add(email);
        info.add(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getInfo(int index) {
        return info.get(index);
    }
}
