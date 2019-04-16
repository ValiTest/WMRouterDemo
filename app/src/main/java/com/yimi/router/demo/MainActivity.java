package com.yimi.router.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 测试跳转 主APP 页面
     */
    public void gotoAppPage1(View view) {
    }

    /**
     * 测试跳转 lib1 页面 + 携带extras
     */
    public void gotoLib1Page1(View view) {
    }

    /**
     * 测试跳转 lib2 Fragment页面 + 携带extras
     */
    public void gotoLib2FragmentPage1(View view) {
    }

    /**
     * 测试 startActivityForResult
     */
    public void startForResult(View view) {
    }
}
