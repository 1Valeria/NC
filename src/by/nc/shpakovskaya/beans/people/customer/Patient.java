package by.nc.shpakovskaya.beans.people.customer;

import by.nc.shpakovskaya.beans.departments.Department;
import by.nc.shpakovskaya.beans.departments.Room;
import by.nc.shpakovskaya.beans.diagnosis.Diagnosis;
import by.nc.shpakovskaya.beans.people.Person;
import by.nc.shpakovskaya.beans.people.stuff.Doctor;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * Created by Valeria on 18.10.2016.
 */
public class Patient extends Person implements Serializable {

    private Department department;
    private Diagnosis diagnosis;
    private Room room;
    private Doctor doctor;

    public Patient(String name, String surname, GregorianCalendar birth, String issue) {
        super(name, surname, birth, issue);
    }

    public void setDepartment(Department d){
        this.department = d;
    }

    public Department getDepartment(){
        return department;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Patient " + super.getName();
    }
}
