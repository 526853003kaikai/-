package com.example.p7day01.factory2;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThread extends ThreadFactory {

    private static CustomThread customThread;
    private final ThreadPoolExecutor threadPoolExecutor;

    private CustomThread() {
        threadPoolExecutor = new ThreadPoolExecutor(3, 10, 30, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(), Executors.defaultThreadFactory());
    }

    public synchronized static CustomThread getCustomThread() {

        if (customThread == null) {

            synchronized (CustomThread.class) {
                if (customThread == null) {
                    return customThread;
                }
            }
        }

        return customThread;
    }

    @Override
    public void executorThread(Runnable runnable) {
        super.executorThread(runnable);
        threadPoolExecutor.execute(runnable);
    }

    @Override
    public void removeThread() {

    }

    @Override
    public void removeThread(Runnable runnable) {
        threadPoolExecutor.remove(runnable);
    }
}
