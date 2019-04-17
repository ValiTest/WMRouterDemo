package com.yimi.router.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.sankuai.waimai.router.Router;
import com.sankuai.waimai.router.annotation.RouterUri;
import com.yimi.router.lib1base.IAudioService;
import com.yimi.router.lib1base.IVideoService;
import com.yimi.router.lib1base.Lib1ServiceRouter;
import com.yimi.router.lib2base.ISocketService;
import com.yimi.router.lib2base.Lib2ServiceRouter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@RouterUri(path = Constant.PTAH_APP_PAGE1)
public class AppPage1Activity extends AppCompatActivity {

    private TextView txtServiceLast;
    private TextView txtServiceNew;
    private Context context;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss", Locale.CHINA);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_page1);
        context = this;

        txtServiceLast = (TextView) findViewById(R.id.txt_service_last);
        txtServiceNew = (TextView) findViewById(R.id.txt_service_new);
    }

    private void updateServiceInfo(Object newObj) {
        String time = dateFormat.format(new Date(System.currentTimeMillis()));
        txtServiceLast.setText(txtServiceNew.getText());
        txtServiceNew.setText("[" + time + "]  " + newObj);
    }

    // ------- Service Router Test --------

    /**
     * 测试 调用 无参数的Service (in lib1)
     * <p>
     * 非单例，每次生成不同的对象。
     */
    public void callNoParamsService(View view) {
        IVideoService video = Router.getService(IVideoService.class, Lib1ServiceRouter.VIDEO_DEFAULT);

        video.startVideo("");
        updateServiceInfo(video);
    }

    /**
     * 测试 调用 参数为一个Context的Service（in lib1）
     */
    public void callAContextParamsService(View view) {
        IAudioService audio = Router.getService(IAudioService.class, Lib1ServiceRouter.AUDIO_DEFAULT, context);

        audio.startAudio("");
        updateServiceInfo(audio);
    }

    /**
     * 测试 调用 自定义参数的Service（in lib1）
     */
    public void callCustomParamsService(View view) {
        Lib1ServiceRouter.AudioParams params = new Lib1ServiceRouter.AudioParams(context, true);
        IAudioService audio = Router.getService(IAudioService.class, Lib1ServiceRouter.AUDIO_TYPE2, params);

        audio.startAudio("");
        updateServiceInfo(audio);
    }

    /**
     * 测试 调用 无参数的 单例 Service（in lib2）
     * <p>
     * 单例，每次生成同一个对象。
     */
    public void callSingletonParamsService(View view) {
        ISocketService socket = Router.getService(ISocketService.class, Lib2ServiceRouter.SOCKET_DEFAULT);

        socket.send("");
        updateServiceInfo(socket);
    }
}
