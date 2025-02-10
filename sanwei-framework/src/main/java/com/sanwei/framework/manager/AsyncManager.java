package com.sanwei.framework.manager;

import com.sanwei.common.utils.Threads;
import com.sanwei.common.utils.spring.SpringUtils;

import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 异步任务管理器
 *
 * @Author：SatanCY
 * @Date：2025/1/26 18:53
 */
public class AsyncManager {

    /**
     * 操作延迟10毫秒
     */
    private final int OPERATE_DELAY_TIME = 10;

    /**
     * 异步操作调度线程池
     */
    private static ScheduledExecutorService executor = SpringUtils.getBean("scheduledExecutorService");

    /**
     * 单例模式
     */
    private AsyncManager(){};

    /**
     * 内部创建唯一实例
     */
    private static AsyncManager me = new AsyncManager();

    /**
     * 自行提供获取实例接口
     * @return
     */
    public static AsyncManager me() {
        return me;
    }

    public void execute(TimerTask task) {
        executor.schedule(task,OPERATE_DELAY_TIME, TimeUnit.MICROSECONDS);
    }

    public void shutdown() {
        Threads.shutdownAndAwaitTermination(executor);
    }
}
