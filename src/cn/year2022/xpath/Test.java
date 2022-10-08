package cn.year2022.xpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Test {


    public static void main(String[] args) throws IOException {

        //System.setProperty("proxy.set", "false");
        //System.setProperty("http.proxyHost", "127.0.0.1");
        //System.setProperty("http.proxyPort", "8888");
        //System.setProperty("javax.net.ssl.trustStore", "C:\\Program Files\\Java\\jdk1.8.0_221\\jre\\lib\\security\\cacerts");
        //System.setProperty("javax.net.ssl.trustStorePassword", "changeit");

        System.setProperty("http.proxyHost", "127.0.0.1");
        System.setProperty("https.proxyHost", "127.0.0.1");
        System.setProperty("http.proxyPort", "8888");
        System.setProperty("https.proxyPort", "8888");

        System.out.println(sendRequest("https://mp.weixin.qq.com/s/yrn-9lYv_pUHMN4RsLBQPQ"));
        //new Test().getList("http://travel.chendahai.cn/");
        //new Test().getList("https://www.baidu.com/");

    }


    public static String sendRequest(String urlParam) {

        URLConnection con = null;

        BufferedReader buffer = null;
        StringBuffer resultBuffer = null;

        try {
            URL url = new URL(urlParam);
            con = url.openConnection();

            //设置请求需要返回的数据类型和字符集类型
            con.setRequestProperty("Content-Type", "application/json;charset=GBK");
            //允许写出
            con.setDoOutput(true);
            //允许读入
            con.setDoInput(true);
            //不使用缓存
            con.setUseCaches(false);
            //得到响应流
            InputStream inputStream = con.getInputStream();
            //将响应流转换成字符串
            resultBuffer = new StringBuffer();
            String line;
            buffer = new BufferedReader(new InputStreamReader(inputStream, "GBK"));
            while ((line = buffer.readLine()) != null) {
                resultBuffer.append(line);
            }
            return resultBuffer.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }


}
