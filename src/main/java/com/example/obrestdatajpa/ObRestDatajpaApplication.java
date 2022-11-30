package com.example.obrestdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestDatajpaApplication {

    public static void main(String[] args) {


        ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);
        BookRepository repository = context.getBean(BookRepository.class);

        //crear libro

        Book book1 = new Book(null, "Pantera Rosa", "Nickelodeon", 450, 29.99, LocalDate.of(2022, 12, 25), true);
        Book book2 = new Book(null, "Pantera Negra", "Fox Century", 310, 13.45, LocalDate.of(2021, 2, 13), true);

        System.out.println("Numero de libros en la base de datos: "+repository.findAll().size());
        //almacenar libro

        repository.save(book1);
        repository.save(book2);

        //recuperar todos los libros

        System.out.println("Numero de libros en la base de datos: "+repository.findAll().size());

        //borrar un libro

        repository.deleteById(1L);

        System.out.println("Numero de libros en la base de datos: "+repository.findAll().size());



    }

}
