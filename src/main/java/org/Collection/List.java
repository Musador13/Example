package org.Collection;

import java.util.ArrayList;

public class List {
    public static void main(String[] args) {

        ArrayList<String> people = new ArrayList<>();
        // Добавляем ряд элементов
        people.add("1");
        people.add("2");
        people.add("3");
        people.add("4");
        people.add(1, "2"); // Добавления элемента по индексу

        System.out.println(people.get(1));
        people.set(1, "11");

        System.out.printf("ArrayList has %d elements \n", people.size());

        for (String person : people) {
            System.out.println(person);
        }

        // Проверяем наличие элемента
        if (people.contains("2")) {
            System.out.println("Yes");
        }

        // Удаление конкретного элемента
        people.remove("4");
        // Удаление по индексу
        people.remove(1);

        Object[] peopleArray = people.toArray();
        for (Object person : peopleArray) {
            System.out.println(person);
        }
    }
}
