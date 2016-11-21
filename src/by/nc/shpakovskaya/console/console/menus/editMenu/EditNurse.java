package by.nc.shpakovskaya.console.console.menus.editMenu;

import by.nc.shpakovskaya.beans.Hospital;

/**
 * Created by Valeria on 27.10.2016.
 */
public class EditNurse {
/*
    public static void nurseItems(Enum enumName, Hospital hospital) {

        Map<Integer, String> editNurse = new HashMap<>();
        editNurse.put(1, "Press 1 to show Nurses in the hospital");
        editNurse.put(2, "Press 2 to show Nurses in the department");
        editNurse.put(3, "Press 3 to add Nurse to the department");
        editNurse.put(4, "Press 4 to remove Nurse from the hospital");
        editNurse.put(5, "Press 5 to get Nurses the room");
        editNurse.put(6, "Press 6 to assign Nurse the room");
        editNurse.put(7, "Press 7 to up to menu");
        editNurse.put(8, "Press 8 to exit");

        switch (MenuExceptionCheck.checkAtExceptions(editNurse)) {

            // show nurses in the hospital
            case 1:
                Iterator<Department> departmentIterator = hospital.getDepartments().iterator();
                while (departmentIterator.hasNext()) {
                    Department department = departmentIterator.next();
                    System.out.println(department.getName() + "'s nurses: " + department.getNurses());
                }
                nurseItems(enumName, hospital);
                break;

            // show nurses in the department
            case 2:
                showAvailableDepartments(hospital);
                try {
                    System.out.println("Enter the department:");
                    String scanner = new Scanner(System.in).nextLine();
                    for (Iterator<Department> iterator = hospital.getDepartments().iterator(); iterator.hasNext(); ) {
                        Department department = iterator.next();
                        if (department.getName().equals(scanner)) {
                            System.out.println(department.getName() + ": " + department.getNurses());
                        }
                    }
                } catch (Exception exception) {
                    System.out.println("Wrong input!");
                }
                nurseItems(enumName, hospital);
                break;

            // add nurse to the department
            case 3:
                String scanner1;
                try {
                    showAvailableDepartments(hospital);

                    scanner1 = new Scanner(System.in).nextLine();

                    Iterator<Department> departmentIterator3 = hospital.getDepartments().iterator();

                    while (departmentIterator3.hasNext()) {

                        Department department = departmentIterator3.next();
                        if (department.getName().equals(scanner1)) {

                            String name, surname, issue, education, contract;
                            GregorianCalendar birth;
                            Integer payment, year, month, day;

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


                            department.addNurse(new Nurse(name, surname, birth, issue, education, contract, payment));
                        }
                    }
                } catch (Exception exception1) {
                    System.out.println("Wrong input. Check input information");
                }
                nurseItems(enumName, hospital);
                break;

            // remove nurse from the department
            case 4:
                showAvailableDepartments(hospital);
                try {
                    System.out.println("Enter the name of a Department from which you want to remove: ");
                    String departmentFromRemove = new Scanner(System.in).nextLine();
                    Iterator<Department> departmentIterator2 = hospital.getDepartments().iterator();
                    while (departmentIterator2.hasNext()) {
                        Department department = departmentIterator2.next();
                        if (department.getName().equals(departmentFromRemove)) {

                            Iterator<Nurse> nurseIt = department.getNurses().iterator();
                            while (nurseIt.hasNext()) {
                                Nurse nurse = nurseIt.next();
                                System.out.println("Nurse name to remove: " + nurse.getName());
                            }

                            System.out.println("Enter the name of a Nurse to remove from " + department.getName() +
                                    " department: ");
                            String nurseToRemove = new Scanner(System.in).nextLine();

                            department.removeNurse(nurseToRemove);
                        }
                    }
                } catch (Exception exception) {
                    System.out.println("Incorrect input");
                }
                nurseItems(enumName, hospital);
                break;

            // get the Nurses room
            case 5:
                System.out.println("Enter the name of a Nurse whose rooms you want to show: ");
                try {
                    String nurseName = new Scanner(System.in).nextLine();
                    Iterator<Department> departmentIterator1 = hospital.getDepartments().iterator();
                    while (departmentIterator1.hasNext()){
                        Department department = departmentIterator1.next();
                        Iterator<Nurse> nurseIterator = department.getNurses().iterator();
                        while (nurseIterator.hasNext()){
                            Nurse nextNurse = nurseIterator.next();
                            if(nextNurse.getName().equals(nurseName)){
                                System.out.println("Rooms under nurse " + nextNurse.getName() + " vision: " +
                                        nextNurse.getRooms());
                            }
                        }
                    }

                } catch (Exception exception){
                    System.out.println("Incorrect input.");
                }
                nurseItems(enumName, hospital);
                break;

            // assign the room to rhe Nurse
            case 6:
                Iterator<Department> departmentIterator2 = hospital.getDepartments().iterator();
                while (departmentIterator2.hasNext()){
                    Department nextDepartment = departmentIterator2.next();
                    System.out.println("Available nurses from " + nextDepartment.getName() +
                            " department" + nextDepartment.getNurses());
                }
                System.out.println("Enter the name of a Nurse to add room: ");
                try {
                    String nurseName = new Scanner(System.in).nextLine();
                    Iterator<Department> departmentIterator1 = hospital.getDepartments().iterator();
                    while (departmentIterator1.hasNext()){
                        Department department = departmentIterator1.next();
                        Iterator<Nurse> nurseIterator = department.getNurses().iterator();
                        while (nurseIterator.hasNext()){
                            Nurse nextNurse = nurseIterator.next();
                            if(nextNurse.getName().equals(nurseName)){
                                System.out.println("Available rooms: " + department.getRooms() +
                                        "\nChoose the room: ");
                                Integer roomToAssign = new Scanner(System.in).nextInt();
                                Iterator<Room> roomIterator = department.getRooms().iterator();
                                while(roomIterator.hasNext()){
                                    Room nextRoom = roomIterator.next();
                                    if(nextRoom.getNumber().equals(roomToAssign)){
                                        nextNurse.addRoom(nextRoom);
                                        System.out.println("Room " + nextRoom.getNumber() + " now under vision of " +
                                                nextNurse.getName());
                                    }
                                }
                            }
                        }
                    }

                } catch (Exception exception){
                    System.out.println("Incorrect input.");
                }
                nurseItems(enumName, hospital);
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
