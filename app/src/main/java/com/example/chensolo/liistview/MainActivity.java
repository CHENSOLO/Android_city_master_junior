package com.example.chensolo.liistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,AbsListView.OnScrollListener, View.OnClickListener {
    private ListView listView;
    private ArrayAdapter<String> arr_adapter;  //数组适配器
    private SimpleAdapter simp_adapter; //简单适配器
    private List<Map<String,Object>>dataList;
    private Button btn_date_time,btn_gridview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_date_time = findViewById(R.id.btn_date_time);
        btn_gridview = findViewById(R.id.btn_gridview);
        btn_gridview.setOnClickListener(this);
        btn_date_time.setOnClickListener(this);
        listView =  findViewById(R.id.listview);

        listView.setOnItemClickListener(this);
        listView.setOnScrollListener(this);
        //1.新建一个数据适配器
        //ArrayAdapter(上下文，当前listView加载的每一个列表所对应的布局文件，数据源)
        //SimpAdapter()
        /**
         * SimpleAdapter( context, data , resource , from ,to )：
         context：上下文
         data：数据源（List<? extends Map<String,?>> data）一个由Map组成的List合集
         每一个Map都对应ListView列表中的一行
         每一个Map（键-值对）中的键都必须包含所有在from中所指定的键
         resource：列表项的布局文件ID
         from：Map中的键名
         to：绑定数据视图中的ID，与from成对应关系。

         例如：sim_adapter=new SimpleAdapter(this,getData(),R.layout.item , new String[]{"pic","text"} ,new int[]{R.id.pic,R.id.text});  这里的数据源比较麻烦，先自定义一个获取数据源的方法getdata()，然后在这里调用它。
         另外，R.layout.item也是自建的，包含一个ImageButton（编号R.id.pic）和一个 Button（编号R.id.text），这些编号也是数据视图中的ID。
         */

        //2、适配器加载数据源
        String[]arr_data={"ABCD","ABCD","ABCD","ABCD"};
        dataList = new ArrayList<Map<String,Object>>();
     // arr_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr_data);
        simp_adapter = new SimpleAdapter(this,getData(),R.layout.item,new String[]{"pic","text"},new int[]{R.id.pic,R.id.text});
         // 3 视图（ListView）加载适配器
        listView.setAdapter(simp_adapter);
    }

    public List<Map<String, Object>> getData() {

        for (int i = 0; i <20 ; i++) {
            Map<String,Object>map = new HashMap<String, Object>();
            map.put("pic",R.mipmap.ic_launcher);
            map.put("text","CHENSOLO"+i);
            dataList.add(map);
        }
        return dataList;
    }


    @Override
    public void onScrollStateChanged(AbsListView absListView, int scrollState) {
             switch (scrollState)
             {
                 case SCROLL_STATE_FLING:
                     Log.i("Main","用户在手指离开屏幕之前，由于用力滑了一下，视图在缓冲");
                     Map<String,Object>map = new HashMap<String, Object>();
                     map.put("pic",R.mipmap.ic_launcher);
                     map.put("text","增加项");
                     dataList.add(map);
                     simp_adapter.notifyDataSetChanged();
                     break;
                 case SCROLL_STATE_IDLE:
                     Log.i("Main","视图已经停止滑动");
                     break;
                 case SCROLL_STATE_TOUCH_SCROLL:
                     Log.i("Main","手指没有离开屏幕，视图正在滑动");
                     break;

             }


    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id){
//position 就是列表传过来的位置
        String text = listView.getItemAtPosition(position)+"";
        Toast.makeText(this,"position="+position+" text="+text,Toast.LENGTH_LONG).show();
        Log.d("Main", "onItemClick: fuck");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_date_time:
                Intent i = new Intent();
                i.setClass(MainActivity.this,DataPicker_TimePicker.class);
                startActivity(i);

            case R.id.btn_gridview:
                Intent q = new Intent();
                q.setClass(MainActivity.this,GridViewActivity.class);
                startActivity(q);
        }
    }
}
