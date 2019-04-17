package com.yimi.router.lib1base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringDef;

import com.sankuai.waimai.router.service.IFactory;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Service 路由接口信息
 * <p>
 * 注意:
 * <pre>
 *  1、每种Service至少注册一个默认实现，如：public static final @Default String VIDEO_DEFAULT = DEFAULT;
 *  2、参数注释: 每个 path 必须详细说明需要的参数，可先以下三种:
 *      1) 无参数
 *          --> 可使用 Router.getService(IService.class, "key1"); 获取Service
 *      2) 一个Context参数
 *          --> 可使用 Router.getService(IService.class, "key1", context); 获取Service
 *      3) 其他不定参数,必须在此指定 params (一个{@link IFactory}的实现), 详见Demo
 *          --> 可使用 Router.getService(IService.class, "key1", params); 获取Service
 * </pre>
 */
public class Lib1ServiceRouter {
    /**
     * Service实现的默认版本
     * <p>
     * 该默认实现需要使用该变量和@{@link RouterService}注解来标识，
     * 如：@RouterService(interfaces = IService.class, key = Lib2ServiceKey.DEFAULT)
     */
    public static final String DEFAULT = "default";

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({DEFAULT})
    public @interface Default {
    }


    // -------- Service Key ---------


    // video service 只有一个默认实现版本
    /**
     * Video Service 的默认实现
     * <p>
     * 参数: 无参数
     */
    @Default
    public static final String VIDEO_DEFAULT = DEFAULT;


    // audio service 有多个实现版本，至少包含一个默认实现版本
    /**
     * Audio Service 的默认实现
     * <p>
     * 参数: 一个Context
     */
    @Default
    public static final String AUDIO_DEFAULT = DEFAULT;
    /**
     * Audio Service 的 type2 实现
     * <p>
     * 参数: {@link AudioParams}
     */
    public static final String AUDIO_TYPE2 = "audio_type2";


    // -------- Service 自定义Params ---------


    /**
     * params of {@link #AUDIO_TYPE2}
     */
    public static final class AudioParams implements IFactory {
        private Context context;
        private boolean debug;
        public AudioParams(Context context, boolean debug) {
            this.context = context;
            this.debug = debug;
        }

        @NonNull
        @Override
        public <T> T create(@NonNull Class<T> clazz) throws Exception {
            return clazz.getConstructor(Context.class, boolean.class).newInstance(context, debug);
        }
    }

}
