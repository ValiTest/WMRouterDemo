package com.yimi.router.lib2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        View view = inflater.inflate(R.layout.fragment_page1, container, false);

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
        return view;
    }

    /**
     * 测试 Fragment 跳转 Activity
     */
    private void jumpFromFragment2Activity() {
//        new FragmentUriRequest(FragmentPage1.this, DemoConstant.JUMP_ACTIVITY_1)
//                .activityRequestCode(100)
//                .putExtra(TestUriRequestActivity.INTENT_TEST_INT, 1)
//                .putExtra(TestUriRequestActivity.INTENT_TEST_STR, "str")
//                .overridePendingTransition(R.anim.enter_activity, R.anim.exit_activity)
//                .onComplete(new OnCompleteListener() {
//                    @Override
//                    public void onSuccess(@NonNull UriRequest request) {
//                        ToastUtils.showToast(request.getContext(), "跳转成功");
//                    }
//
//                    @Override
//                    public void onError(@NonNull UriRequest request, int resultCode) {
//
//                    }
//                })
//                .start();
    }

    /**
     * 测试 Fragment1 切换 Fragment2
     */
    private void jumpFromFragment2Fragment() {
//        new FragmentTransactionUriRequest(FragmentPage1.this.getActivity(), PageAnnotationHandler.SCHEME_HOST + DemoConstant.TEST_DEMO_FRAGMENT_2)
//                .replace(R.id.fragment_container)
//                .putExtra("message","HelloWorld")
//                .onComplete(new OnCompleteListener() {
//                    @Override
//                    public void onSuccess(@NonNull UriRequest request) {
//                        ToastUtils.showToast(request.getContext(), "跳转成功");
//                    }
//
//                    @Override
//                    public void onError(@NonNull UriRequest request, int resultCode) {
//
//                    }
//                })
//                .start();
    }

}

