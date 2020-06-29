package cn.year2020.io;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/5/14 0014
 */
public class parseCSV {

    /**
     * csv文件本身就是txt
     */
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./file/user.csv"));
            //第一行信息，为标题信息，不用,如果需要，注释掉
            reader.readLine();
            String line = null;
            while ((line = reader.readLine()) != null) {
                //CSV格式文件为逗号分隔符文件，这里根据逗号切分
                String item[] = line.split(",");
//                String last = item[item.length - 1];
                //int value = Integer.parseInt(last);//如果是数值，可以转化为数值
                System.out.println("userId>>>>>>" + item[0]);
                System.out.println("phone>>>>>>" + item[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
