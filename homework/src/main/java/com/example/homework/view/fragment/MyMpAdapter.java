package com.example.homework.view.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.homework.R;
import com.example.homework.model.bean.MpBean;

import java.util.List;

public class MyMpAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<MpBean.V9LG4E6VRBean> list;

    public MyMpAdapter(Context context, List<MpBean.V9LG4E6VRBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ry_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        MpBean.V9LG4E6VRBean bean = list.get(position);
        viewHolder.ry_item_title.setText(bean.getTitle());
        Glide.with(context).load(bean.getMp4Hd_url()).into(viewHolder.ry_item_image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends MyInfoAdapter.ViewHolder {
        public View rootView;
        public ImageView ry_item_image;
        public TextView ry_item_title;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.ry_item_image = (ImageView) rootView.findViewById(R.id.ry_item_image);
            this.ry_item_title = (TextView) rootView.findViewById(R.id.ry_item_title);
        }

    }
}
