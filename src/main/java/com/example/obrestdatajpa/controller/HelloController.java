package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    BookRepository bookRepository;

    //Create new Book
    @PostMapping("/create")
    public void createBook(@RequestBody Book book){
        bookRepository.save(book);
    }

    //Find All Books
    @GetMapping("/find/")
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    //Find book from Id

    @GetMapping("/find/{id}")
    public Optional<Book> findWithId(@PathVariable Long id){
        return bookRepository.findById(id);
    }

    //Update Book
    @PutMapping("/update/{id}")
    public void updateBook(@PathVariable Long id){

    }

    //Delete Book

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id){
        bookRepository.deleteById(id);
        System.out.println("Libro con el ID: "+id+" fue eliminado");
    }




}
