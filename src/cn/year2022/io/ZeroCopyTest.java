package cn.year2022.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

public class ZeroCopyTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        long start = System.currentTimeMillis();
        File source = new File("D:/fileTest/copy.txt");
        File target = new File("D:/fileTest/copy2.txt");

        ioCopy(source, target);
//        ioCopyWithBuffer(source, target);
//        nioCopy(source, target);
        System.out.println(System.currentTimeMillis() - start);
        Thread.sleep(200);
        target.delete();
    }

    public static void ioCopy(File source, File target) throws IOException {
        try (InputStream is = new FileInputStream(source);
            OutputStream os = new FileOutputStream(target)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
    }

    public static void ioCopyWithBuffer(File source, File target) throws IOException {
        try (InputStream is = new BufferedInputStream(new FileInputStream(source));
            OutputStream os = new BufferedOutputStream(new FileOutputStream(target))) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
    }

    public static void nioCopy(File source, File target) throws IOException {
        try (FileChannel sourceChannel = new FileInputStream(source).getChannel();
            FileChannel targetChannel = new FileOutputStream(target).getChannel()) {
            for (long count = sourceChannel.size(); count > 0; ) {
                long transferred = sourceChannel.transferTo(sourceChannel.position(), count, targetChannel);
                sourceChannel.position(sourceChannel.position() + transferred);
                count -= transferred;
            }
        }
    }
}
