package com.yimi.router.lib2base;

/**
 * Page Path and Params key fo Lib2
 * <p>
 * <strong> 注意 </strong>
 * <pre>
 * 1、page path 字符串规则:
 *   1) 必须以 "/" 开头
 *   2）必须以 "第一段必须是组件名", 如支付组件: "/pay/***"
 *
 * 2、参数注释: 每个 path 必须详细说明需要的参数, 及其类型。
 * </pre>
 */
public class Lib2PageRouter {


    // ------- pages --------


    /**
     * 打开 /lib2/fragment1
     * <pre>
     * 参数:
     *  1. int {@link ParamsKey#FRAGMENT_ACTIVITY1_PARAMS1_INT}
     *  2. String {@link ParamsKey#FRAGMENT_ACTIVITY1_PARAMS2_STRING}
     */
    public static final String FRAGMENT_ACTIVITY1 = "/lib2/fragment_activity1";


    // ------ page params keys -------


    /**
     * page 跳转需要的参数Key
     * <per>
     * 命名规则: [page]_[参数KEY]_[参数类型] = "key"
     * 如：public static final String PAGE1_TIME_INT = "time";
     */
    public static class ParamsKey {
        public static final String FRAGMENT_ACTIVITY1_PARAMS1_INT = "params1";
        public static final String FRAGMENT_ACTIVITY1_PARAMS2_STRING = "params2";
    }
}
