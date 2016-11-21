package by.nc.shpakovskaya.console.utils;

import java.util.Scanner;

/**
 * Created by Valeria on 29.10.2016.
 */
public class InputRequest {

    public static String stringRequest(String sentence) {

        String name = null;
        try {
            System.out.print(sentence);
            name = new Scanner(System.in).nextLine();
            return name;
        } catch (Exception exception) {
            System.out.println("Incorrect input");
            stringRequest(sentence);
        }

        return name;
    }

    public static Integer intRequest(String sentence) {
        Integer name = null;
        try {
            System.out.print(sentence);
            name = new Scanner(System.in).nextInt();
            return name;
        } catch (Exception exception) {
            System.out.println("Incorrect input");
            intRequest(sentence);
        }

        return name;
    }

}
