package by.nc.shpakovskaya.console.serialization;


import java.io.*;


/**
 * Created by Valeria on 21.10.2016.
 */
public class SerializationOwn {

    public void serialize(Object o, String path) {

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("src/by/nc/shpakovskaya/console/data/binary_out/" + path + ".out");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(o);
            oos.flush();
            oos.close();
        }catch(IOException exception){
            System.out.println(exception.getMessage());
        }finally{
            try{
                if(fos != null)
                    fos.close();
            }
            catch(IOException exception){
                System.out.println(exception.getMessage());
            }
        }
    }

    public static Object deserialize(String s) {
        FileInputStream fis = null;
        try{
        fis = new FileInputStream("src/by/nc/shpakovskaya/console/data/binary_out" + s);
        ObjectInputStream oin = new ObjectInputStream(fis);

        return (Object) oin.readObject();
        }catch(IOException | ClassNotFoundException exception){
            System.out.println(exception.getMessage());
    //        mainMenuHandler(EditMenuHandler.Menu.MAIN);

        } finally{
            try{
                if(fis != null)
                    fis.close();
            }
            catch(IOException exception){
                System.out.println(exception.getMessage());
            }
        }
        return null;
    }

}
