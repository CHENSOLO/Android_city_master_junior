package com.example.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chensolo.liistview.R;

/**
 * Created by Administrator on 2018/1/2.
 */

public class FragmentActivity_four extends AppCompatActivity implements Fragment_five.MyListener{
    private EditText editText;
    private Button send;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity_four);
        editText = findViewById(R.id.editText);
        send = findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String text = editText.getText().toString();
                 Fragment_five fragment_five = new Fragment_five();
                 //传值
                Bundle bundle = new Bundle();
                bundle.putString("name",text);
                fragment_five.setArguments(bundle);
                //创建管理事物
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.layout,fragment_five,"fragment5");
                fragmentTransaction.commit();
                Toast.makeText(FragmentActivity_four.this,"向Fragment发送数据"+text,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void thank(String code) {
      Toast.makeText(FragmentActivity_four.this,"已成功接到"+code+"客气了",Toast.LENGTH_SHORT).show();

   }
}
