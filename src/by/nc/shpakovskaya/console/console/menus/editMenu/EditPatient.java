package by.nc.shpakovskaya.console.console.menus.editMenu;

/**
 * Created by Valeria on 28.10.2016.
 */
public class EditPatient {/*
    public static void patientItems(Enum enumName, Hospital hospital){
        Map<Integer, String> editPatient = new HashMap<>();
        editPatient.put(1, "Press 1 to show all patients in the hospital");
        editPatient.put(2, "Press 2 to show patients in the department");
        editPatient.put(3, "Press 3 to add patient to the department");
        editPatient.put(4, "Press 4 to remove patient from the hospital");
        editPatient.put(5, "Press 5 to get patients room");
        editPatient.put(6, "Press 6 to assign patient the room");
        editPatient.put(7, "Press 7 to up to menu");
        editPatient.put(8, "Press 8 to exit");

        switch (MenuExceptionCheck.checkAtExceptions(editPatient)) {

            // show patient in the hospital
            case 1:
                Iterator<Department> departmentIterator = hospital.getDepartments().iterator();
                while (departmentIterator.hasNext()) {
                    Department department = departmentIterator.next();
                    System.out.println(department.getName() + "'s patients: " + department.getPatients());
                }
                patientItems(enumName, hospital);
                break;

            // show patients in the department
            case 2:
                showAvailableDepartments(hospital);
                try {
                    System.out.println("Enter the department:");
                    String scanner = new Scanner(System.in).nextLine();
                    for (Iterator<Department> iterator = hospital.getDepartments().iterator(); iterator.hasNext(); ) {
                        Department department = iterator.next();
                        if (department.getName().equals(scanner)) {
                            System.out.println(department.getName() + ": " + department.getPatients());
                        }
                    }
                } catch (Exception exception) {
                    System.out.println("Wrong input!");
                }
                patientItems(enumName, hospital);
                break;

            // add patient to the department
            case 3:
                String scanner1;
                try {
                    showAvailableDepartments(hospital);

                    scanner1 = new Scanner(System.in).nextLine();

                    Iterator<Department> departmentIterator3 = hospital.getDepartments().iterator();
                    while (departmentIterator3.hasNext()) {

                        Department department = departmentIterator3.next();
                        if (department.getName().equals(scanner1)) {

                            String name, surname, issue;
                            GregorianCalendar birth;
                            Integer year, month, day;

                            System.out.println("Enter: ");
                            name = InputRequest.stringRequest(" - Name: ");
                            surname = InputRequest.stringRequest(" - Surname: ");

                            System.out.println(" - Birth...");

                            year = InputRequest.intRequest("Year: ");
                            month = InputRequest.intRequest("Month: ");
                            day = InputRequest.intRequest("Day: ");
                            birth = new GregorianCalendar(year, month, day);

                            issue = InputRequest.stringRequest(" - Issue: ");

                            department.addPatient(new Patient(name, surname, birth, issue));
                        }
                    }
                } catch (Exception exception1) {
                    System.out.println("Wrong input. Check input information");
                }
                patientItems(enumName, hospital);
                break;

            // remove patient from the department
            case 4:
                showAvailableDepartments(hospital);
                try {
                    System.out.println("Enter the name of a Department from which you want to remove: ");
                    String departmentFromRemove = new Scanner(System.in).nextLine();
                    Iterator<Department> departmentIterator2 = hospital.getDepartments().iterator();
                    while (departmentIterator2.hasNext()) {
                        Department department = departmentIterator2.next();
                        if (department.getName().equals(departmentFromRemove)) {

                            Iterator<Patient> patientIt = department.getPatients().iterator();
                            while (patientIt.hasNext()) {
                                Patient patient = patientIt.next();
                                System.out.println("Patient name to remove: " + patient.getName());
                            }

                            System.out.println("Enter the name of a Patient to remove from " + department.getName() +
                                    " department: ");
                            String patientToRemove = new Scanner(System.in).nextLine();

                            department.removePatient(patientToRemove);
                        }
                    }
                } catch (Exception exception) {
                    System.out.println("Incorrect input");
                }
                patientItems(enumName, hospital);
                break;

            // get the Patients room
            case 5:
                Iterator<Department> departmentIterator2 = hospital.getDepartments().iterator();
                while (departmentIterator2.hasNext()) {
                    System.out.println("Patient name whose room to show: " + departmentIterator2.next().getPatients());
                }

                System.out.println("Enter the name of a Patient whose rooms you want to show: ");

                try {
                    String patientName = new Scanner(System.in).nextLine();
                    Iterator<Department> departmentIterator1 = hospital.getDepartments().iterator();
                    while (departmentIterator1.hasNext()){
                        Department department = departmentIterator1.next();
                        Iterator<Patient> patientIterator = department.getPatients().iterator();
                        while (patientIterator.hasNext()){
                            Patient nextPatient = patientIterator.next();
                            if(nextPatient.getName().equals(patientName)){
                                System.out.println(nextPatient.getName() + " is placed in: " +
                                        nextPatient.getRoom());
                            }
                        }
                    }

                } catch (Exception exception){
                    System.out.println("Incorrect input.");
                }
                patientItems(enumName, hospital);
                break;

            // assign the room to rhe Patient
            case 6:
                Iterator<Department> departmentIterator3 = hospital.getDepartments().iterator();
                while (departmentIterator3.hasNext()){
                    Department nextDepartment = departmentIterator3.next();
                    System.out.println("Available patients from " + nextDepartment.getName() +
                            " department" + nextDepartment.getPatients());
                }
                System.out.println("Enter the name of a patient to add room: ");
                try {
                    String patientName = new Scanner(System.in).nextLine();
                    Iterator<Department> departmentIterator1 = hospital.getDepartments().iterator();
                    while (departmentIterator1.hasNext()){
                        Department department = departmentIterator1.next();
                        Iterator<Patient> patientIterator = department.getPatients().iterator();
                        while (patientIterator.hasNext()){
                            Patient nextPatient = patientIterator.next();
                            if(nextPatient.getName().equals(patientName)){
                                System.out.println("Available rooms: " + department.getRooms() +
                                        "\nChoose the room: ");
                                Integer roomToAssign = new Scanner(System.in).nextInt();
                                Iterator<Room> roomIterator = department.getRooms().iterator();
                                while(roomIterator.hasNext()){
                                    Room nextRoom = roomIterator.next();
                                    if(nextRoom.getNumber().equals(roomToAssign)){
                                        nextPatient.setRoom(nextRoom);
                                        System.out.println("Room " + nextRoom.getNumber() + " now under " +
                                                nextPatient.getName() + " patient");
                                    }
                                }
                            }
                        }
                    }

                } catch (Exception exception){
                    System.out.println("Incorrect input.");
                }
                patientItems(enumName, hospital);
                break;

            // up to the menu
            case 7:
                editHospital(hospital);
                break;

            // exit
            case 8:
                AdminMenu.mainMenuHandler(EditMenuHandler.Menu.EXIT);
        }
    }*/
}
