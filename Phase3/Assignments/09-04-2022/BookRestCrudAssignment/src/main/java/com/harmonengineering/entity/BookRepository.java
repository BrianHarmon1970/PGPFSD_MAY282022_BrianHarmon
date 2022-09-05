package com.harmonengineering.entity;

import com.harmonengineering.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long>
{
    Optional findById(Long id ) ;
    Book save( Book b ) ;
    List<Book> findAll() ;
    void deleteBooksBy() ;


}

