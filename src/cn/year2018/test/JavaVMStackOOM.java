package cn.year2018.test;

public class JavaVMStackOOM {
    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }
// 是在是不敢运行，运行一下，电脑就挂了。
//	public static void main(String[] args) throws Throwable {
//		JavaVMStackOOM oom = new JavaVMStackOOM();
//		oom.stackLeakByThread();
//	}
}
