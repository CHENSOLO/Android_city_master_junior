package com.example.Include_merge_ViewStu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;

import com.example.chensolo.liistview.R;

/**
 * Created by Administrator on 2018/1/5.
 */

public class IncludeActivity extends AppCompatActivity implements View.OnClickListener {
private TextView title_tv;
private Button button;
private ViewStub stub;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.i_m_v_activity);
        title_tv = findViewById(R.id.title);
        title_tv.setText("LOVE U");
        button = findViewById(R.id.button);
        stub = findViewById(R.id.stub);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        stub.inflate();
    }
}
