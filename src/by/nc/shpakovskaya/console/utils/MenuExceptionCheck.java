package by.nc.shpakovskaya.console.utils;

import java.util.Map;
import java.util.Scanner;

/**
 * Created by Valeria on 23.10.2016.
 */
public class MenuExceptionCheck {

    public static Integer checkAtExceptions(Map<Integer, String> menuMap) {

        System.out.println("--------------------------------------------------");

        for (int i = 0; i < menuMap.size(); i++) {
            System.out.println(menuMap.get(i + 1));
        }

        System.out.println("--------------------------------------------------");

        System.out.println("Enter the number: ");
        String inputtedVariable = new Scanner(System.in).next();

        try {
            Integer variable = new Integer(inputtedVariable);
            if (menuMap.containsKey(variable)) {
                return variable;
            } else {
                System.out.println("Enter the variable from the list!");
                checkAtExceptions(menuMap);
            }

        } catch (Exception ex) {
            System.out.println("Input the correct request.");
            checkAtExceptions(menuMap);
        }
        return 0;
    }
}