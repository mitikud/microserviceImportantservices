package com.basicmicroservice.bookservice.controller;

import com.basicmicroservice.bookservice.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope //when ever the configserver file in git changed this will refresh the application with ne data
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    Environment environment;

    @Value("${app.title}")
    private String title;

    //get data from config server
    @GetMapping("/configserver")
    public ResponseEntity<String> getDataFromConfigServer() {
        return new ResponseEntity<String>("Value of title from Config Server: "+title, HttpStatus.OK);
    }

    @GetMapping("/data")
    public String getBookData(){
        return "data of Book service on PORT: " + environment.getRequiredProperty("local.server.port");
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return new Book(id, "Head First Java", 500.75);
    }

    @GetMapping("/all")
    public List<Book> getAll(){
        return List.of(
                new Book(501, "Head First Java", 439.75),
                new Book(502, "Spring in Action", 340.75),
                new Book(503, "Hibernate in Action", 355.75)
        );
    }

    @GetMapping("/entity")
    public ResponseEntity<String> getEntityData() {
        return new ResponseEntity<String>(
                "Hello from BookRestController",
                HttpStatus.OK);
    }
}
