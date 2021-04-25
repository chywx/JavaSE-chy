package cn.year2021.io;/**
 * @author chy
 * @date 2021/4/20 0020 下午 18:23
 * Description：
 */

import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.util.SerializationUtils;

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/4/20 0020
 */
public class TestByte {

    public static void main(String[] args) throws IOException {
        write();

        byte[] bytes = readFileByByte();

        Sport deserialize = (Sport) SerializationUtils.deserialize(bytes);
        System.out.println(JSONObject.toJSONString(deserialize));

    }

    private static void write() throws IOException {
        Sport sport = new Sport();
        sport.setId(1);
//        sport.setAvatar("url");

        byte[] serialize = SerializationUtils.serialize(sport);
        for (byte b : serialize) {
            System.out.print(b);
        }
        System.out.println();

        File f = new File("E:\\dd.txt");

        FileOutputStream fileOutputStream = new FileOutputStream(f);
        fileOutputStream.write(serialize);

        fileOutputStream.flush();
        fileOutputStream.close();
    }


    public static byte[] readFileByByte() {
        String s = "";
        File f = new File("E:\\dd.txt");
        InputStream in = null;
        try {
            in = new FileInputStream(f);

            byte by[] = new byte[1024];
            in.read(by);
            in.close();
            return by;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("content:" + s);
        return null;
    }

}
