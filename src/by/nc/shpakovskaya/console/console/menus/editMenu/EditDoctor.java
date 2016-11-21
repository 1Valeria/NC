package by.nc.shpakovskaya.console.console.menus.editMenu;

import by.nc.shpakovskaya.beans.Hospital;

/**
 * Created by Valeria on 26.10.2016.
 */
public class EditDoctor {/*
    public static void doctorItems(Hospital hospital) {
        Map<Integer, String> editDoctor = new HashMap<>();
        editDoctor.put(1, "Press 1 to show Doctors in the hospital");
        editDoctor.put(2, "Press 2 to show Doctors in the department");
        editDoctor.put(3, "Press 3 to add Doctor to the department");
        editDoctor.put(4, "Press 4 to remove Doctor from the hospital");
        editDoctor.put(5, "Press 5 to assign Doctor to the Departments lead");
        editDoctor.put(6, "Press 6 to up to menu");
        editDoctor.put(7, "Press 7 to exit");

        switch (MenuExceptionCheck.checkAtExceptions(editDoctor)) {

            // show doctors in the hospital
            case 1:
                Iterator<Department> departmentIterator = hospital.getDepartments().iterator();
                while (departmentIterator.hasNext()) {
                    Department department = departmentIterator.next();
                    System.out.println(department.getName() + "'s doctors: " + department.getDoctors());
                }
                doctorItems(hospital);
                break;

            // show doctors in the department
            case 2:
                showAvailableDepartments(hospital);
                try {
                    System.out.println("Enter the department:");
                    String scanner = new Scanner(System.in).nextLine();
                    for (Iterator<Department> iterator = hospital.getDepartments().iterator(); iterator.hasNext(); ) {
                        Department department = iterator.next();
                        if (department.getName().equals(scanner)) {
                            System.out.println(department.getName() + ": " + department.getDoctors());
                        }
                    }
                }catch (Exception exception){
                    System.out.println("Wrong input!");
                }
                doctorItems(hospital);
                break;

            // add doctor to the department
            case 3:
                String scanner1;
                try {
                    showAvailableDepartments(hospital);

                    scanner1 = new Scanner(System.in).nextLine();

                    Iterator<Department> departmentIterator3 = hospital.getDepartments().iterator();

                    while (departmentIterator3.hasNext()) {

                        Department d = departmentIterator3.next();
                        if (d.getName().equals(scanner1)) {

                            String name, surname, issue, education, contract, license;
                            GregorianCalendar birth;
                            Integer year, month, day, payment;

                            System.out.println("Enter: ");
                            name = InputRequest.stringRequest(" - Name: ");
                            surname = InputRequest.stringRequest(" - Surname: ");

                            System.out.println(" - Birth...");

                            year = InputRequest.intRequest("Year: ");
                            month = InputRequest.intRequest("Month: ");
                            day = InputRequest.intRequest("Day: ");
                            birth = new GregorianCalendar(year, month, day);

                            issue = InputRequest.stringRequest(" - Issue: ");
                            education = InputRequest.stringRequest(" - Education: ");
                            contract =  InputRequest.stringRequest(" - Contract: ");

                            payment = InputRequest.intRequest(" - Pay check: ");

                            license = InputRequest.stringRequest(" - License before: ");

                            d.addDoctor(new Doctor(name, surname, birth, issue, education, contract, payment, license));
                        }
                    }
                } catch (Exception exception1) {
                    System.out.println("Wrong input. Check input information");
                }
                doctorItems(hospital);
                break;

            // remove doctor from the department
            case 4:
                showAvailableDepartments(hospital);
                try {
                System.out.println("Enter the name of a Department from which you want to remove: ");
                    String departmentFromRemove = new Scanner(System.in).nextLine();
                    Iterator<Department> departmentIterator2 = hospital.getDepartments().iterator();
                    while (departmentIterator2.hasNext()) {
                        Department department = departmentIterator2.next();
                        if (department.getName().equals(departmentFromRemove)) {

                            Iterator<Doctor> doctorIt = department.getDoctors().iterator();
                            while (doctorIt.hasNext()) {
                                Doctor doc = doctorIt.next();
                                System.out.println("Doctor name to remove: " + doc.getName());
                            }

                            System.out.println("Enter the name of a Doctor to remove from " + department.getName() +
                                    " department: ");
                            String doctorToRemove = new Scanner(System.in).nextLine();

                            department.removeDoctor(doctorToRemove);
                        }
                    }
                } catch (Exception exception) {
                    System.out.println("Incorrect input");
                }
                doctorItems(hospital);
                break;

            // assign the lead doctor
            case 5:
                showAvailableDepartments(hospital);
                System.out.println("Enter the name of a Department to which you want to promote: ");
                try {
                    String departmentToHead = new Scanner(System.in).nextLine();
                    Iterator<Department> departmentIterator2 = hospital.getDepartments().iterator();
                    while (departmentIterator2.hasNext()) {
                        Department department = departmentIterator2.next();
                        if (department.getName().equals(departmentToHead)) {
                            Iterator<Doctor> doctorIt = department.getDoctors().iterator();
                            while (doctorIt.hasNext()) {
                                Doctor doc = doctorIt.next();
                                System.out.println("Doctor name to promote: " + doc.getName());
                            }

                            System.out.println("Enter the name of a Doctor to promote to " +
                                    department.getName() + " department: ");
                            String doctorToPromote = new Scanner(System.in).nextLine();

                            Iterator<Doctor> doctorIt2 = department.getDoctors().iterator();
                            while (doctorIt2.hasNext()) {
                                Doctor doc = doctorIt2.next();
                                if(doc.getName().equals(doctorToPromote)) {
                                    department.setHeadDoctor(doc);
                                    System.out.println("Department " + department.getName() + " now lead by " + doc.getName());
                                }
                            }
                        }
                    }
                } catch (Exception exception) {
                    System.out.println("Incorrect input");
                }
                doctorItems(hospital);
                break;

            // return to the menu
            case 6:
                editHospital(hospital);
                break;

            // exit
            case 7:
                AdminMenu.mainMenuHandler(Menu.EXIT);

        }
    }*/
}
