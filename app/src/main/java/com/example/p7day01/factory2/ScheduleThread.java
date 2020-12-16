package com.example.p7day01.factory2;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThread extends ThreadFactory {
    private static ScheduleThread scheduleThread;
    private final ScheduledExecutorService scheduledExecutorService;

    private ScheduleThread() {
        scheduledExecutorService = Executors.newScheduledThreadPool(3);

    }

    public synchronized static ScheduleThread getScheduleThread() {
        if (scheduleThread == null) {
            synchronized (ThreadFactory.class) {
                if (scheduleThread == null) {
                    return scheduleThread;
                }
            }
        }
        return scheduleThread;
    }

    @Override
    public void executorThread(Runnable runnable, long startTime, long time, TimeUnit timeUnit) {
        super.executorThread(runnable, startTime, time, timeUnit);
        scheduledExecutorService.scheduleAtFixedRate(runnable,startTime,time,timeUnit);
    }

    @Override
    public void removeThread() {

    }
}
