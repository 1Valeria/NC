package by.nc.shpakovskaya.beans.departments;

import by.nc.shpakovskaya.beans.people.stuff.Nurse;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Valeria on 18.10.2016.
 */

public class Room implements Comparable<Room>, Serializable{

    private static int counter = 0;

    private Nurse nurse;
    private Integer number;
    private List<Integer> ids = new ArrayList<>();

    private transient ListIterator<Integer> listIterator = null;

    public Room(Integer number) {
        this.number = number;
        ids.add(counter++);
    }


    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public Integer getIds() {
        listIterator = ids.listIterator();
        while(listIterator.hasNext()){
            return listIterator.next();
        }
        return 0;
    }


    public void setNumber(Integer number) {
        this.number = number;
    }
    public Integer getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Room: " + getNumber() ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (nurse != null ? !nurse.equals(room.nurse) : room.nurse != null) return false;
        if (number != null ? !number.equals(room.number) : room.number != null) return false;
        if (ids != null ? !ids.equals(room.ids) : room.ids != null) return false;
        return listIterator != null ? listIterator.equals(room.listIterator) : room.listIterator == null;

    }

    @Override
    public int hashCode() {
        int result = nurse != null ? nurse.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (ids != null ? ids.hashCode() : 0);
        result = 31 * result + (listIterator != null ? listIterator.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Room o) {
        return number.compareTo(o.getNumber());
    }


}
