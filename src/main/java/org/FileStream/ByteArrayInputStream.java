package org.FileStream;

public class ByteArrayInputStream {

    public static void main(String[] args) {

        byte[] array1 = new byte[]{1, 3, 5, 7, 9};
        java.io.ByteArrayInputStream byteStream1 = new java.io.ByteArrayInputStream(array1);
        int b;
        while ((b = byteStream1.read()) != -1) {
            System.out.println(b);
        }

        String text = "Hello world!";
        byte[] array2 = text.getBytes();

        java.io.ByteArrayInputStream byteStream2 = new java.io.ByteArrayInputStream(array2, 0, 5);
        int c;

        while ((c = byteStream2.read()) != -1){
            System.out.println((char) c);
        }
    }
}
