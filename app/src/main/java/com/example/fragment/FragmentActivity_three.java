package com.example.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.chensolo.liistview.R;

/**
 * Created by Administrator on 2018/1/2.
 */

public class FragmentActivity_three extends AppCompatActivity {
    private Button button;
    private Fragment frag;
    private  boolean flag = true;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.fragment_activity_three);
       init();
       button = findViewById(R.id.button);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               FragmentManager fragmentManager = getFragmentManager();
               FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
               if ( flag ){
                   Fragment_four fragment_four = new Fragment_four();
                   fragmentTransaction.replace(R.id.layout,fragment_four);
                   flag = false;
               }else {
                   Fragment_three fragment_three = new Fragment_three();
                   fragmentTransaction.replace(R.id.layout,fragment_three);
                   flag = true;
               }
               fragmentTransaction.commit();
           }
       });
    }

    private void init() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment_three fragment_three = new Fragment_three();
        fragmentTransaction.add(R.id.layout,fragment_three);
        fragmentTransaction.commit();
    }
}
