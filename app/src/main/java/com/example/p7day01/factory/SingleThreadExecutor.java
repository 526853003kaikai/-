package com.example.p7day01.factory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor extends ThreatPoolFactory {

    private ExecutorService singleThreadExecutor;

    @Override
    public void executorThreat(Runnable runnable) {
        singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute(runnable);
    }

    @Override
    public void deleteThread(Runnable runnable) {
        singleThreadExecutor.shutdown();
    }
}
