package org.StreamAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Большинство операций класса Stream,
    которые модифицируют набор данных,
    возвращают этот набор в виде потока.
    Однако бывают ситуации, когда хотелось бы получить данные не в виде потока,
    а в виде обычной коллекции, например, ArrayList или HashSet.
    И для этого у класса Stream определен метод collect.
    Первая версия метода принимает в качестве параметра
    функцию преобразования к коллекции:
    <R,A> R collect(Collector<? super T,A,R> collector).
    Функции, определенные в классе Collectors:
    toList(): преобразование к типу ListClass
    toSet(): преобразование к типу Set
    toMap(): преобразование к типу Map
 */
public class Collect {
    private static void arrayStreamCollect() {

        List<String> phones = new ArrayList<String>();
        Collections.addAll(phones, "iPhone 8", "HTC U12", "Huawei Nexus 6P",
                           "Samsung Galaxy S9", "LG G6", "Xiaomi MI6", "ASUS Zenfone 2",
                           "Sony Xperia Z5", "Meizu Pro 6", "Lenovo S850");

        // Преобразование набора в потоке в List.
        List<String> filteredPhones1 = phones.stream()
                .filter(s -> s.length() < 10)
                .toList();

        for (String s : filteredPhones1) {
            System.out.println(s);
        }


        // Преобразование набора в потоке в Set.
        Set<String> filteredPhones2 = phones.stream()
                .filter(s -> s.length() > 10)
                .collect(Collectors.toSet());

        for (String s : filteredPhones2) {
            System.out.println(s);
        }


    }

    private static void toMapStream(){

        Stream<Phones> phonesStream = Stream.of(new Phones("iPhone 8", 54000),
                                   new Phones("Nokia 9", 45000),
                                   new Phones("Samsung Galaxy S9", 40000),
                                   new Phones("LG G6", 32000));

        Map<String, Integer> phones = phonesStream
                .collect(Collectors.toMap(Phones::getName, Phones::getPrice));

        phones.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    public static void main(String[] args) {


    }
}
class Phones{

    private String name;
    private int price;

    public Phones(String name, int price){
        this.name=name;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
