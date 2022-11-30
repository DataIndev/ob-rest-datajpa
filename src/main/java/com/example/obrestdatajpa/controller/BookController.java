package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.dto.Mensaje;
import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    //Create new Book
    @PostMapping("/create")
    public void createBook(@RequestBody Book book) {
        bookRepository.save(book);
    }

    //Find All Books
    @GetMapping("/find")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    //Find book from Id
    @GetMapping("/find/{id}")
    public ResponseEntity<Book> findWithId(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Update Book
    @PutMapping("/update/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody Book newBook) {
        Book oldBook = bookRepository.findById(id).get();
        System.out.println(oldBook);
        oldBook.setReleaseDate(newBook.getReleaseDate());
        oldBook.setPages(newBook.getPages());
        oldBook.setAuthor(newBook.getAuthor());
        oldBook.setPrice(newBook.getPrice());
        oldBook.setOnline(newBook.isOnline());
        oldBook.setTitle(newBook.getTitle());
        bookRepository.save(oldBook);

    }

    //Delete Bookº
    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        System.out.println("Libro con el ID: " + id + " fue eliminado");
    }

}
