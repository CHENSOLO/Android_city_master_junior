package com.example.ViewPager;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018/1/3.
 */

public abstract class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragList;
    private List<String>titleList;

    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragList, List<String>titleList) {
        super(fm);
        this.fragList = fragList;
       this.titleList = titleList;
    }

}
