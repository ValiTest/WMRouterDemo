package com.yimi.router.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sankuai.waimai.router.annotation.RouterUri;

@RouterUri(path = Constant.PTAH_APP_PAGE1)
public class AppPage1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_page1);
    }
}
