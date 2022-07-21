package org.FileStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReWriter {
    public static void main(String[] args) {

        try(FileInputStream fileInputStream = new FileInputStream(
                "src/main/resources/Example-files/text1");
            FileOutputStream fileOutputStream = new FileOutputStream(
                    "src/main/resources/Example-files/text2")){

            byte[] buffer = new byte[fileInputStream.available()];

            fileInputStream.read(buffer, 0, buffer.length);

            fileOutputStream.write(buffer, 0, buffer.length);
        }
        catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
