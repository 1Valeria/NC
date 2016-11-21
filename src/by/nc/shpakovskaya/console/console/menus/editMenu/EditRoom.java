package by.nc.shpakovskaya.console.console.menus.editMenu;

import by.nc.shpakovskaya.beans.Hospital;

/**
 * Created by Valeria on 28.10.2016.
 */
public class EditRoom {/*
    public static void roomItems(Enum enumName, Hospital hospital) {
        Map<Integer, String> editRoom = new HashMap<>();
        editRoom.put(1, "Press 1 to show all rooms in the hospital");
        editRoom.put(2, "Press 2 to show rooms in the department");
        editRoom.put(3, "Press 3 to add room to the department");
        editRoom.put(4, "Press 4 to remove room from the department");
        editRoom.put(5, "Press 5 to up to menu");
        editRoom.put(6, "Press 6 to exit");

        switch (MenuExceptionCheck.checkAtExceptions(editRoom)) {

            // show all rooms in the hospital
            case 1:
                Iterator<Department> departmentIterator = hospital.getDepartments().iterator();
                while (departmentIterator.hasNext()) {
                    Department department = departmentIterator.next();
                    System.out.println("Rooms in the " + department.getName() + " department: " +
                            department.getRooms());
                }
                roomItems(enumName, hospital);
                break;

            //show rooms in the department
            case 2:
                showAvailableDepartments(hospital);
                Iterator<Department> departmentIterator2 = hospital.getDepartments().iterator();
                try {
                    String departmentToShowRooms = new Scanner(System.in).nextLine();
                    while (departmentIterator2.hasNext()) {
                        Department nextDepartment = departmentIterator2.next();
                        if (nextDepartment.getName().equals(departmentToShowRooms)) {
                            System.out.println("Rooms in the " + nextDepartment.getName() + "'s department: " +
                                    nextDepartment.getRooms());
                        }
                    }
                }catch(Exception exception){
                    System.out.println("Error!");
                }
                roomItems(enumName, hospital);
                break;

            // add room to the department
            case 3:
                Iterator<Department> departmentIterator3 = hospital.getDepartments().iterator();
                try {
                    showAvailableDepartments(hospital);
                    System.out.println("Enter the name of department where you want to add room: ");
                    String departmentToShowRooms = new Scanner(System.in).nextLine();
                    while (departmentIterator3.hasNext()) {
                        Department nextDepartment = departmentIterator3.next();
                        if (nextDepartment.getName().equals(departmentToShowRooms)) {
                            System.out.println("Enter the number of room to add to the " + nextDepartment.getName() +
                            " department: ");
                            Integer roomToAdd = new Scanner(System.in).nextInt();
                            nextDepartment.addRoom(new Room(roomToAdd));
                            System.out.println("Room " + roomToAdd + " was successful added to the " +
                                    nextDepartment.getName() + "'s department");
                        }
                    }
                }catch(Exception exception){
                    System.out.println("Error! Incorrect input");
                }
                roomItems(enumName, hospital);
                break;

            // remove room from the department
            case 4:
                Iterator<Department> departmentIterator0 = hospital.getDepartments().iterator();
                while (departmentIterator0.hasNext()) {
                    Department department = departmentIterator0.next();
                    System.out.println("Rooms in the " + department.getName() + " department: " +
                            department.getRooms());
                }
                Iterator<Department> departmentIterator4 = hospital.getDepartments().iterator();
                try {
                    showAvailableDepartments(hospital);
                    System.out.println("Enter the name of department where you want to remove the room: ");
                    String departmentToRemoveRooms = new Scanner(System.in).nextLine();
                    while (departmentIterator4.hasNext()) {
                        Department nextDepartment = departmentIterator4.next();
                        if (nextDepartment.getName().equals(departmentToRemoveRooms)) {
                            System.out.println("Enter the number of room to remove from the " + nextDepartment.getName() +
                                    " department: ");
                            Integer roomToRemove = new Scanner(System.in).nextInt();
                            nextDepartment.removeRoom(roomToRemove);
                            System.out.println("Room " + roomToRemove + " was successful removed from the " +
                                    nextDepartment.getName() + "'s department");
                        }
                    }
                }catch(Exception exception){
                    System.out.println("Incorrect input");
                }
                roomItems(enumName, hospital);
                break;

            // up to menu
            case 5:
                editHospital(hospital);
                break;

            // exit
            case 6:
                AdminMenu.mainMenuHandler(EditMenuHandler.Menu.EXIT);
        }
    }
    */
}
