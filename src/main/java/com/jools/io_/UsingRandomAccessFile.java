package com.jools.io_;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Jools He
 * @date 2025/6/21 16:44
 * @description: TODO
 */
public class UsingRandomAccessFile {

    static String filename = "src/main/java/com/jools/io_/BasicFileOutput.dat";

    static void display() {
        try (RandomAccessFile rf = new RandomAccessFile(filename, "r")) {
            for (int i = 0; i < 7; i++) {
                System.out.println("Value " + i + ": " + rf.readDouble());
            }
            System.out.println(rf.readUTF());   // 阅读结尾行
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {

        // 随机读写入并展示
        try (RandomAccessFile rf = new RandomAccessFile(filename, "rw")) {
            for (int i = 0; i < 7; i++) {
                rf.writeDouble(i * 1.414);
            }
            rf.writeUTF("The end of the file");
            rf.close();
            display();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 随机读入新增写入并展示
        try (RandomAccessFile rf = new RandomAccessFile(filename, "rw");) {
            rf.seek(5 * 8);
            rf.writeDouble(47.0001);
            rf.close();
            display();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*
         输出结果:
            Value 0: 0.0
            Value 1: 1.414
            Value 2: 2.828
            Value 3: 4.242
            Value 4: 5.656
            Value 5: 7.069999999999999
            Value 6: 8.484
            The end of the file
            Value 0: 0.0
            Value 1: 1.414
            Value 2: 2.828
            Value 3: 4.242
            Value 4: 5.656
            Value 5: 47.0001
            Value 6: 8.484
            The end of the file
        */
    }
}
