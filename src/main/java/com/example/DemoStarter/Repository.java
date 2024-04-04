package com.example.DemoStarter;



//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@org.springframework.stereotype.Repository
public class Repository {
    private List<Item> list;

    public void createItem() {
        list = Arrays.asList(
                new Item(1, "Cleaning"),
                new Item(2, "Studying"),
                new Item(3, "Shopping"),
                new Item(4,"Grocery")
        );
    }

    public Repository() {
        createItem();
    }

    public Item findById(int id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (id)) {
                return list.get(i);
            }
        }
        return null;
    }
    public List<Item> getAllItem() {
        return list;
    }

    public List<Item> search(String name) {
        return list.stream().filter(x -> x.getItems().startsWith(name)).collect(Collectors.toList());
    }
    public Item save( Item i) {
        Item item = new Item();
        item.setId(i.getId());
        item.setItems(i.getItems());
        list.add(item);
        System.out.println("item = " + item);
        return item;
    }

    public String delete(Integer id) {
        list.removeIf(x -> x.getId() == (id));
        return null;
    }
    public Item update(Item i1) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (i1.getId())) {
                id = i1.getId();
                idx = i;
                break;
            }
        }
    Item  i2 = new Item();
        i2.setId(id);
        i2.setItems(i1.getItems());
        list.set(idx, i1);
        return i1;

}
}