package by.nc.shpakovskaya;


import org.apache.log4j.Logger;

/**
 * Created by Valeria on 20.10.2016.
 */
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("Main console to check some parts");

/*
********* Для работы с командной строкой *********
      DataBases.base();
      LogInScreen.printMe();
*/


/*
********* Проверка БД *********

        Client newClient = new Client("Валерия", "Shpakovskaya", "shpakovskaya.valeriya.14@gmail.com", "valeria123",
                    "fuckingpassword");
        ClientService clientService = new ClientService();
        clientService.addClient(newClient);


        List<Client> clients = clientService.getClients();
        for (Client client : clients) {
            System.out.println(client.getId());
            System.out.println(client.getName());
            System.out.println(client.getSurname());
        }
*/
    }
}

