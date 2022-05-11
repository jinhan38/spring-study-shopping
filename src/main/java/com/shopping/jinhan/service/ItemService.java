package com.shopping.jinhan.service;

import com.shopping.jinhan.domain.Item;
import com.shopping.jinhan.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Long createItem(Item item) {
        itemRepository.save(item);
        return item.getId();
    }

    public Item findItem(Long id) {
        return itemRepository.findOne(id);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public String delete(Long id) {
        return itemRepository.delete(id);

    }
}
