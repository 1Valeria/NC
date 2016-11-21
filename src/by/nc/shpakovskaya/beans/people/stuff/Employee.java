package by.nc.shpakovskaya.beans.people.stuff;

import by.nc.shpakovskaya.beans.people.Person;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * Created by Valeria on 18.10.2016.
 */
public abstract class Employee extends Person implements Serializable{

    private String education;
    private String contract;
    private Integer payment;

    public Employee(String name, String surname, GregorianCalendar birth, String issue, String education, String contract,
                    Integer payment) {
        super(name, surname, birth, issue);
        this.education = education;
        this.contract = contract;
        this.payment = payment;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Employee employee = (Employee) o;

        if (education != null ? !education.equals(employee.education) : employee.education != null) return false;
        if (contract != null ? !contract.equals(employee.contract) : employee.contract != null) return false;
        return payment != null ? payment.equals(employee.payment) : employee.payment == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (contract != null ? contract.hashCode() : 0);
        result = 31 * result + (payment != null ? payment.hashCode() : 0);
        return result;
    }
}
