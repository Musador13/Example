package org.FileStream.BufferedStream;

import java.io.*;

/*
    Программа считывает текст из консоли и записывает в файл.
 */
public class BufferedReaderWriter {

    public static void main(String[] args) {

        /*
            Объект BufferedReader устанавливается для чтения с консоли с помощью объекта
            new InputStreamReader(System.in).
            В цикле считывается введенный текст пока не будет подана строка "ESC".
            Объект BufferedReader будет записывать текст в файл.
         */
        try(BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));
            BufferedWriter bufferedWriter =
                    new BufferedWriter(new FileWriter("src/main/resources/Example-files/text", true)))
        {
            // построчное чтение
            String text;
            while (!(text = bufferedReader.readLine()).equals("ESC")) {

                bufferedWriter.write(text + "\n");
                bufferedWriter.flush();
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
