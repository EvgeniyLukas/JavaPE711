package com.company.Lesson4;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person implements Comparable<Person>, Serializable {

    public enum Sex {
        MALE, FEMALE
    }

    private  String name;
    private LocalDate birthday;
    private transient Sex gender;
    private transient String emailAddress;

    public Person(String nameArg, LocalDate birthdayArg, Sex genderArg, String emailArg) {
        name = nameArg;
        birthday = birthdayArg;
        gender = genderArg;
        emailAddress = emailArg;
    }

    public int getAge() {
        return birthday.until(LocalDate.now()).getYears();
    }

    public void printPerson() {
        System.out.println(name + ", " + this.getAge());
    }

    @Override
    public String toString() {
        return name + ", " + this.getAge();
    }

    public Sex getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    public static List<Person> createRoster() {

        List<Person> roster = new ArrayList<>();
        roster.add(new Person("Fred", LocalDate.of(1980, 6, 20), Sex.MALE, "fred@example.com"));
        roster.add(new Person("Jane", LocalDate.of(1990, 7, 15), Sex.FEMALE, "jane@example.com"));
        roster.add(new Person("George", LocalDate.of(1991, 8, 13), Sex.MALE, "george@example.com"));
        roster.add(new Person("Bob", LocalDate.of(2000, 9, 12), Sex.MALE, "bob@example.com"));

        return roster;
    }


    //запись в файл (сериализация)
    public static void objectOut() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("people.bin"))) {
            out.writeLong(Person.createRoster().size());
            for (Person p : Person.createRoster()) {
                out.writeObject(p);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void objectIn() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("people.bin"))) {

            long length = in.readLong();
            Person[] peoples = new Person[(int) length];
            for (int i = 0; i < peoples.length; i++) {
                peoples[i] = (Person) in.readObject();
                System.out.println("peoples = " + peoples[i]);
            }


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(Person o) {
        return getAge() - o.getAge();
    }
}


class Test {
    public static void main(String[] args) {
        Person.objectOut();
        Person.objectIn();
    }
}
