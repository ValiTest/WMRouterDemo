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
    /**
     * 打开 /lib1/page1
     * 参数:
     * <li>  1. int params1
     * <li>  2. String params2
     */
    public static final String PAGE1 = "/lib1/page1";

    /**
     * 打开 /lib1/page1
     * 参数:
     * <li>  1. int params1
     * <li>  2. String params2
     */
    public static final String PAGE2 = "/lib1/page2";
}
