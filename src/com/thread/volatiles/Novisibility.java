package com.thread.volatiles;

public class Novisibility {
	static volatile boolean stop;
	static class ReaderThread extends Thread{
		@Override
		public void run() {
			while(!stop) {
				System.out.println("我在工作");
			}
			System.out.println("停止工作");
		}
	}
	public static void main(String[] args) throws Exception{
		new ReaderThread().start();
		Thread.sleep(2000);
		stop = true;
	}
}
