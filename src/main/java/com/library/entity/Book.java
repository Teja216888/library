package com.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BOOK")
public class Book {
    @Id
    private Integer bookId;

    private String bookName;

//    @OneToOne(mappedBy = "book",cascade = CascadeType.ALL)
//    private BookPerson bookPerson;
}
