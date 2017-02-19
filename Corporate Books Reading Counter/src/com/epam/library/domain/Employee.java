package com.epam.library.domain;

import java.util.Date;

public class Employee extends Entity{

    private String name;
    private String mail;
    private Date dateOfBirth;
    private Book[] books;

    public Employee() {
        super();
    }

    public Employee(String name, String mail, Date dateOfBirth) {
        this.name = name;
        this.mail = mail;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (!getName().equals(employee.getName())) return false;
        if (!getMail().equals(employee.getMail())) return false;
        return getDateOfBirth().equals(employee.getDateOfBirth());

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getMail().hashCode();
        result = 31 * result + getDateOfBirth().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + ". " + name + " (" + dateOfBirth + ") , e=mail: " + mail;
    }
}
