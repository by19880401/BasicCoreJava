package com.example.threadpool;

import cn.hutool.log.StaticLog;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/3
 * @
 */
public class ThreadPoolMain3 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();//创建一个可缓存线程池
        List<Photo> photoList = initPhotoList();
        for (Photo photo : photoList) {
            Runnable runnable = () -> {
                StaticLog.info("开启线程：：处理照片对象：{}", Thread.currentThread());
                handlePhotos(photo);
            };
            pool.submit(runnable);//提交任务至线程池-执行
        }
        pool.shutdown();//线程池不再接受任何新任务，但此时线程池并不会立刻退出，直到添加到线程池中的任务都已经处理完毕，才会退出
        pool.awaitTermination(1, TimeUnit.MINUTES);//上述关闭后，等待线程池内任务执行的时间
        StaticLog.info("结束");
    }

    private static void handlePhotos(Photo photo) {
        StaticLog.info("-->{}", photo);
    }

    private static List<Photo> initPhotoList() {
        List<Photo> photoList = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            Photo p = new Photo();
            p.setId(i);
            p.setName("photo->" + i);
            photoList.add(p);
        }
        return photoList;
    }
}
