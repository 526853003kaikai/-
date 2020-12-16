package com.example.p7day01;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolManager {

//    //饿汉式
//    private static ThreadPoolManager threadPoolManager = new ThreadPoolManager();
//
//    private ThreadPoolManager (){
//
//    }
//
//    public static ThreadPoolManager getThreadPoolManager(){
//
//        return threadPoolManager;
//    }


    //懒汉式
    private static ThreadPoolManager threadPoolManager;
    private final ThreadPoolExecutor mThreadPoolExecutor;

    private ThreadPoolManager() {
        //创建一个线程池出来
        mThreadPoolExecutor = new ThreadPoolExecutor(5, 20,
                30, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(),
                Executors.defaultThreadFactory());
    }

    public synchronized static ThreadPoolManager getThreadPoolManager() {
        if (threadPoolManager == null) {

            synchronized (ThreadPoolManager.class) {
                if (threadPoolManager == null) {
                    threadPoolManager = new ThreadPoolManager();
                }
            }
        }

        return threadPoolManager;
    }

    //添加任务 执行的方法
    public void executorThread(Runnable runnable) {
        mThreadPoolExecutor.execute(runnable);
    }

    //删除的方法
    public void deleteThread(Runnable runnable) {
        mThreadPoolExecutor.remove(runnable);
    }
}
