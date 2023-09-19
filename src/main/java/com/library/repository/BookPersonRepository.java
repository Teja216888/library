package com.library.repository;

import com.library.entity.Book;
import com.library.entity.BookPerson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookPersonRepository extends CrudRepository<BookPerson,Integer> {
    @Query("select count(u.bookId) from BookPerson u where u.personId=?1")
    Integer findByPersonId(Integer personId);

    @Query("delete from BookPerson b where b.personId=?1 and b.bookId=?2")
    void deleteByPersonBook(Integer pid, Integer bid);

}
