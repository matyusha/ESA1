package entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(schema = "public", name="AUTHOR")
public class Author implements Serializable{

    private int id;
    private String name;
    private String surname;

    private Collection<Book> books;

    public Author() {}

    public Author(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    @Id
    @Column(name="ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="SURNAME")
    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "AUTH_BOOK", joinColumns = {
             @JoinColumn(name = "ID_AUTH")
    }, inverseJoinColumns = {
            @JoinColumn(name = "ID_BOOK")
    })
    public Collection<Book> getBooks() {
        return this.books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }

}
