package com.lulow.justtype.model.timer;

public interface ITimer {
    void start(int seconds);
    void stop();
    int getSecondsLeft();
}
