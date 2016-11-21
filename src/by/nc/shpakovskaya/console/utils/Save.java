package by.nc.shpakovskaya.console.utils;

import by.nc.shpakovskaya.beans.Hospital;
import by.nc.shpakovskaya.console.serialization.SerializationOwn;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 * Created by Valeria on 27.10.2016.
 */
public class Save {

    public static void saveHospital(Hospital hospital) {
        String isSave = "";
        while (!isSave.equals("y") && !isSave.equals("n")) {
            System.out.println("Do you want to save this hospital? (y/n)");
            isSave = new Scanner(System.in).next();
            switch (isSave) {
                case "y":
                    SerializationOwn userSerialization = new SerializationOwn();
                    System.out.println("Enter the name to save file: ");
                    userSerialization.serialize(hospital, new Scanner(System.in).nextLine());
                    System.out.println("All saved successful.");
//                    mainMenuHandler(EditMenuHandler.Menu.MAIN);
                    break;
                case "n":
                    System.out.println("All your entered data will be erased.");
                    isSave = "n";
//                    mainMenuHandler(EditMenuHandler.Menu.MAIN);
                    break;
            }
        }
    }

    public static void saveHospitalTxt(Hospital hospital){
        System.out.println("Enter the name for txt file: ");
        String pathToSave = new Scanner(System.in).nextLine();
        try(FileWriter writer = new FileWriter("src/by/nc/shpakovskaya/console/data/" + pathToSave + ".txt", false))
        {
            writer.write(hospital.toString());
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            System.out.println("Incorrect input");
        }
    }
}
