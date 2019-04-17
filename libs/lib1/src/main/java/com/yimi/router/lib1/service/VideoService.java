package com.yimi.router.lib1.service;

import android.util.Log;

import com.sankuai.waimai.router.annotation.RouterService;
import com.yimi.router.lib1base.IVideoService;
import com.yimi.router.lib1base.Lib1ServiceRouter;

/**
 * VideoService 默认版本 - 无参
 * <p>
 * router service key: {@link Lib1ServiceRouter#VIDEO_DEFAULT}
 * <pre>
 * 注意:
 *   1、@RouterService 中必须指定 interfaces、key
 *   2、默认实现版本的 key 必须都等于 {@link Lib1ServiceRouter#DEFAULT}
 *   3、单例模式 需指定: singleton = true. (建议同时使用 单例模式 + @RouterProvider注解)
 */
@RouterService(interfaces = IVideoService.class, key = Lib1ServiceRouter.VIDEO_DEFAULT)
public class VideoService implements IVideoService {
    private static final String TAG = "VideoService";

    public VideoService() {
    }

    @Override
    public void startVideo(String videoPath) {
        Log.i(TAG, "startVideo: ");
    }

    @Override
    public void stopVideo(String videoPath) {
        Log.i(TAG, "stopVideo: ");
    }
}
