package com.example.Gallery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.example.chensolo.liistview.R;

/**
 * Created by Administrator on 2018/1/4.
 */

public class GalleryActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory {
    private Gallery gallery;
    private ImageAdapter adapter;
    private ImageSwitcher is;
    private int[]res={R.mipmap.eigth_one,R.mipmap.eigth_two,R.mipmap.eigth_three,
    R.mipmap.eigth_four,R.mipmap.eigth_five,R.mipmap.eigth_six,R.mipmap.eigth_seven,R.mipmap.eigth_eight,R.mipmap.view_four,R.mipmap.view_three,R.mipmap.view_two,R.mipmap.view_one};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);
        gallery = findViewById(R.id.gallery);
        is = findViewById(R.id.is);
        //galler加载适配器
        adapter = new ImageAdapter(res,this);
        gallery.setAdapter(adapter);
        //加载一个工厂
        is.setFactory(this);
        //淡出淡入的效果
        is.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        is.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                    // 当前角标是这样计算的imageView.setBackgroundResource(res[postion%res.length]);
                    is.setBackgroundResource(res[position%res.length]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public View makeView() {
        ImageView image = new ImageView(this);
        image.setScaleType(ImageView.ScaleType.FIT_CENTER); //等比例的缩放保持居中

        return image;
    }
}
