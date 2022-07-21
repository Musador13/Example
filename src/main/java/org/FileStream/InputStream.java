package org.FileStream;

import java.io.FileInputStream;
import java.io.IOException;

public class InputStream {

    public static void main(String[] args) {

        try(FileInputStream fileInputStream = new FileInputStream(
                "src/main/resources/Example-files/text1")){

            System.out.printf("File size: %d bytes \n", fileInputStream.available());

            byte[] buffer = new byte[fileInputStream.available()];

            fileInputStream.read(buffer, 0, fileInputStream.available());
            System.out.println("File data:");
            for (int i = 0; i < buffer.length; i++) {
                System.out.print((char)buffer[i]);
            }

//            int i = -1;
//            // Считываем каждый отдельный байт в переменную i, когда в
//            // в потоке больше нет данных для чтения, метод возвращает -1.
//            while ((i = fileInputStream.read()) != -1) {
//
//                // Конвертируем каждый байт в объект типа char и выводим.
//                System.out.print((char)i);
//            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
