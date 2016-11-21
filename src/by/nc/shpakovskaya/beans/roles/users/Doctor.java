package by.nc.shpakovskaya.beans.roles.users;

import by.nc.shpakovskaya.dao.Entity;

/**
 * Created by Valeria on 21.11.2016.
 */
public class Doctor extends Entity{

    private String name;
    private String surname;
    private String email;
    private String login;
    private String password;
    private String admit = "no";

}
