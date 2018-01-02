package com.example.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chensolo.liistview.R;

/**
 * Created by Administrator on 2018/1/2.
 */

public class Fragment_five extends Fragment {
   private String code = "Thank you,Activity!";
public MyListener listener;
   public  interface MyListener
   {
       public void thank(String code);
   }

    @Override
    public void onAttach(Activity activity) {
       listener = (MyListener) activity;
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_two,container,false);
        TextView tv = view.findViewById(R.id.text);
        //取值
        String text = getArguments().get("name")+"";
        tv.setText(text);
        Toast.makeText(getActivity(),"已成功接收到"+text,Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(),"向Activity发送"+code,Toast.LENGTH_SHORT).show();
        listener.thank(code);
        return  view;
    }
}
