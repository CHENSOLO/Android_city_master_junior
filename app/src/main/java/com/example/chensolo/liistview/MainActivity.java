package com.example.chensolo.liistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.Gallery.GalleryActivity;
import com.example.Include_merge_ViewStu.IncludeActivity;
import com.example.ScrollView.ScrollViewActivity;
import com.example.Seekbar.SeekBarActivity;
import com.example.ViewFlipper.ViewFlipperActivity;
import com.example.ViewPager.ViewPagerActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_date_time, btn_gridview,
            btn_spinner, btn_listview, btn_progressbar, btn_wenview,
            btn_fragment, btn_viewpager, btn_viewflipper, btn_scrollview, btn_garllery, btn_seekbar, btn_i_m_v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_date_time = findViewById(R.id.btn_date_time);
        btn_gridview = findViewById(R.id.btn_gridview);
        btn_listview = findViewById(R.id.btn_listview);
        btn_spinner = findViewById(R.id.btn_spinner);
        btn_progressbar = findViewById(R.id.btn_progressbar);
        btn_wenview = findViewById(R.id.btn_wenview);
        btn_fragment = findViewById(R.id.btn_fragment);
        btn_viewpager = findViewById(R.id.btn_viewpager);
        btn_viewflipper = findViewById(R.id.btn_viewflipper);
        btn_scrollview = findViewById(R.id.btn_scrollview);
        btn_garllery = findViewById(R.id.btn_gallery);
        btn_seekbar = findViewById(R.id.btn_seekbar);
        btn_i_m_v = findViewById(R.id.btn_i_m_v);

        btn_i_m_v.setOnClickListener(this);
        btn_seekbar.setOnClickListener(this);
        btn_garllery.setOnClickListener(this);
        btn_scrollview.setOnClickListener(this);
        btn_viewflipper.setOnClickListener(this);
        btn_viewpager.setOnClickListener(this);
        btn_fragment.setOnClickListener(this);
        btn_progressbar.setOnClickListener(this);
        btn_wenview.setOnClickListener(this);
        btn_gridview.setOnClickListener(this);
        btn_date_time.setOnClickListener(this);
        btn_spinner.setOnClickListener(this);
        btn_listview.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_date_time:
                Intent i = new Intent();
                i.setClass(MainActivity.this, DataPicker_TimePicker.class);
                startActivity(i);
                break;
            case R.id.btn_gridview:
                Intent q = new Intent();
                q.setClass(MainActivity.this, GridViewActivity.class);
                startActivity(q);
                break;
            case R.id.btn_spinner:
                startActivity(new Intent(getApplicationContext(), Spinner.class));
                break;
            case R.id.btn_listview:
                startActivity(new Intent(getApplicationContext(), ListViewActivity.class));
                break;
            case R.id.btn_progressbar:
                startActivity(new Intent(getApplicationContext(), ProgressBar.class));
                break;
            case R.id.btn_wenview:
                startActivity(new Intent(getApplicationContext(), WebviewActivity.class));
                break;
            case R.id.btn_viewpager:
                startActivity(new Intent(getApplicationContext(), ViewPagerActivity.class));
                break;
            case R.id.btn_viewflipper:
                startActivity(new Intent(getApplicationContext(), ViewFlipperActivity.class));
                break;
            case R.id.btn_scrollview:
                startActivity(new Intent(getApplicationContext(), ScrollViewActivity.class));
                break;
            case R.id.btn_gallery:
                startActivity(new Intent(getApplicationContext(), GalleryActivity.class));
                break;
            case R.id.btn_seekbar:
                startActivity(new Intent(getApplicationContext(), SeekBarActivity.class));
                break;
            case R.id.btn_i_m_v:
                startActivity(new Intent(getApplicationContext(), IncludeActivity.class));
                break;
        }
    }
}