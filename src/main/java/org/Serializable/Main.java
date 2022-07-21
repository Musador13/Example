package org.Serializable;

import java.io.*;
import java.util.ArrayList;

public class Main {

    private static void serializableObj(Person person, String fileName){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(person);
            System.out.println("File has been written");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private static void deserializableObj(Object object, String fileName){

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
            Person person1 = (Person) ois.readObject();
            System.out.printf("Name: %s \t Age: %d \n Height: %f \t Married: %b",
                              person1.getName(), person1.getAge(), person1.getHeight(), person1.isMarried());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        String fileName = "people1.dat";

        // создаем список объектов, которые будем записывать.
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Andrew", 34, 182, true));
        people.add(new Person("Tom", 21, 190, false));
        people.add(new Person("Nick", 30, 178, false));

        for (Person p : people) {
            serializableObj(p, fileName);
        }

        ArrayList<Person> newPeople = new ArrayList<>();


        for(Object obj : people) {
            deserializableObj(obj, fileName);
        }
    }
}

class Person implements Serializable {

    private String name;
    private int age;
    private double height;
    private boolean married;

    public Person(String name, int age, double height, boolean married) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.married = married;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    double getHeight() {
        return height;
    }

    boolean isMarried() {
        return married;
    }
}
