package com.example.ViewFlipper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.chensolo.liistview.R;

/**
 * Created by Administrator on 2018/1/3.
 */

public class ViewFlipperActivity extends AppCompatActivity {
    private ViewFlipper flipper;
    private int[]resId={R.mipmap.view_one,R.mipmap.view_two,R.mipmap.view_three,R.mipmap.view_four};
    private float startX;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewflipper);
        flipper = findViewById(R.id.flipper);
       //动态导入的方式为ViewFlipper加入子View
        for (int i = 0; i <resId.length ; i++) {
            flipper.addView(getImageView(resId[i]));
        }
//        //ViewFilpper自动切换效果
//         flipper.setInAnimation(this,R.anim.left_in);
//        flipper.setOutAnimation(this,R.anim.left_out);
//        //设置ViewFlipper视图切换时间间隔
//        flipper.setFlipInterval(3000);
//        //开始播放
//        flipper.startFlipping();
    }
    private ImageView getImageView( int resId){
        ImageView imageView = new ImageView(this);
       // imageView.setImageResource(resId); //原来图片的宽高
        //铺满整个屏幕的方法
        imageView.setBackgroundResource(resId);
        return imageView;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            //手指落下
            case MotionEvent.ACTION_DOWN:
            {
                startX = event.getX();//获得坐标
                break;
            }
            //手指移动
            case MotionEvent.ACTION_MOVE:
            {
                //向右滑动要大于100看前一页
                if ( event.getX()-startX>100 ){
                   flipper.setInAnimation(this,R.anim.left_in);
                   flipper.setOutAnimation(this,R.anim.left_out);
                   flipper.showPrevious();//显示前一页
                }
                //向左滑动看后一页
                if ( startX-event.getX()>100 ){
                   flipper.setInAnimation(this,R.anim.right_in);
                   flipper.setOutAnimation(this,R.anim.right_out);
                   flipper.showNext();//显示后一页
                }
                break;
            }
            //手指抬起
            case MotionEvent.ACTION_UP:
            {
                break;
            }
        }
        return  super.onTouchEvent(event);
    }
}
