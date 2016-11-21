package by.nc.shpakovskaya.beans.roles.administrator;

import by.nc.shpakovskaya.dao.Entity;

/**
 * Created by Valeria on 18.11.2016.
 */
public class Administrator extends Entity{
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String login;
    private String password;

    public Administrator(String name, String surname, String email, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public Administrator(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Administrator administrator = (Administrator) o;

        if (id != null ? !id.equals(administrator.id) : administrator.id != null) return false;
        if (name != null ? !name.equals(administrator.name) : administrator.name != null) return false;
        if (surname != null ? !surname.equals(administrator.surname) : administrator.surname != null) return false;
        if (login != null ? !login.equals(administrator.login) : administrator.login != null) return false;
        if (password != null ? !password.equals(administrator.password) : administrator.password != null) return false;
        return email != null ? email.equals(administrator.email) : administrator.email == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

}
