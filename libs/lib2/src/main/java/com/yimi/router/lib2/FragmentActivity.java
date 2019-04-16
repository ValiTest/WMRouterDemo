package com.yimi.router.lib2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        launchFragment();
    }

    /**
     * 测试 Activity 加载 Fragment
     */
    private void launchFragment() {
        // 传统方案
        /*getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                new FragmentPage1()).commitAllowingStateLoss();
        */

        // Router方案
//        new FragmentTransactionUriRequest(this, PageAnnotationHandler.SCHEME_HOST + DemoConstant.TEST_DEMO_FRAGMENT_1)
//                .add(R.id.fragment_container)
//                .allowingStateLoss()
//                .start();
    }
}
