package com.library.repository;

import com.library.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book,Integer> {
    @Query("select b from Book b join BookPerson bp on b.bookId=bp.bookId where bp.personId=?1")
    List<Book> findBooks(Integer id);
}
