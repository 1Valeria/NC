package by.nc.shpakovskaya.beans.roles.users;

import by.nc.shpakovskaya.dao.Entity;

/**
 * Created by Valeria on 21.11.2016.
 */
public class Doctor extends Entity{


    private String name;
    private String surname;
    private String issue;
    private String education;
    private String email;
    private String login;
    private String password;
    private String admit = "no";

    public Doctor(){}

    public Doctor(String name, String surname, String issue, String education, String email, String login,
                  String password) {
        this.name = name;
        this.surname = surname;
        this.issue = issue;
        this.education = education;
        this.email = email;
        this.login = login;
        this.password = password;
    }


    public int getId() {
        return super.getId();
    }

    public void setId(int id) {
        super.setId(id);
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

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getAdmit() {
        return admit;
    }

    public void setAdmit(String admit) {
        this.admit = admit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Doctor doctor = (Doctor) o;

        if (name != null ? !name.equals(doctor.name) : doctor.name != null) return false;
        if (surname != null ? !surname.equals(doctor.surname) : doctor.surname != null) return false;
        if (issue != null ? !issue.equals(doctor.issue) : doctor.issue != null) return false;
        if (education != null ? !education.equals(doctor.education) : doctor.education != null) return false;
        if (email != null ? !email.equals(doctor.email) : doctor.email != null) return false;
        if (login != null ? !login.equals(doctor.login) : doctor.login != null) return false;
        if (password != null ? !password.equals(doctor.password) : doctor.password != null) return false;
        return admit != null ? admit.equals(doctor.admit) : doctor.admit == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (issue != null ? issue.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (admit != null ? admit.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", issue='" + issue + '\'' +
                ", education='" + education + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", admit='" + admit + '\'' +
                '}';
    }
}
