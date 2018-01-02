package com.example.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.chensolo.liistview.R;

/**
 * Created by Administrator on 2018/1/2.
 */

public class FragmentActivity  extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup radioGroup;
    private RadioButton frist,second,thrid,four;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity);

        radioGroup = findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

        switch (checkedId){
            case R.id.first:
                Intent i = new Intent(this,FragmentActivity_two.class);
                startActivity(i);
                break;

            case R.id.second:
                Fragment_two fragment_two = new Fragment_two();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction() ;//新建事物
                fragmentTransaction.add(R.id.frame,fragment_two);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                 break;

            case R.id.thrid:
                Intent intent = new Intent(FragmentActivity.this,FragmentActivity_three.class);
                startActivity(intent);
                break;

            case R.id.four:
                Intent intent1 = new Intent(this,FragmentActivity_four.class);
              startActivity(intent1);
                break;
        }
    }
}
