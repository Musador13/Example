package org.StreamAPI;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Чтобы сгруппировать данные по какому-нибудь признаку,
 * нам надо использовать в связке метод collect() объекта
 * Stream и метод Collectors.groupingBy().
 */
public class Grouping {

    public static void main(String[] args) {

    }

    /**
     * Для создания групп в метод collect() передается вызов Collectors.groupingBy(),
     * которая с помощью выражения Phone2::getCompany группирует объекты по компании.
     * В итоге будет создан Map, в котором ключи - названия компаний, а значения - список
     * связанных с компаниями телефонов.
     */
    private static void grouping() {

        Stream<Phone2> phone2Stream = Stream.of(new Phone2("iPhone X", "Apple", 600),
                                                new Phone2("Pixel 2", "Google", 500),
                                                new Phone2("iPhone 8", "Apple", 450),
                                                new Phone2("Galaxy S9", "Samsung", 440),
                                                new Phone2("Galaxy S8", "Samsung", 340));

        Map<String, List<Phone2>> phonesByCompany = phone2Stream.collect(Collectors.groupingBy(Phone2::getCompany));

        for (Map.Entry<String, List<Phone2>> item : phonesByCompany.entrySet()) {

            // Выводим ключ - название компании.
            System.out.println(item.getKey());

            for (Phone2 phone2 : item.getValue()) {

                // Для каждой компании выводим связанные с ней телефоны.
                System.out.println(phone2.getName());

            } System.out.println();
        }
    }

    /**
     * Метод вычисляет количества элементов в каждой группе.
     */
    private static void countingStream() {
        Stream<Phone2> phone3 = Stream.of(new Phone2("iPhone X", "Apple", 600), new Phone2("Pixel 2", "Google", 500),
                                          new Phone2("iPhone 8", "Apple", 450), new Phone2("Galaxy S9", "Samsung", 440),
                                          new Phone2("Galaxy S8", "Samsung", 340));

        Map<String, Long> phones = phone3.collect(Collectors.groupingBy(Phone2::getCompany, Collectors.counting()));

        for (Map.Entry<String, Long> item : phones.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        } System.out.println();

    }

    /**
     * Метод делит элементы на группы по принципу, соответсвтует ли элемент
     * определенному условию.
     */
    private static void partitioning() {

        Stream<Phone2> phone2Stream = Stream.of(new Phone2("iPhone X", "Apple", 600),
                                                new Phone2("Pixel 2", "Google", 500),
                                                new Phone2("iPhone 8", "Apple", 450),
                                                new Phone2("Galaxy S9", "Samsung", 440),
                                                new Phone2("Galaxy S8", "Samsung", 340));

        // смотрим, принадлежит ли телефон компании Apple.
        Map<Boolean, List<Phone2>> phonesByApple = phone2Stream.collect(
                Collectors.partitioningBy(phone2 -> phone2.getCompany() == "Apple"));

        for (Map.Entry<Boolean, List<Phone2>> item : phonesByApple.entrySet()) {

            System.out.println(item.getKey()); for (Phone2 phone2 : item.getValue()) {

                System.out.println(phone2.getName());
            } System.out.println();
        }
    }
}

class Phone2 {

    private String name;
    private String company;
    private int price;

    public Phone2(String name, String comp, int price) {
        this.name = name; this.company = comp; this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCompany() {
        return company;
    }
}
