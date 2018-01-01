package com.example.chensolo.liistview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/1.
 */

public class Spinner extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView textView;
    private android.widget.Spinner spinner;
    private List<String>list;
    private ArrayAdapter<String>adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        textView = findViewById(R.id.textView);
         spinner  = findViewById(R.id.spinner);

         //1。设置数据源
        list = new ArrayList<String>();
        list.add("北京");
        list.add("上海");
        list.add("广州");
        list.add("深圳");
        textView.setText("你选择的城市是北京");
        //2 新建 ArrayAdapter(数组适配器)
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        //3 adapter设置一个下拉列表样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //4.Spinner加载适配器
        spinner.setAdapter(adapter);
        //5 Spinner监听器
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

        String cityNmae = adapter.getItem(position);
        //更新
        textView.setText("你选择的城市是"+cityNmae);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
