package com.example.p7day01;

public class PhoneFactory {

    public Phone cratePhone(String type) {
        if (type.equals("miPhone")) {
            return new MiPhone();
        } else if (type.equals("iPhone")) {
            return new Iphone();
        }
        return null;
    }

}
