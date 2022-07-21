package org.Collectionn;

import java.util.Comparator;
import java.util.TreeSet;

public class Compare {

    public static void main(String[] args) {

        Comparator<TestClass> comparator = new PersonNameComparator()
                .thenComparing(new PersonAgeComparator());
        TreeSet<TestClass> testClassTreeSet = new TreeSet<>(comparator);
        testClassTreeSet.add(new TestClass("Tom", 19));
        testClassTreeSet.add(new TestClass("Aim", 22));
        testClassTreeSet.add(new TestClass("Bib", 32));
        testClassTreeSet.add(new TestClass("Tom", 16));
        testClassTreeSet.add(new TestClass("Save", 23));

        for (TestClass t : testClassTreeSet) {
            System.out.println(t.getName() + " " + t.getAge());
        }
    }
}

class PersonAgeComparator implements Comparator<TestClass> {

    @Override
    public int compare(TestClass o1, TestClass o2) {

        if (o1.getAge() > o2.getAge()) {
            return 1;
        }
        else if (o1.getAge() < o2.getAge()) {
            return -1;
        }
        else {
            return 0;
        }
    }

}

class PersonNameComparator implements Comparator<TestClass> {

    @Override
    public int compare(TestClass o1, TestClass o2) {
        return o1.getName().compareTo(o2.getName());
    }
}


/**
 * Для того, чтобы объекты можно было сортировать и сравнивать,
 * они должны применять интерфейся Comparable<E>.
 * При применении интерфейся он типизируется текущим классом.
 */
class ComparableTestClass implements Comparable<ComparableTestClass> {

    private final String name;

    ComparableTestClass(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    /**
     * Интерфейс {@link Comparable} содержит единстевенный метод {@link Integer compareTo},
     * который сравнивает текущий объект с объектом, переданным в качестве параметра.
     */
    public int compareTo(ComparableTestClass testClass) {
        return name.compareTo(testClass.getName());
    }
}

class TestClass {

    private final String name;
    private final int age;

    TestClass(String name, int age) {
        this.name = name; this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
