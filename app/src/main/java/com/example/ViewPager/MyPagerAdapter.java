package com.example.ViewPager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2018/1/2.
 */

public class MyPagerAdapter extends PagerAdapter {

    private List<View>viewList;

    public MyPagerAdapter(List<View> viewList) {
        this.viewList = viewList;
    }

    /**
     * 返回的页卡数量
     * @return
     */
    @Override
    public int getCount() {
        return viewList.size();
    }

    /**
     *View来自于对象
     * @param
     * @param
     * @return
     */
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0==arg1;
    }

    /**
     * 实例化一个页卡
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //添加到当前的位置
        container.addView(viewList.get(position));
        return viewList.get(position);//返回当前的位置
    }

    /**
     * 销毁一个页卡
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //移除当前的位置
        container.removeView(viewList.get(position));
    }
}
