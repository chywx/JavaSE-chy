package newcom.amrtomp3;

import it.sauronsoftware.jave.*;

import java.io.File;

public class ChangeAudioFormat {

    public static void main(String[] args) {
//        String path1 = "/home/chy/a1.amr";
//        String path2 = "/home/chy/a2.mp3";
//        String path1 = "C:\\Users\\10125\\Desktop/a1.amr";
//        String path2 = "C:\\Users\\10125\\Desktop/a2.mp3";
        String path1 = "/chy/audiofile/a1.amr";
        String path2 = "/chy/audiofile/a2.mp3";
        changeToMp3(path1, path2);
    }

    public static void changeToMp3(String sourcePath, String targetPath) {
        File source = new File(sourcePath);
        File target = new File(targetPath);
        AudioAttributes audio = new AudioAttributes();
        Encoder encoder = new Encoder();

        audio.setCodec("libmp3lame");
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("mp3");
        attrs.setAudioAttributes(audio);

        try {
            encoder.encode(source, target, attrs);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InputFormatException e) {
            e.printStackTrace();
        } catch (EncoderException e) {
            e.printStackTrace();
        }
    }
}
