package com.yimi.router.lib1.service;

import android.content.Context;
import android.widget.Toast;

import com.sankuai.waimai.router.annotation.RouterService;
import com.yimi.router.lib1base.IAudioService;
import com.yimi.router.lib1base.Lib1ServiceRouter;

/**
 * AudioService 默认版本 - 一个Context参数
 * <p>
 * router service key: {@link Lib1ServiceRouter#AUDIO_DEFAULT}
 * <pre>
 * 注意:
 *   1、@RouterService 中必须指定 interfaces、key
 *   2、默认实现版本的 key 必须都等于 {@link Lib1ServiceRouter#DEFAULT}
 *   3、单例模式 需指定: singleton = true. (建议同时使用 单例模式 + @RouterProvider注解)
 */
@RouterService(interfaces = IAudioService.class, key = Lib1ServiceRouter.AUDIO_DEFAULT)
public class AudioService implements IAudioService {

    Context context;

    public AudioService(Context context) {
        this.context = context;
    }

    @Override
    public void startAudio(String audioPath) {
        Toast.makeText(context, "AudioService2 startAudio", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void stopAudio(String audioPath) {
        Toast.makeText(context, "AudioService2 stopAudio", Toast.LENGTH_SHORT).show();
    }
}
