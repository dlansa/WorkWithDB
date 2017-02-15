package com.epam.library.domain;

import java.util.Arrays;

public class Book {

    private String title;
    private String author;
    private int id;
    private int dateOfPublishing;
    private Employee[] employees;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDateOfPublishing() {
        return dateOfPublishing;
    }

    public void setDateOfPublishing(int dateOfPublishing) {
        this.dateOfPublishing = dateOfPublishing;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (getId() != book.getId()) return false;
        if (getDateOfPublishing() != book.getDateOfPublishing()) return false;
        if (!getTitle().equals(book.getTitle())) return false;
        if (!getAuthor().equals(book.getAuthor())) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getEmployees(), book.getEmployees());

    }

    @Override
    public int hashCode() {
        int result = getTitle().hashCode();
        result = 31 * result + getAuthor().hashCode();
        result = 31 * result + getId();
        result = 31 * result + getDateOfPublishing();
        result = 31 * result + Arrays.hashCode(getEmployees());
        return result;
    }

    @Override
    public String toString() {
        return id + ". Book title " + title +", author " + author + ", dateOfPublishing " + dateOfPublishing;
    }
}
