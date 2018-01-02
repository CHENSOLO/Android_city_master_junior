package com.example.ViewPager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.chensolo.liistview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/2.
 */

public class ViewPagerActivity extends AppCompatActivity {
private List<View>viewList;
private ViewPager pager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        viewList = new ArrayList<View>();
        /**
         * 通过View对象去作为ViewPager的数据源
         */

        View view1 = View.inflate(this,R.layout.view1,null);
        View view2= View.inflate(this,R.layout.view2,null);
        View view3 = View.inflate(this,R.layout.view3,null);
        View view4 = View.inflate(this,R.layout.view4,null);

        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);

        //初始化Viewpager
    pager = findViewById(R.id.pager);

        //创建PagerAdapter的适配器
        MyPagerAdapter adapter = new MyPagerAdapter(viewList);

        //ViewPager加载适配器
      pager.setAdapter(adapter);
    }
}
