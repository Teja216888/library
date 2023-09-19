package com.library.resource;

import com.library.entity.Book;
import com.library.entity.BookPerson;
import com.library.entity.Person;
import com.library.exception.MaxBooksException;
import com.library.repository.BookPersonRepository;
import com.library.repository.BookRepository;
import com.library.repository.PersonRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BookPersonRepository bookPersonRepository;

    @PostMapping("/addperson")
    public String addPerson(@RequestBody Person person){
        personRepository.save(person);
        return "person added successfully";
    }

    @PostMapping("/addbook")
    public String addPerson(@RequestBody Book book){
        bookRepository.save(book);
        return "book added successfully";
    }

    @SneakyThrows
    @PostMapping("/assignbook")
    public String assignbook(@RequestBody BookPerson bookPerson){
        if(checkMaxBooks(bookPerson)==2){
            throw new MaxBooksException("maximum books are alloted to the person");
        }
        else {
            bookPersonRepository.save(bookPerson);
            return "book assigned successfully";
        }
    }

    private Integer checkMaxBooks(BookPerson bookPerson) {
        Integer x=bookPersonRepository.findByPersonId(bookPerson.getPersonId());
        System.out.println(x);
        return x;
    }

    @GetMapping("/getbyid/{id}")
    public List<Book> getAllBooksOfPersons(@PathVariable Integer id){
        //return personRepository.findById(id).get();
        List<Book> personList=new ArrayList<>();
        bookRepository.findBooks(id).forEach(i->personList.add(i));
        return personList;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBookPeron(@PathVariable Integer id){
         //bookPersonRepository.deleteByPersonBook(pid,bid);
         bookPersonRepository.deleteById(id);
         return "deleted successfully";
    }


}
