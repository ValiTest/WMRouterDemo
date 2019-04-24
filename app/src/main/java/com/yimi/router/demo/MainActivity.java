package com.yimi.router.demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.sankuai.waimai.router.Router;
import com.sankuai.waimai.router.common.DefaultUriRequest;
import com.sankuai.waimai.router.core.OnCompleteListener;
import com.sankuai.waimai.router.core.UriRequest;
import com.yimi.router.lib1base.Lib1PageRouter;
import com.yimi.router.lib2base.Lib2PageRouter;

public class MainActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_main);
        context = this;
    }

    /**
     * 测试跳转 APP内部 页面
     * <p>
     * 说明: APP内部跳转也可直接使用startActivity
     */
    public void gotoAppPage1(View view) {
        Router.startUri(context, Constant.PTAH_APP_PAGE1);
    }

    /**
     * 测试跳转 lib1 页面
     */
    public void gotoLib1Page1(View view) {
        // 方式一
        /*
        DefaultUriRequest request = new DefaultUriRequest(context, Lib1PageRouter.PAGE1)
                .putExtra(Lib1PageRouter.ParamsKey.PAGE1_PARAMS1_INT, 1)
                .putExtra(Lib1PageRouter.ParamsKey.PAGE1_PARAMS2_STRING, "str");
        Router.startUri(request);
        */

        // 方式二
        new DefaultUriRequest(context, Lib1PageRouter.PAGE1)
                .putExtra(Lib1PageRouter.ParamsKey.PAGE1_PARAMS1_INT, 1)
                .putExtra(Lib1PageRouter.ParamsKey.PAGE1_PARAMS2_STRING, "str")
                .overridePendingTransition(R.anim.enter_activity, R.anim.exit_activity)
                .onComplete(new OnCompleteListener() {
                    @Override
                    public void onSuccess(@NonNull UriRequest request) {
                        Toast.makeText(context, "跳转成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(@NonNull UriRequest request, int resultCode) {
                    }
                })
                .start();
    }

    /**
     * 测试跳转 lib2 Fragment页面 (FragmentActivity)
     */
    public void gotoLib2FragmentPage1(View view) {
        new DefaultUriRequest(context, Lib2PageRouter.FRAGMENT_ACTIVITY1)
                .putExtra(Lib2PageRouter.ParamsKey.FRAGMENT_ACTIVITY1_PARAMS1_INT, 1)
                .putExtra(Lib2PageRouter.ParamsKey.FRAGMENT_ACTIVITY1_PARAMS2_STRING, "str")
                .start();
    }

    /**
     * 测试 startActivityForResult
     */
    public void startForResult(View view) {
        new DefaultUriRequest(context, Lib1PageRouter.PAGE2)
                .activityRequestCode(1234)
                .putExtra(Lib2PageRouter.ParamsKey.FRAGMENT_ACTIVITY1_PARAMS2_STRING, "str")
                .start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 1234:
                String msg = null;
                if (data != null) {
                    msg = data.getStringExtra(
                            Lib2PageRouter.ParamsKey.FRAGMENT_ACTIVITY1_PARAMS2_STRING);
                }
                Toast.makeText(context, "startForResult success! msg=" + msg,
                        Toast.LENGTH_SHORT).show();
                break;

            default:
                super.onActivityResult(requestCode, resultCode, data);
                break;
        }
    }
}
