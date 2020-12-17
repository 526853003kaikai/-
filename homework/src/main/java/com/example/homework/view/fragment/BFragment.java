package com.example.homework.view.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;

import com.example.homework.R;
import com.example.homework.model.bean.ApiService;
import com.example.homework.model.bean.MpBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BFragment extends Fragment {

    private RecyclerView ry_list;
    private FragmentActivity activity;
    private MyMpAdapter adapter;
    private ArrayList<MpBean.V9LG4E6VRBean> list;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = getActivity();
        context = getContext();
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        OkHttpClient getOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .removeHeader("User—Agent")
                                .addHeader("User—Agent", WebSettings.getDefaultUserAgent(context))
                                .build();
                        return chain.proceed(request);
                    }
                }).build();

        new Retrofit.Builder().baseUrl(ApiService.BURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkHttpClient)
                .build().create(ApiService.class)
                .getMp().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MpBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MpBean value) {
                        List<MpBean.V9LG4E6VRBean> beanList = value.getV9LG4E6VR();
                        list.addAll(beanList);
                        adapter.notifyDataSetChanged();
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
        ry_list = view.findViewById(R.id.ry_list_fragmentB);

        list = new ArrayList<>();
        adapter = new MyMpAdapter(activity, list);
        ry_list.setLayoutManager(new LinearLayoutManager(activity));
        ry_list.addItemDecoration(new DividerItemDecoration(activity,DividerItemDecoration.VERTICAL));
        ry_list.setAdapter(adapter);
    }
}