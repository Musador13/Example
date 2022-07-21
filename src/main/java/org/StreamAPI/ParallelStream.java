package org.StreamAPI;

import java.util.Arrays;

public class ParallelStream {

    public static void main(String[] args) {

        IPhone[] phones = new IPhone[]{
                new IPhone("iPhone 8", 54000),
                new IPhone("Pixel 2", 45000),
                new IPhone("Samsung Galaxy S9", 40000),
                new IPhone("Nokia 9", 32000)};

        Arrays.parallelSetAll(phones, i -> {
            phones[i].setPrice(phones[i].getPrice() - 10000);
            return phones[i];
        });

        for (IPhone p : phones){
            System.out.printf("%s - %d \n", p.getName(), p.getPrice());
        }

//        int[] numbers = initializeArray(6);
//        for (int i : numbers){
//            System.out.println(i);
//        }
    }

    /**
     * Метод {@link ParallelStream initializeArray} создает массив
     * заданной длины.
     * @param size длина массива
     * @return измененный массив
     */
    private static int[] initializeArray(int size) {

        // инициализируем массив длины size.
        int[] values = new int[size];

        /*
         В метод передается два параметра: изменяемый массив
         и функция, которая устанавливает элементы массива.
         Эта функция перебирает все элементы и в качестве параметра
         получает индекс(i) текущего элемента.
        */
        Arrays.parallelSetAll(values, i -> i * 10);
        return values;
    }

}

class IPhone{

    private String name;
    private int price;

    public IPhone(String name, int price){
        this.name=name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public void setName(String val) {
        this.name=val;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int val) {
        this.price=val;
    }
}
