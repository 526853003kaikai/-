package com.example.p7day01.factory2;



import java.sql.Time;
import java.util.concurrent.TimeUnit;

public abstract class ThreadFactory {

    public void executorThread(Runnable runnable){

    }

    public void executorThread(Runnable runnable, long startTime, long time, TimeUnit timeUnit){

    }

    public abstract void removeThread();

    public void removeThread(Runnable runnable){

    }
}
