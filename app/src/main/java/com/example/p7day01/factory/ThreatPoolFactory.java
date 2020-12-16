package com.example.p7day01.factory;

public abstract class ThreatPoolFactory {
    public abstract void executorThreat(Runnable runnable);

    public abstract void deleteThread(Runnable runnable);
}
