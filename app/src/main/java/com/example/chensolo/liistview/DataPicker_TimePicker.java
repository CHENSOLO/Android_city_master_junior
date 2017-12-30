package com.example.chensolo.liistview;


import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by Administrator on 2017/12/30.
 */

public class DataPicker_TimePicker extends AppCompatActivity {
    private DatePicker datePicker;
    private TimePicker timePicker;
    private Calendar cal;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datepicker_timepicker);
      //获取日历的一个对象
        cal = Calendar.getInstance();
        //获取年月日分钟信息
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH)+1;
        day = cal.get(Calendar.DAY_OF_MONTH);
        hour = cal.get(Calendar.HOUR_OF_DAY);
        minute = cal.get(Calendar.MINUTE);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);

        setTitle(year+"/"+month+"/"+day+"/"+hour+":"+minute);

        //使标题上的日期能随着选择改变而改变
       datePicker.init(year, cal.get(Calendar.MONTH), day, new DatePicker.OnDateChangedListener() {
           @Override
           public void onDateChanged(DatePicker datePicker, int year, int monthYear, int dayOfMonth) {
                   setTitle(year+"/"+(monthYear+1)+"/"+dayOfMonth);
           }
       });

       timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
           @Override
           public void onTimeChanged(TimePicker timePicker, int hourofday, int minute) {
               setTitle(hourofday+":"+minute);
           }
       });
       //日期选择

//        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int monthofyear, int dayofmonth) {
//                      setTitle(year+"-"+(monthofyear+1)+"-"+dayofmonth);
//            }
//        },year,cal.get(Calendar.MONTH),day).show();


        //时间选择
        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourofday, int minute) {
                  setTitle(hourofday+":"+minute);
            }
        },hour,minute,true).show();
    }
}
