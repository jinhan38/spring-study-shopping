package com.shopping.jinhan.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Book extends Item{


    private String author;

    public Book() {
    }

    public Book(String name, int price, int stockQuantity, String author) {
        super(name, price, stockQuantity);
        this.author = author;
    }

}
