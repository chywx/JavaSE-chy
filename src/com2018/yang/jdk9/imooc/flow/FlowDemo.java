package com2018.yang.jdk9.imooc.flow;

public class FlowDemo {
//    public static void main(String[] args) {
//        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();
//        MyProcessor processor = new MyProcessor();
//        publisher.subscribe(processor);
//        Flow.Subscriber<String> subscriber = new Flow.Subscriber<String>(){
//
//            private Flow.Subscription subscription;
//
//            @Override
//            public void onSubscribe(Flow.Subscription subscription) {
//                this.subscription = subscription;
//                this.subscription.request(1);
//            }
//
//            @Override
//            public void onNext(String item) {
//                System.out.println("接收数据："+item);
//                this.subscription.request(1);
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                throwable.printStackTrace();
//                this.subscription.cancel();
//            }
//
//            @Override
//            public void onComplete() {
//                System.out.println("处理完了");
//            }
//
//
//        };
//
//        publisher.submit(-100);
//        publisher.submit(100);
//
//        publisher.close();
//        try {
//            Thread.currentThread().join(1000l);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
