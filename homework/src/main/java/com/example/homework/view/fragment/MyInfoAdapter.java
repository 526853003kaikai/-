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
import com.example.homework.model.bean.RyBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

public class MyInfoAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<RyBean.Data.DatasBean> list;
    private int VIEW_TYPE_BANNER = 0;
    private int VIEW_TYPE_RY = 1;

    public MyInfoAdapter(Context context, List<RyBean.Data.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_BANNER;
        } else {
            return VIEW_TYPE_RY;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == VIEW_TYPE_BANNER) {
            view = LayoutInflater.from(context).inflate(R.layout.banner_item, parent, false);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.ry_item, parent, false);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        if (type == VIEW_TYPE_BANNER) {
            viewHolder.banner_item_image.setImages(list)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            RyBean.Data.DatasBean bean = (RyBean.Data.DatasBean) path;
                            Glide.with(context).load(bean.getEnvelopePic()).into(imageView);
                        }
                    }).start();
        }else {
            RyBean.Data.DatasBean ryBean = list.get(position - 1);
            viewHolder.ry_item_title.setText(ryBean.getTitle());
            Glide.with(context).load(ryBean.getEnvelopePic()).into(viewHolder.ry_item_image);
        }
    }

    @Override
    public int getItemCount() {
        return list.size()+1;
    }


    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public Banner banner_item_image;
        public ImageView ry_item_image;
        public TextView ry_item_title;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.banner_item_image = (Banner) rootView.findViewById(R.id.banner_item_image);
            this.ry_item_image = (ImageView) rootView.findViewById(R.id.ry_item_image);
            this.ry_item_title = (TextView) rootView.findViewById(R.id.ry_item_title);
        }

    }
}
