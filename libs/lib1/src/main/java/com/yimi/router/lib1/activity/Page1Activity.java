package com.yimi.router.lib1.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.sankuai.waimai.router.annotation.RouterUri;
import com.yimi.router.lib1.R;
import com.yimi.router.lib1base.Lib1PageRouter;

@RouterUri(path = Lib1PageRouter.PAGE1)
public class Page1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib1_page1);

        showMsg((TextView) this.findViewById(R.id.text_msg));
    }

    private void showMsg(TextView view) {
        int msg1 = getIntent().getIntExtra(Lib1PageRouter.ParamsKey.PAGE1_PARAMS1_INT, 0);
        String msg2 = getIntent().getStringExtra(Lib1PageRouter.ParamsKey.PAGE1_PARAMS2_STRING);

        view.setText(Lib1PageRouter.ParamsKey.PAGE1_PARAMS1_INT + "=" + msg1 + "\n" +
                Lib1PageRouter.ParamsKey.PAGE1_PARAMS2_STRING + "=" + msg2);
    }
}
