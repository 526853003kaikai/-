package com.example.homework.presenter;

import android.content.Context;

import com.example.homework.callback.MyCallBack;
import com.example.homework.model.MyModel;
import com.example.homework.view.IView;

public class MyPresenter {
    private IView mView;
    private MyModel myModel;

    public MyPresenter(IView mView) {
        this.mView = mView;
        myModel = new MyModel();
    }

    public void start(Context context,int page,int cid) {
        myModel.getData(context, page, cid, new MyCallBack() {
            @Override
            public void successData(Object object) {
                mView.successUi(object);
            }

            @Override
            public void fileData(String msg) {
                mView.fileUi(msg);
            }
        });
    }
}
