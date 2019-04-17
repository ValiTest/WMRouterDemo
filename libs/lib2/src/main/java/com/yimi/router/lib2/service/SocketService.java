package com.yimi.router.lib2.service;

import android.util.Log;

import com.sankuai.waimai.router.annotation.RouterProvider;
import com.sankuai.waimai.router.annotation.RouterService;
import com.yimi.router.lib2base.ISocketService;
import com.yimi.router.lib2base.Lib2ServiceRouter;

/**
 * SocketService 默认版本 - 无参、单例
 * <p>
 * router service key: {@link Lib2ServiceRouter#SOCKET_DEFAULT}
 * <pre>
 * 注意:
 *   1、@RouterService 中必须指定 interfaces、key
 *   2、默认实现版本的 key 必须都等于 {@link Lib2ServiceRouter#DEFAULT}
 *   3、单例模式 需指定: singleton = true. (建议同时使用 单例模式 + @RouterProvider注解)
 */
@RouterService(interfaces = ISocketService.class, key = Lib2ServiceRouter.SOCKET_DEFAULT, singleton = true)
public class SocketService implements ISocketService {
    private static final String TAG = "SocketService";

    // ----- 单例模式 + @RouterProvider注解 ----->>

    private static volatile SocketService sInstance;

    private SocketService() {
        // init
    }

    @RouterProvider
    public static SocketService getInstance() {
        if (sInstance == null) {
            synchronized (SocketService.class) {
                if (sInstance == null) {
                    sInstance = new SocketService();
                }
            }
        }
        return sInstance;
    }

    // <<----- 单例模式 + @RouterProvider注解 -----

    @Override
    public boolean start() {
        Log.i(TAG, "start: ");
        return false;
    }

    @Override
    public void send(String msg) {
        Log.i(TAG, "send: ");
    }

    @Override
    public boolean stop() {
        Log.i(TAG, "stop: ");
        return false;
    }
}
