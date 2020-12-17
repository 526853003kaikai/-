package com.example.homework.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework.R;
import com.example.homework.model.bean.ApiService;
import com.example.homework.model.bean.TabBean;
import com.example.homework.view.activity.MyPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class AFragment extends Fragment {

    private ViewPager pager;
    private TabLayout tab;
    private ArrayList<Fragment> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        new Retrofit.Builder().baseUrl(ApiService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(ApiService.class)
                .getTab().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TabBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TabBean value) {
                        List<TabBean.Data> data = value.getData();
                        for (int i = 0; i < data.size(); i++) {
                            FragFragment fragFragment = new FragFragment();
                            Bundle bundle = new Bundle();
                            bundle.putInt("id", data.get(i).getId());
                            fragFragment.setArguments(bundle);
                            list.add(fragFragment);
                        }

                        MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager(), list);
                        pager.setAdapter(adapter);
                        tab.setupWithViewPager(pager);
                        for (int i = 0; i < data.size(); i++) {
                            tab.getTabAt(i).setText(data.get(i).getName());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View view) {
        tab = view.findViewById(R.id.tab_fragmentA);
        pager = view.findViewById(R.id.pager_fragmentA);
        list = new ArrayList<>();
    }
}