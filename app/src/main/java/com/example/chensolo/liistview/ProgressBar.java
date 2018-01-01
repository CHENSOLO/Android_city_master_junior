package com.example.chensolo.liistview;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/1/1.
 */

public class ProgressBar extends AppCompatActivity implements View.OnClickListener {
       private android.widget.ProgressBar pb;
        private Button add,reduce,resert, show;
        private TextView text;
        private ProgressDialog pd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //启用窗口特征，带进度,显示进度条
        requestWindowFeature(Window.FEATURE_PROGRESS);
        setProgressBarVisibility(true);
        //不带进度显示进度条
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
       setProgressBarIndeterminateVisibility(false);
        //
        setProgress(9999);
        setContentView(R.layout.activity_progressbar);
        init();
    }

    private void init() {
        pb = findViewById(R.id.horiz);
         add = findViewById(R.id.add);
         reduce = findViewById(R.id.reduce);
        resert = findViewById(R.id.resert);
        text = findViewById(R.id.text);
        show = findViewById(R.id.show);
        //获得第一条进度条
           int first = pb.getProgress();
           //获得第二条
           int second = pb.getSecondaryProgress();
           //获得最大进度条
          int max = pb.getMax();
          //获得百分百
        text.setText("第一条进度百分比："+(int)(first/(float)max*100)+"% 第二条进度百分比："+(int)(second/(float)max*100)+"%");
        add.setOnClickListener(this);
        reduce.setOnClickListener(this);
        resert.setOnClickListener(this);
        show.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
         switch (view.getId()){
             case R.id.add:
              //增加第一进度和第二进度10个刻度
                 pb.incrementProgressBy(10);
                 pb.incrementSecondaryProgressBy(10);
                 break;
             case R.id.reduce:
                 //减少第一进度和第二进度10个刻度
                 pb.incrementProgressBy(-10);
                 pb.incrementSecondaryProgressBy(-10);
                 break;
             case R.id.resert:
                 //重置一开始的刻度
                 pb.setProgress(50);
                 pb.setSecondaryProgress(80);
                 break;
             case R.id.show:
                 /**
                  * 页面显示基础风格
                  */
                 //新建Progressdialog
                 pd = new ProgressDialog(ProgressBar.this);
                 //设置风格
                 pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                 //设置标题
                 pd.setTitle("ccsolo.top");
                 //设置对话框文字信息
                 pd.setMessage("欢迎搜索github网址");
                 //设置图标
                 pd.setIcon(R.mipmap.ic_launcher);

             /**
              * 设定关于ProgressBar的一些属性
              */
             //设定最大进度条
                      pd.setMax(100);
                      //设定初始化已经增长到的进度
                 pd.incrementProgressBy(50);
                 //进度条是明确显示进度的
                 pd.setIndeterminate(false);
                 //设定一个确定按钮
                 pd.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                         Toast.makeText(ProgressBar.this,"欢迎大家来到这里",Toast.LENGTH_SHORT).show();
                     }
                 });

                 //是否可以通过返回按钮退出对话框
                  pd.setCancelable(true);
                  //显示ProgressDialog
                 pd.show();
                 break;

         }

        text.setText("第一条进度百分比："+(int)(pb.getProgress()/(float)pb.getMax()*100)+"% 第二条进度百分比："+(int)(pb.getSecondaryProgress()/(float)pb.getMax()*100)+"%");
    }

}
