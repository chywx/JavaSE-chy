package cn.year2021.thread.await;

import java.util.concurrent.*;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        String value = "hello world";
        System.out.println("start");
        Thread.sleep(3000);
        System.out.println("end");
        return value;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(new MyCallable());
        if(!future.isDone()){
            System.out.println("task not finished,please wait!");
        }
        String s = future.get();
        System.out.println("return :"+s);
    }

    public static void main0(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new MyCallable());
        new Thread(task).start();
        if(!task.isDone()){
            System.out.println("task not finished,please wait!");
        }
        String s = task.get();
        System.out.println("return :"+s);
    }
}
