package com.example.DemoStarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Service1 {
    @Autowired
    private Repository repository;

    public Item saveItem(Item i) {
        System.out.println("i = " + i);
        return repository.save(i);
    }

    public List<Item> getItem() {
        return repository.getAllItem();
    }

    public Item getItembyId(int id) {
        return repository.findById(id);
    }

    public String deleteItem(int id) {
        repository.delete(id);
        return "item removed !! " + id;
    }

    public Item updateItem(Item i) {
        return repository.update(i);
    }
}
