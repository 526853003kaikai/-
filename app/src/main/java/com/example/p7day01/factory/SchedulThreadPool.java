package com.example.p7day01.factory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulThreadPool extends ThreatPoolFactory {

    private ScheduledExecutorService scheduledThreadPool;

    @Override
    public void executorThreat(Runnable runnable) {
        scheduledThreadPool = Executors.newScheduledThreadPool(3);
        scheduledThreadPool.schedule(runnable,1000, TimeUnit.SECONDS);
    }

    @Override
    public void deleteThread(Runnable runnable) {
        scheduledThreadPool.shutdown();
    }
}
