package org.FileStream;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/*
    Класс FileReader наследуется от абстрактного Reader и представляет
    функциональность для чтения текстовых файлов.
 */
public class FileReaderClass {

    public static void main(String[] args) {

        try(FileReader fileReader = new FileReader("text3.txt")){

            // массив на 256 символов.
            char[] buffer = new char[256];
            int c;

            // по символьно считываем из файла в массив buffer, пока не дойдем
            // до конца файла и в этом случае read вернет -1.
            while ((c = fileReader.read(buffer)) > 0){

                /*
                    Поскольку считанная часть файла может быть меньше 256 символов,
                    и если меньше размера буфера, то копируем массив с помощью метода
                    Arrays.copy. Т.Е. обрезаем массив buffer, оставляя в нем только
                    те символы, которые считаны из файла.
                 */
                if (c < 256){
                    buffer = Arrays.copyOf(buffer, c);
                }
                System.out.print(buffer);
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
