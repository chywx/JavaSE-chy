package com.edu.testPay;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestIO {
    @Test
    public void test1() throws IOException {
        String aString = "102";
        System.out.println(Double.parseDouble(aString) / 100);
        FileInputStream stream = new FileInputStream(new File("./src/com/edu/testPay/info.json"));
        byte b[] = new byte[1024];
        int len;
        String jsonString = "";
        while (((len = stream.read(b)) != -1)) {
            jsonString += new String(b, 0, len);
        }
        JSONObject parseObject = JSONObject.parseObject(jsonString);
        System.out.println(parseObject.get("a"));
        System.out.println(parseObject.getJSONObject("a").get("sex"));
    }
}
