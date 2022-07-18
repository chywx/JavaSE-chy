package cn.year2022.demo;

import java.io.File;
import java.text.DecimalFormat;

/**
 * @author: Dylan
 * @date: 2022/7/18 10:27
 */
public class Photography {

    static DecimalFormat decimalFormat = new DecimalFormat("000");

    public static void main(String[] args) {

        File directory = new File("C:\\Users\\chy15\\Downloads\\柏林摄影");
        for (File file : directory.listFiles()) {
            System.out.println(file.getName());
            System.out.println("========================" + getNewName(file.getName()));

            File newFile = new File("C:\\Users\\chy15\\Downloads\\newphoto\\" + getNewName(file.getName()));
            boolean b = file.renameTo(newFile);
            System.out.println(b);
        }

    }

    public static String getNewName(String oldName) {
        String newName = oldName.substring(3, oldName.length() - 5);
        String format = decimalFormat.format(Integer.parseInt(newName));
        return format + ".jpg";
    }


}
