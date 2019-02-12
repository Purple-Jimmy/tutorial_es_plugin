package com.tutorial;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.plugins.Plugin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: jimmy
 * @Date: 2019/2/12
 */
public class MyPlugin extends Plugin {
    private static Log log = LogFactory.getLog(MyPlugin.class);
    public MyPlugin() {
        super();
        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        for(int i=0;i<2;i++){
            final int temp = i;
            /**
             * execute方法作用:执行任务
             */
            ((ScheduledExecutorService) scheduledThreadPool).schedule(new Runnable() {
                @Override
                public void run() {
                    log.info("This is my fisrt Plugin");
                }
            },4, TimeUnit.SECONDS);
        }


    }

}
