package com.example.lanchat.engine.lan;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.IntRange;
import android.support.annotation.WorkerThread;

import java.io.IOException;
import java.net.MulticastSocket;

/**
 * <pre>
 *     @author sin
 *     @date 2017-05-25
 *     @desc 局域网客户端
 * </pre>
 */

public class LANClient {

    /**
     * 端口
     */
    private int mPort;
    private MulticastSocket mMulticastSocket;

    /**
     * <pre>
     *     @author 袁光芯
     *     @date 2017-05-25
     *     @desc 在子线程工作的handler
     * </pre>
     */
    @WorkerThread
    static class WorkerHandler extends Handler {
        static final int WORKER_CONNECT = -1;

        private LANClient client;

        WorkerHandler(Looper looper, LANClient client) {
            super(looper);
            this.client = client;
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case WORKER_CONNECT:
                    // xxx
                    break;
            }
        }
    }

    /**
     * 准备, 实际上就是开启Handler
     */
    public void prepare() {

    }

    public void listen(ActionObserver lanObserver) {
        boolean success;
        int code;

        // 开始监听端口
        try {
            mMulticastSocket = new MulticastSocket(mPort);
            success = true;
            code = ActionObserver.CODE.OK;
        } catch (IOException e) {
            success = false;
            code = ActionObserver.CODE.IO_EXCEPTION;
        }

        // 回调
        if (lanObserver != null) {
            lanObserver.onActionResult(
                    ActionObserver.ACTION.CONNECT,
                    success,
                    code);
        }

    }

    public static class Builder {
        private LANClient mInstance;

        private Builder() {
            mInstance = new LANClient();
        }

        public static Builder create() {
            return new Builder();
        }

        public Builder port(
                @IntRange(from = 5000, to = 65535) int port) {
            if (port < 1 || port > 65535) {
                throw new IllegalArgumentException("port range is 1 ~ 65535");
            }
            mInstance.mPort = port;
            return this;
        }

        public LANClient build() {
            return mInstance;
        }
    }
}
