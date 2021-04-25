package cn.year2021.io;/**
 * @author chy
 * @date 2021/4/25 0025 下午 15:14
 * Description：
 */

import com.alibaba.fastjson.JSONObject;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 测试serialVersionUID
 *
 * @author chy
 * @date 2021/4/25 0025
 */
public class TestByte2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        writeObject();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("E://cc.txt"));
        Sport sport = (Sport) objectInputStream.readObject();
        System.out.println(JSONObject.toJSONString(sport));


    }

    private static void writeObject() throws IOException {
        Sport sport = new Sport();
        sport.setId(1);
        sport.setName("chy");
//        sport.setAvatar("abc");

        FileOutputStream fileOutputStream = new FileOutputStream("E://cc.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(sport);

        objectOutputStream.flush();
        objectOutputStream.close();
    }

}
