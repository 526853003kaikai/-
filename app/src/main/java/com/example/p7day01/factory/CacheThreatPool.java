package com.example.p7day01.factory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CacheThreatPool extends ThreatPoolFactory{

    private ExecutorService executorService;

    @Override
    public void executorThreat(Runnable runnable) {
        executorService = Executors.newCachedThreadPool();
        executorService.execute(runnable);
    }

    @Override
    public void deleteThread(Runnable runnable) {
        executorService.shutdown();
    }
}
