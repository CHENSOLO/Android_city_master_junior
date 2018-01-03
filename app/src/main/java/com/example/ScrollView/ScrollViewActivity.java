package com.example.ScrollView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.chensolo.liistview.R;

/**
 * Created by Administrator on 2018/1/3.
 */

public class ScrollViewActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv;
    private ScrollView scrollview;
    private Button up,down;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrollview);
        up = findViewById(R.id.up);
        down = findViewById(R.id.down);
        up.setOnClickListener(this);
        down.setOnClickListener(this);
        tv = findViewById(R.id.tv);
        tv.setText(getResources().getString(R.string.content));
     scrollview = findViewById(R.id.scrollview);
     scrollview.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View view, MotionEvent motionEvent) {
             switch (motionEvent.getAction()){
                 case MotionEvent.ACTION_MOVE:{
                     /**
                      * 1.getScrollY()---滚动条滑动的距离
                      * 2.getMesureHeight()
                      * 3.getHeight()
                      */
                     if ( scrollview.getScrollY()<=0 )
                     {
                         Log.i("Main","滑动顶部");
                     }
                     /**
                      * 底部状态
                      * TextVew的总高度《=一屏幕的高度+滚动条的滚动距离
                      *
                      */
                     if (scrollview.getChildAt(0).getMeasuredHeight()<=scrollview.getHeight()+scrollview.getScrollY())
                     {
                         Log.i("Main","滑动到底部");
                         Log.i("Main","scrollview.getChildAt(0).getMeasuredHeight()="
                                 +scrollview.getChildAt(0).getMeasuredHeight()
                                 +"scrollview.getHeight()="+scrollview.getHeight()
                                 +"scrollview.getScrollY()="+scrollview.getScrollY())

                         //显示在增加多一版
;                    tv.append(getResources().getString(R.string.content));
                     }
                     break;
                 }
             }
             return false;
         }
     });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            /**
             * scrollTo 以滚动视图起始位置开始计算
             * scroollBy:相对前一次的位置去滚动对应的距离
             */

            case R.id.up:
            {
                scrollview.scrollTo(0,-30);
                break;
            }
            case R.id.down:
            {
                scrollview.scrollBy(0,30);
                break;

            }
        }
    }
}
