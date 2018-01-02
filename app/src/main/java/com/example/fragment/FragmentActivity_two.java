package com.example.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chensolo.liistview.R;

/**
 * Created by Administrator on 2018/1/2.
 */

public class FragmentActivity_two extends AppCompatActivity {
  private TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity_two);
        Button button = findViewById(R.id.button);
        tv = findViewById(R.id.text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    tv.setText("TextView改变了");
            }
        });
    }
}
