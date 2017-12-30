package com.example.chensolo.liistview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/30.
 */

public class GridViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private GridView gridView;
    private List<Map<String, Object>> dataList;

    private int[] icon = {R.mipmap.eigth, R.mipmap.eigth, R.mipmap.eigth, R.mipmap.eigth, R.mipmap.eigth, R.mipmap.eigth, R.mipmap.eigth, R.mipmap.eigth,
            R.mipmap.eigth, R.mipmap.eigth, R.mipmap.eigth, R.mipmap.eigth};
    private String[] iconName = {"篮球", "篮球2", "篮球3", "篮球4", "篮球5", "篮球6", "篮球7", "篮球8", "篮球9", "篮球10", "篮球11", "篮球12",};
    private SimpleAdapter adapter;
    private List<? extends Map<String, ?>> data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);

        gridView = findViewById(R.id.gridview);
        /*
        1.准备数据源
        2.新建适配器（SimpleAdapter）
        3.GridView加载适配器
        4.GridView配置事件监听器（OnItemClickListener）
         */
        dataList = new ArrayList<Map<String, Object>>();//建数据源

     //   getData();
        adapter = new SimpleAdapter(this, getData(), R.layout.item,
                new String[]{"pic", "text"}, new int[]{R.id.pic, R.id.text});

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);
    }

    public List<Map<String, Object>> getData() {
        for (int i = 0; i <icon.length; i++) {

            Map<String,Object>map = new HashMap<String,Object>();
            map.put("pic",icon[i]);
            map.put("text",iconName[i]);
            dataList.add(map);
        }

        return dataList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(this,"我是"+iconName[position],Toast.LENGTH_LONG).show();
    }
}