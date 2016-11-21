package by.nc.shpakovskaya.beans.people.stuff;

import by.nc.shpakovskaya.beans.departments.Room;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.TreeSet;

/**
 * Created by Valeria on 18.10.2016.
 */
public class Nurse extends Employee implements Assignment, Serializable{

    private TreeSet rooms = new TreeSet<Room>();

    public Nurse(String name, String surname, GregorianCalendar birth, String issue, String education, String contract,
                 Integer payment) {
        super(name, surname, birth, issue, education, contract, payment);
    }


    public TreeSet<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room r) {
        this.rooms.add(r);
    }

    @Override
    public String toString() {
        return "Nurse " + super.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Nurse nurse = (Nurse) o;

        return rooms != null ? rooms.equals(nurse.rooms) : nurse.rooms == null;

    }

    @Override
    public int hashCode() {
        return rooms != null ? rooms.hashCode() : 0;
    }

    @Override
    public String procedure() {
        return "Nurse makes the procedure to the patient";
    }

    @Override
    public String pills() {
        return "Nurse gives the pills to the patient";
    }

    @Override
    public String operation() {
        return "Call the doctor for the operation";
    }

    @Override
    public String writeOutThePatient() {
        return "Nurse prepare the documents for the operation";
    }

}
