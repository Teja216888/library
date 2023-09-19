package com.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "BOOK_PERSON")
public class BookPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer bookId;

    private Integer personId;

    @JsonIgnore
    @JoinColumn(name = "bookId",referencedColumnName = "bookId",insertable = false,updatable = false)
    @OneToOne
    private Book book;

    @JsonIgnore
    @JoinColumn(name = "personId",referencedColumnName = "personId",insertable = false,updatable = false)
    @ManyToOne
    private Person person;
}
