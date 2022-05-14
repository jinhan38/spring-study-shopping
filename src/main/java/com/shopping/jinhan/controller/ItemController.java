package com.shopping.jinhan.controller;

import com.shopping.jinhan.domain.Book;
import com.shopping.jinhan.domain.Item;
import com.shopping.jinhan.service.ItemService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;


    @GetMapping("/item/create")
    public Item create(@RequestParam String name, @RequestParam int price, @RequestParam int stock, @RequestParam String author) {
        Book book = new Book(name, price, stock, author);
        Long id = itemService.createItem(book);
        if (book.getId().equals(id)) {
            return book;
        } else {
            return new Book();
        }
    }

    @GetMapping("/item/find")
    public Item findOne(@RequestParam Long id) {
        return itemService.findItem(id);
    }

    @GetMapping("item/find/all")
    public List<Item> findAll() {
        return itemService.findAll();
    }


    @DeleteMapping("item/delete")
    public Result delete(@RequestParam Long id) {
        String result = itemService.delete(id);
        return new Result(result);
    }

    @Data
    class Result {
        String result;

        public Result(String result) {
            this.result = result;
        }
    }


    @Data
    @AllArgsConstructor
    class BookDto {
        private String name;
        private int price;
        private int stockQuantity;
        private String author;
    }


}
