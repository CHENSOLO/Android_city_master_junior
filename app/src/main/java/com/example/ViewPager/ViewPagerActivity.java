package com.example.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import com.example.chensolo.liistview.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2018/1/2.
 */

public class ViewPagerActivity extends FragmentActivity implements ViewPager.OnPageChangeListener{
private List<View> viewList;
private ViewPager pager;
private PagerTabStrip tab;
private List<String>titleList;
private List<Fragment>fragList;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        viewList = new ArrayList<View>();
        /**
         * 通过View对象去作为ViewPager的数据源
         */
        tab = findViewById(R.id.tab);
        View view1 = View.inflate(this,R.layout.view1,null);
        View view2= View.inflate(this,R.layout.view2,null);
        View view3 = View.inflate(this,R.layout.view3,null);
        View view4 = View.inflate(this,R.layout.view4,null);

        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);

        /**
         * 通过Frgament作为ViewPager的数据源
         */
         fragList = new ArrayList<Fragment>();
         fragList.add(new Fragment1());
         fragList.add(new Fragment2());
         fragList.add(new Fragment3());
         fragList.add(new Fragment4());

        //为ViewPager页卡设置标题
        titleList = new ArrayList<String>();
        titleList.add("第一页");
        titleList.add("第二页");
        titleList.add("第三页");
        titleList.add("第四页");

        //为PagerTabStrip设置一些属性
          tab.setBackgroundColor(Color.YELLOW);
          tab.setTextColor(Color.RED);
          tab.setDrawFullUnderline(false);
          tab.setTabIndicatorColor(Color.GREEN);

          //


        //初始化Viewpager
    pager = findViewById(R.id.pager);
    pager.setOnPageChangeListener(this);
        //创建PagerAdapter的适配器
        MyPagerAdapter adapter = new MyPagerAdapter(viewList,titleList);

         //ViewPager加载适配器
        // pager.setAdapter(adapter);
        /**
         * 加载FrgamentpagerAdapter适配器
         */
  //初始化
MyFragmentPagerAdapter adapter1 = new MyFragmentPagerAdapter(getSupportFragmentManager(),fragList,titleList) {
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragList.get(position);
    }

    @Override
    public int getCount() {
        return fragList.size();
    }
};
pager.setAdapter(adapter1);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Toast.makeText(this,"当前第"+(position+1)+"个页面",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
