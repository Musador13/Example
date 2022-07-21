package org.FileStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStream {

    public static void main(String[] args) {
        String text = "Some text";
        try (FileOutputStream fileOutputStream = new FileOutputStream(
                "src/main/resources/Example-files/text1")) {
            byte[] buffer = text.getBytes();

            fileOutputStream.write(buffer, 0, buffer.length);
            System.out.println("The file has been written");
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
