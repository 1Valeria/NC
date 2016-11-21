package by.nc.shpakovskaya.beans.people;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * Created by Valeria on 18.10.2016.
 */
public abstract class Person implements Serializable{

    private static int counter = 1;

    private String name;
    private String surname;
    private GregorianCalendar birth;
    private String issue;
    private Integer id;

    public Person(String name, String surname, GregorianCalendar birth, String issue) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.issue = issue;
        id = counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Person.counter = counter;
    }

    public String getName() {
        return name + " " + surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public GregorianCalendar getBirth() {
        return birth;
    }

    public void setBirth(GregorianCalendar birth) {
        this.birth = birth;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (surname != null ? !surname.equals(person.surname) : person.surname != null) return false;
        if (birth != null ? !birth.equals(person.birth) : person.birth != null) return false;
        if (issue != null ? !issue.equals(person.issue) : person.issue != null) return false;
        return id != null ? id.equals(person.id) : person.id == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (birth != null ? birth.hashCode() : 0);
        result = 31 * result + (issue != null ? issue.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\n --- Name: " + name +
                "\n --- Surname: " + surname +
                "\n --- Birth: " + birth +
                "\n --- Issue: " + issue +
                "\n --- ID: " + id;
    }
}
