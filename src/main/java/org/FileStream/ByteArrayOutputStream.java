package org.FileStream;

public class ByteArrayOutputStream {

    public static void main(String[] args) {

        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        String text = "Hello world!";
        byte[] buffer = text.getBytes();

        try {
            baos.write(buffer);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Превращаем массив байтов в строку.
        System.out.println(baos);

        // Получаем массив байтов и выводим по символьно.
        byte[] array = baos.toByteArray();
        for (byte b : array) {
            System.out.print((char) b);
        }
        System.out.println();
    }
}
