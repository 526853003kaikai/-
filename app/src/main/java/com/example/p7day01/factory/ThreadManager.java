package com.example.p7day01.factory;

public class ThreadManager {

    public static final int CACHE_THREAD = 0;
    public static final int FIEX_THREAD = 1;
    public static final int SINGLE_THREAD = 2;
    public static final int SCHEDULE_THREAD = 3;
    public static ThreatPoolFactory myThreatPoolFactory(int type){
        switch (type){
            case CACHE_THREAD:
                return new CacheThreatPool();

            case FIEX_THREAD:
                return new FiexThreadPool();

            case SINGLE_THREAD:
                return new SingleThreadExecutor();

            case SCHEDULE_THREAD:
                return new SchedulThreadPool();
        }
        return null;
    }
}
