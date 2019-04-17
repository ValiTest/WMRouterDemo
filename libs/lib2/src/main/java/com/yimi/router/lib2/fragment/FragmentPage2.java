package com.yimi.router.lib2.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sankuai.waimai.router.annotation.RouterPage;
import com.yimi.router.lib2.Constant;
import com.yimi.router.lib2.R;

/**
 * 跳转 Fragment 只能使用 @{@link RouterPage}, 而不是 @RouterUri
 */
@RouterPage(path = Constant.FRAGMENT2)
public class FragmentPage2 extends Fragment {

    public FragmentPage2() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // view
        View view = inflater.inflate(R.layout.fragment_lib2_page2, container, false);

        // get extra params
        showMsg((TextView) view.findViewById(R.id.text_msg));

        return view;
    }

    private void showMsg(TextView view) {
        int msg1 = getArguments().getInt("params1", 0);
        String msg2 = getArguments().getString("params2");

        view.setText("params1" + "=" + msg1 + "\n" + "params2" + "=" + msg2);
    }

}

