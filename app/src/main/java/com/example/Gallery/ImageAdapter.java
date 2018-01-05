package com.example.Gallery;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * Created by Administrator on 2018/1/4.
 */

public class ImageAdapter extends BaseAdapter {
private int[]res;
private Context context;
    public ImageAdapter(int []res,Context context) {

        this.res = res;
        this.context = context;
    }

    //返回数据源的长度
    @Override
    public int getCount() {
       // return res.length;
        //加载最大值无限循环
        return Integer.MAX_VALUE;
    }

    @Override
    public Object getItem(int position) {
    return res[position];


    }

    @Override
    public long getItemId(int position) {
        return position;

    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Log.i("Main","position="+position+"res的角标="+position%res.length);
        ImageView imageView  =new ImageView(context);
        imageView.setBackgroundResource(res[position%res.length]);
        imageView.setLayoutParams(new Gallery.LayoutParams(200,300));
        //设置方向
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }
}
