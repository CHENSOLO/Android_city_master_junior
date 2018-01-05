package com.example.Seekbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.chensolo.liistview.R;

/**
 * Created by Administrator on 2018/1/5.
 */

public class SeekBarActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private SeekBar seekbar;
    private TextView tv1;
    private TextView tv2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seekbar);
        seekbar = findViewById(R.id.seekbar);
        seekbar.setOnSeekBarChangeListener(this);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
    }

    //数值改变
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        tv1.setText("正在拖动");
        tv2.setText("当前数值："+progress);

    }
    //开始拖动
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

        tv1.setText("开始拖动");
    }
    //停止拖动
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        tv1.setText("停止拖动");
    }
}
