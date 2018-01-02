package com.example.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chensolo.liistview.R;


/**
 * Created by Administrator on 2018/1/2.
 */

public class Fragment_two extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        /**
         * resource :Fragment需要加载的布局文件
         * root：加载layout的父ViewGroup
         * attactToRoot：false不返回父ViewGroup的文件
         */

        View view = inflater.inflate(R.layout.fragment_one,container,false);
        TextView text=view.findViewById(R.id.text);
        text.setText("动态加载Fragment");
        return view;
    }
}
