package com.example.lanchat.engine.lan;

/**
 * <pre>
 *     @author 袁光芯
 *     @date 2017-05-25
 *     @desc 观察者
 * </pre>
 */

public interface ActionObserver {

    /**
     * 当某项动作有结果的时候
     *
     * @param action 动作
     * @param success 是否成功
     * @param code  状态码, 成功的时候是200
     */
    void onActionResult(int action, boolean success, int code);

    /**
     * <pre>
     *     @author 袁光芯
     *     @date 2017-05-25
     *     @desc 动作字段
     * </pre>
     */
    interface ACTION {
        int CONNECT = 1;
    }

    /**
     * <pre>
     *     @author 袁光芯
     *     @date 2017-05-25
     *     @desc 状态码字段
     * </pre>
     */
    interface CODE{
        int OK = 200;
        int IO_EXCEPTION = 201;
    }
}
