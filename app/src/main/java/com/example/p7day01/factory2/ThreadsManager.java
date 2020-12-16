package com.example.p7day01.factory2;

public class ThreadsManager {
    public static final int SCHEDULE_THREAD = 0;
    public static final int CUSTOM_THREAD = 1;

    public static ThreadFactory mineThreadFactory(int type) {
        switch (type) {
            case SCHEDULE_THREAD:
                return ScheduleThread.getScheduleThread();
            case CUSTOM_THREAD:
                return CustomThread.getCustomThread();
        }
        return null;
    }
}
