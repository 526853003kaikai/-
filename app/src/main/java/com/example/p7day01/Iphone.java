package com.example.p7day01;

import android.util.Log;

public class Iphone implements Phone {
    @Override
    public void makePhone() {
        Log.e("TAG","制造苹果手机");
    }
}
