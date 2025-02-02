package com.courselibraryy.courselibrary.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "isbn", length = 50, nullable = false, unique = true)
    private String isbn;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "description", length = 250, nullable = false)
    private String description;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "books_authors",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private Set<Author> authors = new HashSet<Author>();

    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="books_categories",
            joinColumns ={@JoinColumn(name="book_id")},
            inverseJoinColumns = {@JoinColumn(name="category_id")})
    private Set<Category> categories=new HashSet<Category>();

    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="books_publishers",
            joinColumns ={@JoinColumn(name="book_id")},
            inverseJoinColumns = {@JoinColumn(name="publisher_id")})
    private Set<Publishers> publisher=new HashSet<Publishers>();

    public void removePublisher(Publishers publisher) {

        this.publisher.remove(publisher);
        publisher.getBooks().remove(publisher);
   }
   public void addPublisher(Publishers publisher) {
        this.publisher.add(publisher);
       publisher.getBooks().add(this);
   }

    public void removeAuthor(Author author) {
        this.authors.remove(author);
        author.getBooks().remove(author);
    }
    public void addAuthor(Author author) {
        this.authors.add(author);
        author.getBooks().add(this);
    }

    public void removeCategory(Category category) {
        this.categories.remove(category);
        category.getBooks().remove(category);
    }
    public void addCategory(Category category) {
        this.categories.add(category);
        category.getBooks().add(this);
    }
    public Book(String isbn, String name, String description) {
        this.isbn = isbn;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Publishers> getPublisher() {
        return publisher;
    }

    public void setPublisher(Set<Publishers> publisher) {
        this.publisher = publisher;
    }

    public Book() {

    }
}