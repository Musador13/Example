package org.FileStream.BufferedStream;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;

/*
    Класс BufferedInputStream накапливает вводимые данные в специальном буфере
    без постоянного обращения к устройству ввода.
 */
public class InputStream {

    public static void main(String[] args) {

        String text = "Hello World!";
        byte[] buffer = text.getBytes();

        ByteArrayInputStream in = new ByteArrayInputStream(buffer);

        // Класс BufferedInputStream в конструкторе принимает объект InputStream.
        // В данном случае такой объект это экземпляр класса ByteArrayInputStream.
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(in)) {

            int c;
            // BufferedInputStream оптимизирует производительность при работе с потоками,
            // считывая методом read каждый байт из массива buffer.
            while ((c = bufferedInputStream.read()) != - 1) {
                System.out.print((char) c);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }
}
