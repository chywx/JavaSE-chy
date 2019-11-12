package com2019.thirdparty.dingding;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;

import java.util.Arrays;

/**
 * jar包地址http://open-dev.dingtalk.com/download/openSDK/java
 * 优缺点
 * 优点：能较为及时地送达警告。
 * 缺点：发送有上限。
 * 官方给出关于发送的上限：
 * 消息发送频率限制
 * 每个机器人每分钟最多发送20条。
 * 消息发送太频繁会严重影响群成员的使用体验，大量发消息的场景（譬如系统监控报警）可以将这些信息进行整合，通过markdown消息以摘要的形式发送到群里。
 */
public class DingDingSendMsg {


//    public static final String TOKEN = "447eb1b80c75cfb299099a8de6d2646731ea07333f6c03d84655fac8da266862";
    public static final String TOKEN = "dee731c70b253711cc213c96393098085fcb1447215bd46fccad0fc7513326f8";

    public static DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token="+TOKEN);

    public static void main(String[] args) throws Exception{
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent("测试文本消息");
        request.setText(text);
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setAtMobiles(Arrays.asList("13121939122"));
        request.setAt(at);
        System.out.println("text类型");
        client.execute(request);

        request.setMsgtype("link");
        OapiRobotSendRequest.Link link = new OapiRobotSendRequest.Link();
        link.setMessageUrl("https://chywx.cnblogs.com/");
        link.setPicUrl("");
        link.setTitle("时代的火车向前开");
        link.setText("这个即将发布的新版本，创始人陈航（花名“无招”）称它为“红树林”。\n" +
                "而在此之前，每当面临重大升级，产品经理们都会取一个应景的代号，这一次，为什么是“红树林");
        request.setLink(link);
        System.out.println("link类型");
//        client.execute(request);

        request.setMsgtype("markdown");
        OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
        markdown.setTitle("杭州天气");
        markdown.setText("#### 杭州天气 @156xxxx8827\n" +
                "> 9度，西北风1级，空气良89，相对温度73%\n\n" +
                "> ![screenshot](https://www.cnblogs.com/images/cnblogs_com/chywx/995120/t_langrensha.png)\n"  +
                "> ###### 10点20分发布 [天气](http://www.thinkpage.cn/) \n");
        request.setMarkdown(markdown);
        System.out.println("markdown类型");
//        client.execute(request);
    }

}
