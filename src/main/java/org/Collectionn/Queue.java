package org.Collectionn;

import java.util.ArrayDeque;

/**
 * Очереди представляют структуру данных, работающую по принципу FIFO (first in - first out). То есть чем раньше был добавлен элемент в коллекцию, тем раньше он из нее удаляется. Это стандартная модель однонаправленной очереди. Однако бывают и двунаправленные - то есть такие, в которых мы можем добавить элемент не только в начала, но и в конец. И соответственно удалить элемент не только из конца, но и из начала.
 * <p>
 * Особенностью классов очередей является то, что они реализуют специальные интерфейсы Queue или Deque.
 */
public class Queue {

    public static void main(String[] args) {

        ArrayDeque<String> states = new ArrayDeque<>();
        states.add("1");
        states.add("2");
        states.add("3");
        states.add("4");
        states.add("5");

        // Получаем первый элемент без удаления
        String sFirst = states.getFirst();
        System.out.println(sFirst);

        // Получаем последний элемент без удаления
        String sLast = states.getLast();
        System.out.println(sLast);

        System.out.printf("Queue size: %d \n", states.size());

        // Перебор коллекции
        while (states.peek() != null) {
            // извлечение с начала
            System.out.println(states.pop());
        }

        // Очередь из объектов Person
        ArrayDeque<Person> people = new ArrayDeque<>();
        people.addFirst(new Person("Tom"));
        people.addFirst(new Person("Ivan"));
        // Перебор без извлечения
        for (Person p :
                people) {
            System.out.println(p.getName());
        }
    }
}

class Person {

    private final String name;

    public Person(String value) {
        name = value;
    }

    String getName() {
        return name;
    }
}
