package com.yimi.router.lib2.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sankuai.waimai.router.annotation.RouterPage;
import com.sankuai.waimai.router.common.FragmentUriRequest;
import com.sankuai.waimai.router.common.PageAnnotationHandler;
import com.sankuai.waimai.router.core.OnCompleteListener;
import com.sankuai.waimai.router.core.UriRequest;
import com.sankuai.waimai.router.fragment.v4.FragmentTransactionUriRequest;
import com.yimi.router.lib1base.Lib1PageRouter;
import com.yimi.router.lib2.Constant;
import com.yimi.router.lib2.R;
import com.yimi.router.lib2base.Lib2PageRouter;

/**
 * 跳转 Fragment 只能使用 @{@link RouterPage}, 而不是 @RouterUri
 */
@RouterPage(path = Constant.FRAGMENT1)
public class FragmentPage1 extends Fragment {

    public FragmentPage1() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // view
        View view = inflater.inflate(R.layout.fragment_lib2_page1, container, false);
        view.findViewById(R.id.btn_jump_fragment_to_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpFromFragment2Activity();
            }
        });

        view.findViewById(R.id.btn_jump_fragment_to_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpFromFragment2Fragment();
            }
        });

        // get extra params
        showMsg((TextView) view.findViewById(R.id.text_msg));

        return view;
    }

    private void showMsg(TextView view) {
        int msg1 = getArguments().getInt(Lib2PageRouter.ParamsKey.FRAGMENT_ACTIVITY1_PARAMS1_INT, 0);
        String msg2 = getArguments().getString(Lib2PageRouter.ParamsKey.FRAGMENT_ACTIVITY1_PARAMS2_STRING);

        view.setText(Lib2PageRouter.ParamsKey.FRAGMENT_ACTIVITY1_PARAMS1_INT + "=" + msg1 + "\n" +
                Lib2PageRouter.ParamsKey.FRAGMENT_ACTIVITY1_PARAMS2_STRING + "=" + msg2);
    }

    /**
     * 测试 Fragment 跳转 外部Activity
     */
    private void jumpFromFragment2Activity() {
        new FragmentUriRequest(FragmentPage1.this, Lib1PageRouter.PAGE1)
                //.activityRequestCode(100)
                .putExtra(Lib1PageRouter.ParamsKey.PAGE1_PARAMS1_INT, 1)
                .putExtra(Lib1PageRouter.ParamsKey.PAGE1_PARAMS2_STRING, "str from lib2 fragment")
                .overridePendingTransition(R.anim.enter_activity, R.anim.exit_activity)
                .onComplete(new OnCompleteListener() {
                    @Override
                    public void onSuccess(@NonNull UriRequest request) {
                        Toast.makeText(FragmentPage1.this.getActivity(), "跳转成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(@NonNull UriRequest request, int resultCode) {
                    }
                })
                .start();
    }

    /**
     * 测试 Fragment1 切换 Fragment2
     */
    private void jumpFromFragment2Fragment() {
        new FragmentTransactionUriRequest(FragmentPage1.this.getActivity(), PageAnnotationHandler.SCHEME_HOST + Constant.FRAGMENT2)
                .replace(R.id.fragment_container)
                .putExtra("params1", 1)
                .putExtra("params2", "str")
                .onComplete(new OnCompleteListener() {
                    @Override
                    public void onSuccess(@NonNull UriRequest request) {
                        Toast.makeText(FragmentPage1.this.getActivity(), "跳转成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(@NonNull UriRequest request, int resultCode) {
                    }
                })
                .start();
    }

}

