package by.nc.shpakovskaya.console.console.menus.editMenu;

/**
 * Created by Valeria on 28.10.2016.
 */
public class EditDiagnosis {/*
    public static void diagnosisItems(Hospital hospital){

        Map<Integer, String> editDiagnosis = new HashMap<>();
        editDiagnosis.put(1, "Press 1 to show all diagnosis in the hospital");
        editDiagnosis.put(2, "Press 2 to show diagnosis in the department");
        editDiagnosis.put(3, "Press 3 to add diagnosis to the department");
        editDiagnosis.put(4, "Press 4 to remove diagnosis from the department");
        editDiagnosis.put(5, "Press 5 to up to menu");
        editDiagnosis.put(6, "Press 6 to exit");

        switch (MenuExceptionCheck.checkAtExceptions(editDiagnosis)) {

            // show diagnoses in the hospital
            case 1:
                Iterator<Department> departmentIterator = hospital.getDepartments().iterator();
                while (departmentIterator.hasNext()) {
                    Department department = departmentIterator.next();
                    System.out.println(department.getName() + "'s diagnoses: " + department.getDiagnoses());
                }
                diagnosisItems(hospital);
                break;

            // show diagnosiss in the department
            case 2:
                showAvailableDepartments(hospital);
                try {
                    System.out.println("Enter the department:");
                    String scanner = new Scanner(System.in).nextLine();
                    for (Iterator<Department> iterator = hospital.getDepartments().iterator(); iterator.hasNext(); ) {
                        Department department = iterator.next();
                        if (department.getName().equals(scanner)) {
                            System.out.println(department.getName() + ": " + department.getDiagnoses());
                        }
                    }
                } catch (Exception exception) {
                    System.out.println("Wrong input!");
                }
                diagnosisItems(hospital);
                break;

            // add diagnosis to the department
            case 3:
                String scanner1;
                try {
                    showAvailableDepartments(hospital);

                    scanner1 = new Scanner(System.in).nextLine();

                    Iterator<Department> departmentIterator3 = hospital.getDepartments().iterator();
                    while (departmentIterator3.hasNext()) {

                        Department department = departmentIterator3.next();
                        if (department.getName().equals(scanner1)) {

                            String name;

                            System.out.println("Enter the term of the diagnosis: ");
                            name = new Scanner(System.in).nextLine();

                            department.addDiagnosis(new Diagnosis(name));
                        }
                    }
                } catch (Exception exception1) {
                    System.out.println("Wrong input. Check input information");
                }
                diagnosisItems(hospital);
                break;

            // remove diagnosis from the department
            case 4:
                showAvailableDepartments(hospital);
                try {
                    System.out.println("Enter the name of a Department from which you want to remove: ");
                    String departmentFromRemove = new Scanner(System.in).nextLine();
                    Iterator<Department> departmentIterator2 = hospital.getDepartments().iterator();
                    while (departmentIterator2.hasNext()) {
                        Department department = departmentIterator2.next();
                        if (department.getName().equals(departmentFromRemove)) {

                            Iterator<Diagnosis> doctorIt = department.getDiagnoses().iterator();
                            while (doctorIt.hasNext()) {
                                Diagnosis diagnosis = doctorIt.next();
                                System.out.println("Diagnosis name to remove: " + diagnosis.getName());
                            }

                            System.out.println("Enter the name of a Diagnosis to remove from " + department.getName() +
                                    " department: ");
                            String diagnosisToRemove = new Scanner(System.in).nextLine();

                            department.removeDiagnosis(diagnosisToRemove);
                        }
                    }
                } catch (Exception exception) {
                    System.out.println("Incorrect input");
                }
                diagnosisItems(hospital);
                break;

            // up to the menu
            case 5:
                editHospital(hospital);
                break;

            // exit
            case 6:
                AdminMenu.mainMenuHandler(EditMenuHandler.Menu.EXIT);
        }
    }*/
}
