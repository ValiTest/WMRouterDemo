package com.yimi.router.lib2.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sankuai.waimai.router.annotation.RouterUri;
import com.sankuai.waimai.router.common.PageAnnotationHandler;
import com.sankuai.waimai.router.fragment.v4.FragmentTransactionUriRequest;
import com.yimi.router.lib2.Constant;
import com.yimi.router.lib2.R;
import com.yimi.router.lib2base.Lib2PageRouter;

@RouterUri(path = Lib2PageRouter.FRAGMENT_ACTIVITY1)
public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib2_fragment);

        int msg1 = getIntent().getIntExtra(Lib2PageRouter.ParamsKey.FRAGMENT_ACTIVITY1_PARAMS1_INT, 0);
        String msg2 = getIntent().getStringExtra(Lib2PageRouter.ParamsKey.FRAGMENT_ACTIVITY1_PARAMS2_STRING);

        launchFragment(msg1, msg2);
    }

    /**
     * 测试 Activity 加载 Fragment
     */
    private void launchFragment(int msg1, String msg2) {
        // 传统方案
        /*
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                new FragmentPage1()).commitAllowingStateLoss();
        */

        // Router方案
        new FragmentTransactionUriRequest(this, PageAnnotationHandler.SCHEME_HOST + Constant.FRAGMENT1)
                .add(R.id.fragment_container)
                .allowingStateLoss()
                .putExtra("params1", msg1)
                .putExtra("params2", msg2)
                .start();
    }
}
