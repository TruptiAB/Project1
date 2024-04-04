package com.example.DemoStarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class Controller {

    @Autowired
    private Service1 service;

    @GetMapping("/hello")
    public String home() {
        return "Hello world";
    }

    @PostMapping("/saveItem")
    public Item addItem(@RequestBody Item i) {
        return service.saveItem(i);
    }

    @GetMapping("/getAll")
    public List<Item> findAllItems() {
        return service.getItem();
    }

    @GetMapping("{id}")
    public Item findItembyId(@PathVariable int id) {
        return service.getItembyId(id);
    }

    @PutMapping
    public Item updateProduct(@RequestBody Item product) {
        return service.updateItem(product);
    }

    @DeleteMapping("{id}")
    public String deleteItem(@PathVariable int id) {
        return service.deleteItem(id);
    }

}
