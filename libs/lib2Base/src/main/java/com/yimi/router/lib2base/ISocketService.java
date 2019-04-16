package com.yimi.router.lib2base;

public interface ISocketService {
    boolean start();

    void send(String msg);

    boolean stop();
}
