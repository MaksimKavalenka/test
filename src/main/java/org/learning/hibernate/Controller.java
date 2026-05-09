package org.learning.hibernate;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final BookRepository repository;

    @PostMapping
    public void create(@RequestParam("name") String name) {
        Book book = new Book();
        book.setName(name);
        book.setCity("city");
        repository.save(book);
    }

    @PutMapping("/name")
    public void updateName(@RequestParam("new_name") String newName) {
        Book book = repository.findById(1L).get();
        book.setName(newName);
        repository.save(book);
    }

    @PutMapping("/city/{id}")
    public void updateCity(@PathVariable("id") Long id, @RequestParam("new_city") String newCity) {
        Book book = repository.findById(id).get();
        book.setCity(newCity);
        repository.save(book);
    }

}
