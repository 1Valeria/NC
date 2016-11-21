package by.nc.shpakovskaya.console.utils;

import by.nc.shpakovskaya.beans.Hospital;
import by.nc.shpakovskaya.beans.departments.Department;

import java.util.Iterator;

/**
 * Created by Valeria on 28.10.2016.
 */
public class AvailableDepartments {

    public static void showAvailableDepartments(Hospital hospital){
        Iterator<Department> departmentIterator = hospital.getDepartments().iterator();
        while (departmentIterator.hasNext()) {
            Department department = departmentIterator.next();
            System.out.println("Available department: " + department.getName());
        }
    }
}
