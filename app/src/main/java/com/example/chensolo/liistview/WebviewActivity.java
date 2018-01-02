package com.example.chensolo.liistview;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Administrator on 2018/1/2.
 */

public class WebviewActivity extends AppCompatActivity {
    private WebView webview;
    private String url = "http://www.ccsolo.top";
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        init();
    }

    private void init() {
    webview = findViewById(R.id.webview);
    //打开外部webview加载web资源
        webview.loadUrl(url);
  //覆盖webview默认通过第三方或者是系统浏览器打开网页的行为，使得网页在webview打开
      //webviewClient帮助webview去处理一些页面控制和请求通知
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                //返回值是true的时候控制网页在webview中去打开，如果为false在第三方打开
              view.loadUrl(url);
              return  true;

            }
        });
        //启用支持JavaScript
         WebSettings settings = webview.getSettings();
         settings.setJavaScriptEnabled(true);
         //WebView加载页面有限使用缓存
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
         webview.setWebChromeClient(new WebChromeClient(){
             @Override
             public void onProgressChanged(WebView view, int newProgress) {
                 //newProgress 1-100整数
                 if (newProgress==100){
                     //网页加载完毕关闭ProgrssDialog
                     closeDialog();
                 }else {
                     //网页正在加载,打开ProgressDialog
                     openDialog(newProgress);
                 }
             }
         });
    }

    private void openDialog(int newProgress) {
        if ( progressDialog==null )
        {
            progressDialog=new ProgressDialog(this);
            progressDialog.setTitle("正在加载");//标题
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);//风格样式
            progressDialog.setProgress(newProgress);
            progressDialog.show();
        }else {
            //刷新进度
            progressDialog.setProgress(newProgress);
        }
    }

    private void closeDialog() {
        if ( progressDialog!=null && progressDialog.isShowing() ){
            progressDialog.dismiss();//取消显示
            progressDialog=null;
        }
    }
    //改写物理按键返回的逻辑

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if ( keyCode==KeyEvent.KEYCODE_BACK ){
           // Toast.makeText(this,webview.getUrl(),Toast.LENGTH_SHORT).show();
            if ( webview.canGoBack() ){
                webview.goBack();//返回上一页面
                return true;
            }else {
                System.exit(0);
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
