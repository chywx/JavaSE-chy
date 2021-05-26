package cn.year2021.jvm;

public class Finalization {
    public static Finalization finalization;

    @Override
    protected void finalize() {
        System.out.println("exec finalize");
        System.out.println("finalize:" + Thread.currentThread().getName());
        finalization = this;
    }

    public static void main(String[] args) throws InterruptedException {
        Finalization f = new Finalization();
        f.fff();
        System.out.println("first print f:" + f);
        f = null;
        System.gc();
        System.out.println("main:" + Thread.currentThread().getName());
        Thread.sleep(1000);// 休息一段时间，让上面的垃圾回收线程执行完毕
        System.out.println("second print f:" + f);
        System.out.println(f.finalization);
    }

    public void fff() {
        System.out.println("fff");
        System.out.println("fff:" + Thread.currentThread().getName());
    }
}
