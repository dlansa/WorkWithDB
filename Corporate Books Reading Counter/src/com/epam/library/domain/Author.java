package com.epam.library.domain;

import java.util.Date;

public class Author extends Entity {

    private String name;
    private Date birth;

    public Author(int id, String name, Date birth) {
        super(id);
        this.name = name;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;

        Author author = (Author) o;

        if (getName() != null ? !getName().equals(author.getName()) : author.getName() != null) return false;
        return getBirth() != null ? getBirth().equals(author.getBirth()) : author.getBirth() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getBirth() != null ? getBirth().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Author name: " + name + " (" + birth + ").";
    }
}

