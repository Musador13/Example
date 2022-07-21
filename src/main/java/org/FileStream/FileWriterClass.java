package org.FileStream;

import java.io.FileWriter;
import java.io.IOException;

/*
    Класс FileWriter является производным от класса Writer. Он используется для
    записи текстовых файлов.
    В конструктор передается либо путь к файлу в виде строки, либо объект File,
    который ссылается на конкретный текстовый файл.
    Параметр append указывает, должны ли данные дозаписываться в конец файла(true),
    либо файл должен перезаписываться(false).
 */
public class FileWriterClass {

    public static void main(String[] args) {

        try(FileWriter writer = new FileWriter("text3.txt", false)){

            // запись всей строки
            String text = "example text";
            writer.write(text);

            // запись по символам
            writer.append("\n");
            writer.append("E");

            writer.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
