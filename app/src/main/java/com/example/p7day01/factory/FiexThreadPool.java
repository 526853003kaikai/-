package com.example.p7day01.factory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FiexThreadPool extends ThreatPoolFactory{

    private ExecutorService newFixedThreadPool;

    @Override
    public void executorThreat(Runnable runnable) {
        newFixedThreadPool = Executors.newFixedThreadPool(3);
        newFixedThreadPool.execute(runnable);
    }

    @Override
    public void deleteThread(Runnable runnable) {
        newFixedThreadPool.shutdown();
    }
}
