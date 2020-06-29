package cn.year2018.yang.jdk9.imooc.flow;

public class MyProcessor {
//        extends SubmissionPublisher<String> implements Flow.Processor<Integer,String> {
//
//    public Flow.Subscription subscription;
//
//    @Override
//    public void onSubscribe(Flow.Subscription subscription) {
//
//        this.subscription = subscription;
//        this.subscription.request(1);
//    }
//
//    @Override
//    public void onNext(Integer item) {
//        System.out.println("处理器接受到数据: " + item);
//        if(item > 0)
//            this.submit("转换后的数据：" + item);
//        this.subscription.request(1);
//    }
//
//    @Override
//    public void onError(Throwable throwable) {
//
//        throwable.printStackTrace();
//        this.subscription.cancel();
//    }
//
//    @Override
//    public void onComplete() {
//        System.out.println("处理器处理完了");
//        this.close();
//    }
}