package com.epam.library.domain;

public class Book extends Entity{

    private String title;
    private Author author;
    private int publishYear;

    public Book() {
    }

    public Book(int id, String title, Author author) {
        super(id);
        this.title = title;
        this.author = author;
    }

    public Book(String title, int auID, int publishYear) {
        this.title = title;
        this.publishYear = publishYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (getPublishYear() != book.getPublishYear()) return false;
        if (getTitle() != null ? !getTitle().equals(book.getTitle()) : book.getTitle() != null) return false;
        return getAuthor() != null ? getAuthor().equals(book.getAuthor()) : book.getAuthor() == null;

    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        result = 31 * result + getPublishYear();
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + ". \"" + title + "\" " + author + " (" + publishYear + ").";
    }
}
