package by.nc.shpakovskaya.beans;

import by.nc.shpakovskaya.beans.departments.Department;
import by.nc.shpakovskaya.dao.Entity;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Valeria on 17.10.2016.
 */
public class Hospital extends Entity implements Serializable {


    private int id;
    private String name;
    private List<Department> departments = new ArrayList<>();

    public Hospital(){}

    public int getId() {
        return id;
    }

    public Hospital(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public void addDepartment(Department newDep){
        departments.add(newDep);
        newDep.setHospital(this);
    }


    public void removeDepartment(String department) {

        Iterator<Department> iterator = departments.iterator();
        while (iterator.hasNext()) {
            Department departmentIt = iterator.next();
            if (departmentIt.getName().equals(department))
                iterator.remove();
        }
    }

    @Override
    public String toString() {
        return ("\n++++++++++++++++++++++++ HOSPITAL ++++++++++++++++++++++++" +
                "\n+++++ " + getName() + " +++++\n" +
                "\n++ Departments: \n" +
                 getDepartments().toString() +
                " \n++++++++++++++++++++++++ hospital ++++++++++++++++++++++++\n");
    }
}
