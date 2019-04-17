package com.yimi.router.lib1.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sankuai.waimai.router.annotation.RouterUri;
import com.sankuai.waimai.router.core.UriResult;
import com.yimi.router.lib1.R;
import com.yimi.router.lib1base.Lib1PageRouter;

@RouterUri(path = Lib1PageRouter.PAGE2)
public class Page2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib1_page2);
    }

    public void back(View view) {
        setResult(UriResult.CODE_SUCCESS, getIntent());
        finish();
    }
}
