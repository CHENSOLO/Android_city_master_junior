package com.example.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chensolo.liistview.R;


/**
 * Created by Administrator on 2018/1/2.
 */

public class Fragment_three extends Fragment{
    @Nullable
    @Override
    /**
     * 每次创建都会绘制Fragment的View组件时回调该方法
     */
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        /**
         * resource :Fragment需要加载的布局文件
         * root：加载layout的父ViewGroup
         * attactToRoot：false不返回父ViewGroup的文件
         */

        View view = inflater.inflate(R.layout.fragment_one,container,false);
        TextView text=view.findViewById(R.id.text);
        text.setText("第一个Fragment");
        Log.i("Main","Fragment1--onCreatView()");
        return view;
    }

    /**
     * onAttach
     * 当Fragment被添加到Activity时候会回调这个方法，并且只调用依次
     * @param activity
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.i("Main","Fragment1--onAttach()");
    }

    /*
    创建Fragment时会回调只会调用一次
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Main","Frgment--onCreate()");
    }

    /**
     *当Fragment所在的Activity启动完成后调用
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("Main","Frgment1--onActivityCreated()");
    }

    /**
     * 启动Frgament
     */
    @Override
    public void onStart() {
        super.onStart();
        Log.i("Main","Frgament--onStart()");
    }

    /**
     * 恢复Fragment时会被回调，调用onstart方法后面一定会调用onResumen
     */
    @Override
    public void onResume() {
        super.onResume();
        Log.i("Main","Fragment2--onResume");
    }

    /**
     * 暂停Fragment
     */
    @Override
    public void onPause() {
        super.onPause();
        Log.i("Main","Fragment3--onPause");
    }

    /**
     * 停止Fragment
     */
    @Override
    public void onStop() {
        super.onStop();
        Log.i("Main","Fragment4--onStop");
    }

    /*
    销毁Fragemnt所包含的View组件
     */
 @SuppressLint("MissingSuperCall")
    public void onDestroyView() {
        super.onDestroy();
        Log.i("Main","Fragment4--onDestroyView()");
    }

    /**
     * 销毁Frggament时会被回调
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("Main","Fragment4--onDestroy()");
    }

    /**
     * Fragemnt从Actiity删除时会回调该方法
     */
    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("Main","Fragment4--onDetach()");
    }
}
