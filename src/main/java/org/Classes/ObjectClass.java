package org.Classes;

/**
 * Все классы явно или неявно наследуются от класса {@link ObjectClass}.
 * Поэтому все типы и классы могут реализовать те методы, которые
 * определены в классе {@link ObjectClass}, такие как:
 * ({@link ObjectClass toString}, {@link ObjectClass hashCode}, {@link ObjectClass equals} и т.д.)
 */
public class ObjectClass {

    public static void main(String[] args) {

        Person anton = new Person("Anton");
        Person ivan = new Person("Ivan");

        System.out.println(anton.toString() + " with hashCode: " + anton.hashCode());
        System.out.println(ivan.toString() + " with hashCode: " + ivan.hashCode());
        System.out.println("Anton == Ivan? " + anton.equals(ivan));
    }
}

class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    /**
     * Метод {@link Object toString} служит для получения представления
     * данного объекта в виде строки.
     * @return Строку в удобночитаемом виде.
     */
    @Override
    public String toString() {
        return "Person: " + name;
    }

    /**
     * Метод {@link Object hashCode} позволяет задать некоторое числовое
     * значение, которое будет соответствовать
     * данному объекту или его хэш-коду.
     * По данному числу, например, можно сравнивать объекты.
     * @return Уникальный номер/хэш-код.
     */
    @Override
    public int hashCode() {
        return name.hashCode() * 10;
    }

    /**
     * Метод {@link Object equals} сравнивает два объекта на равенство.
     * @param object объект любого типа, который мы приводим к текущему,
     *               если они являются объектами одного класса.
     * @return возвращаем true если они совпадают, либо false, если не совпадают.
     */
    @Override
    public boolean equals(Object object) {

        /*
          Оператор instanceof позволяет выяснить, является ли
          переданный в качестве параметра объект объектом определенного класса
         */
        if (!(object instanceof Person)) {
            return false;
        }
        Person p = (Person) object;
        return this.name.equals(p.name);
    }
}
