package com.example.homework.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework.R;
import com.example.homework.model.bean.RyBean;
import com.example.homework.presenter.MyPresenter;
import com.example.homework.view.IView;

import java.util.ArrayList;
import java.util.List;

public class FragFragment extends Fragment implements IView {
    private RecyclerView ry_list;
    private ArrayList<RyBean.Data.DatasBean> list;
    private FragmentActivity activity;
    private MyInfoAdapter adapter;
    private MyPresenter myPresenter;
    private int page;
    private int id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        id = (int) arguments.get("id");
        activity = getActivity();
        View view = inflater.inflate(R.layout.fragment_frag, container, false);
        myPresenter = new MyPresenter(this);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        myPresenter.start(getContext(),page,id);
    }

    private void initView(View view) {
        ry_list = view.findViewById(R.id.ry_list);

        ry_list.setLayoutManager(new LinearLayoutManager(activity));

        list = new ArrayList<>();
        adapter = new MyInfoAdapter(activity,list);

        ry_list.setAdapter(adapter);
        ry_list.addItemDecoration(new DividerItemDecoration(activity,DividerItemDecoration.VERTICAL));
    }

    @Override
    public void successUi(Object object) {
        if(object instanceof RyBean){
            RyBean bean = (RyBean) object;
            List<RyBean.Data.DatasBean> beans = bean.getData().getDatas();
            list.addAll(beans);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void fileUi(String msg) {

    }
}