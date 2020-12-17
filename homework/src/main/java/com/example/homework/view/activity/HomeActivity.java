package com.example.homework.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.homework.R;
import com.example.homework.view.fragment.AFragment;
import com.example.homework.view.fragment.BFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private ViewPager pager_home;
    private TabLayout tab_home;
    private ArrayList<Fragment> list;
    private MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        pager_home = (ViewPager) findViewById(R.id.pager_home);
        tab_home = (TabLayout) findViewById(R.id.tab_home);
        list = new ArrayList<>();
        list.add(new AFragment());
        list.add(new BFragment());
        adapter = new MyPagerAdapter(getSupportFragmentManager(), list);
        pager_home.setAdapter(adapter);
        tab_home.setupWithViewPager(pager_home);
        tab_home.getTabAt(0).setText("A页面a");
        tab_home.getTabAt(1).setText("B页面");
    }
}