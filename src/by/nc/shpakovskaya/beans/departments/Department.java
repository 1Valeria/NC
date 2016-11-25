package by.nc.shpakovskaya.beans.departments;

import by.nc.shpakovskaya.beans.Hospital;
import by.nc.shpakovskaya.beans.diagnosis.Diagnosis;
import by.nc.shpakovskaya.beans.people.customer.Patient;
import by.nc.shpakovskaya.beans.people.stuff.Nurse;
import by.nc.shpakovskaya.beans.roles.users.Doctor;
import by.nc.shpakovskaya.dao.Entity;

import java.io.Serializable;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by Valeria on 18.10.2016.
 */
public class Department extends Entity implements Serializable, Comparable {

    private static final Logger log = Logger.getLogger(Department.class.getName());

    private static int counter = 0;

    private String name;
    private Doctor headDoctor;
    private Hospital hospital;
    private Set diagnoses = new TreeSet<Diagnosis>();
    private List<Doctor> doctors = new ArrayList<>();
    private Set nurses = new TreeSet<Nurse>();
    private Set patients = new TreeSet<Patient>();
    private Set rooms = new TreeSet<Room>();

    private int id;

    public Department(){}

    public Department(String name, Hospital hospital) {
        this.name = name;
        this.hospital = hospital;
        id = counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Doctor getHeadDoctor() {
        return headDoctor;
    }

    public void setHeadDoctor(Doctor headDoctor) {
        this.headDoctor = headDoctor;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Set getDiagnoses() {
        return diagnoses;
    }

    public void addDiagnosis(Diagnosis newDiagnosis) {
        diagnoses.add(newDiagnosis);
    }

    public void removeDiagnosis(String diagnosis) {

        Iterator<Diagnosis> iterator = diagnoses.iterator();
        while (iterator.hasNext()) {
            Diagnosis diagnosisIt = iterator.next();
            if (diagnosisIt.getName().equals(diagnosis))
                iterator.remove();
        }
    }

    public void removeDoctor(String doctor) {

        Iterator<Doctor> iterator = doctors.iterator();
        while (iterator.hasNext()) {
            Doctor doctorIt = iterator.next();
            if (doctorIt.getName().equals(doctor))
                iterator.remove();
        }
    }

    public Set getNurses() {
        return nurses;
    }

    public void addNurse(Nurse newNurse) {
        nurses.add(newNurse);
    }

    public void removeNurse(String nurse) {

        Iterator<Nurse> iterator = nurses.iterator();
        while (iterator.hasNext()) {
            Nurse nurseIt = iterator.next();
            if (nurseIt.getName().equals(nurse))
                iterator.remove();
        }
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void addDoctor(Doctor newDoc){
        doctors.add(newDoc);
        newDoc.setDepartment(this);
    }

    public Set getPatients() {
        return patients;
    }

    public void addPatient(Patient newPatient) {
        patients.add(newPatient);
        newPatient.setDepartment(this);
    }

    public void removePatient(String patient) {

        Iterator<Patient> iterator = patients.iterator();
        while (iterator.hasNext()) {
            Patient patientIt = iterator.next();
            if (patientIt.getName().equals(patient))
                iterator.remove();
        }
    }

    public Set getRooms() {
        return rooms;
    }

    public void addRoom(Room newRoom) {
        rooms.add(newRoom);
    }

    public void removeRoom(Integer room) {
        Iterator<Room> iterator = rooms.iterator();
        while (iterator.hasNext()) {
            Room roomIt = iterator.next();
            if (roomIt.getNumber().equals(room))
                iterator.remove();
        }
    }

    @Override
    public String toString() {
        return ("\n============ Department ============" +
                "\n===== " + getName() + " =====" +
                "\n== Lead Doctor: " + getHeadDoctor() +
                "\n== Hospital: " + hospital.getName() +
                "\n== Diagnoses: " + getDiagnoses() +
                "\n== Doctors: " + getDoctors() +
                "\n== Nurses: " + getNurses() +
                "\n== Patients of the department: " + getPatients() +
                "\n== Rooms: " + getRooms() +
                "\n=================================");
    }

    @Override
    public int compareTo(Object obj) {
        Department entry = (Department) obj;

        int result = getName().compareTo(entry.getName());
        if (result != 0) {
            return result;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (headDoctor != null ? !headDoctor.equals(that.headDoctor) : that.headDoctor != null) return false;
        if (hospital != null ? !hospital.equals(that.hospital) : that.hospital != null) return false;
        if (diagnoses != null ? !diagnoses.equals(that.diagnoses) : that.diagnoses != null) return false;
        if (doctors != null ? !doctors.equals(that.doctors) : that.doctors != null) return false;
        if (nurses != null ? !nurses.equals(that.nurses) : that.nurses != null) return false;
        if (patients != null ? !patients.equals(that.patients) : that.patients != null) return false;
        return rooms != null ? rooms.equals(that.rooms) : that.rooms == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (headDoctor != null ? headDoctor.hashCode() : 0);
        result = 31 * result + (hospital != null ? hospital.hashCode() : 0);
        result = 31 * result + (diagnoses != null ? diagnoses.hashCode() : 0);
        result = 31 * result + (doctors != null ? doctors.hashCode() : 0);
        result = 31 * result + (nurses != null ? nurses.hashCode() : 0);
        result = 31 * result + (patients != null ? patients.hashCode() : 0);
        result = 31 * result + (rooms != null ? rooms.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
