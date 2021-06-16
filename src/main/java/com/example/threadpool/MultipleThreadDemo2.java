package com.example.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 一次性提交多个线程任务，所有任务执行完成后，返回完成标识
 * @author baiyang
 * @date 2021/6/16
 */
public class MultipleThreadDemo2 {
    private static final int THREAD_NUM = 2;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_NUM);
        CompletionService<String> completionService = new ExecutorCompletionService<String>(threadPool);
        List<Photo> pList = initPhotoes();
        try {
            for (Photo photo : pList) {
                final int seq = photo.getId();
                completionService.submit(new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        // 10000以内的随机数，作为等待时间
                        int waitMillis = new Random().nextInt(10000);
                        Thread.sleep(waitMillis);
                        String eachThreadName = Thread.currentThread().getName();
                        return seq + ", " + eachThreadName + ",cost time:" + waitMillis;
                    }
                });
            }

            int completeNum = 0;
            Future<String> future = null;
            do {
                future = completionService.take();
                System.out.println(future.get());
                if (future.isDone() && !future.isCancelled()) {
                    completeNum++;
                }
            } while (completeNum < pList.size());

            System.out.println("all task is complete.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
            System.out.println("shutdown the thread pool");
        }

    }

    private static List<Photo> initPhotoes() {
        List<Photo> pList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Photo p = new Photo();
            p.setId(i);
            p.setName("willis' photo:" + i);
            pList.add(p);
        }
        return pList;
    }
}
