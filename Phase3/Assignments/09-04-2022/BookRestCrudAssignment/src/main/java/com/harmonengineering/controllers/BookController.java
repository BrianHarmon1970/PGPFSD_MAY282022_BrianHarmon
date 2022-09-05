package com.harmonengineering.controllers;

import com.harmonengineering.entity.Book;
import com.harmonengineering.entity.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("all")
    public List<Book> getAllBooks()
    {
        List<Book> book=(List<Book>) bookRepository.findAll();
        return book;
    }

    @PostMapping("add")
    public Book addBook(@RequestBody Book book )
    {
        return bookRepository.save(book);
    }

    @GetMapping("book/{id}")
    public Optional<Book> getBookId(@PathVariable Long id)
    {
        return bookRepository.findById(id);
    }
    @GetMapping("bookbyyear/{year}")
    public Optional<Book> getBookByYearPublished(@PathVariable Integer year)
    {
        List<Book> list = bookRepository.findAll() ;
        Book b ; Long id = 0L ;
        Iterator<Book> i = list.iterator() ;
        while ( i.hasNext())
        {
            b = i.next() ;
            if (Objects.equals(b.getPublished(), year))
                id = b.getId() ;
        }
        return bookRepository.findById( id ) ;
    }

    @PutMapping("update/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book)
    {
        book.setId( id ) ;
        return bookRepository.save(book);
    }

    @DeleteMapping("delete/{id}")
    public void deleteBook(@PathVariable Long id)
    {
        bookRepository.deleteById(id);
    }
}

