package com.library.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Person {
    @Id
    private Integer personId;

    private String personName;

//    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
//    private List<BookPerson> bookPerson;
}
