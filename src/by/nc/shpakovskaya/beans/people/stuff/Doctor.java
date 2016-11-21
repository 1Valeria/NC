package by.nc.shpakovskaya.beans.people.stuff;

import by.nc.shpakovskaya.beans.people.customer.Patient;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Valeria on 18.10.2016.
 */
public class Doctor extends Employee implements Assignment, Serializable, Comparable<Doctor> {

    private Set patients = new HashSet<Patient>();
    private String license;

    public Doctor(String name, String surname, GregorianCalendar birth, String issue, String education, String contract,
                  Integer payment, String license) {
        super(name, surname, birth, issue, education, contract, payment);
        this.license = license;
    }

    public Set getPatients() {
        return patients;
    }

    public void addPatients(Patient newPatients) {
        patients.add(newPatients);
        newPatients.setDoctor(this);
    }

    public void removePatient(Patient p){
        patients.remove(p);
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @Override
    public String toString() {
        return "Doctor " + super.getName();
    }

    @Override
    public String procedure() {
        return "Doctor makes procedure";
    }

    @Override
    public String pills() {
        return "Doctor assign the pills to the patient";
    }

    @Override
    public String operation() {
        return "Doctor makes an operation";
    }

    @Override
    public String writeOutThePatient() {
        return "Doctor writes out the patient";
    }

    @Override
    public int compareTo(Doctor o) {
        return 0;
    }
}
