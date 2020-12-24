package entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(schema = "public", name="BOOK")
public class Book implements Serializable{

    private int id;
    private String title;
    private int price;
    private  int year;

    private Collection<Author> authors;

    public Book() {
    }

    public Book(int id, String title, int price, int year){
        this.id = id;
        this.title = title;
        this.price = price;
        this.year = year;
    }

    @Id
    @Column(name="ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="PRICE")
    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    @Column(name="YEAR")
    public int getYear(){
        return year;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setAuthors(Collection<Author> authors) {
        this.authors = authors;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "BOOK_AUTHOR",
            joinColumns = {@JoinColumn(name = "ID_BOOK")},
            inverseJoinColumns = {@JoinColumn(name = "ID_AUTHOR")})
    public Collection<Author> getAuthors() {
        return authors;
    }
}