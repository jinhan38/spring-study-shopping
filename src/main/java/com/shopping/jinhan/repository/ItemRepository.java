package com.shopping.jinhan.repository;

import com.shopping.jinhan.domain.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public Long save(Item item) {
        try {
            if (item.getId() == null) {
                em.persist(item);
            } else {
                em.merge(item);
            }
            return item.getId();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public Item findOne(Long id) {
        Item item = em.find(Item.class, id);
        System.out.println("item = " + item);
        return item;
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }

    @Transactional
    public String delete(Long id) {
        if (findOne(id).getId() != null) {
            Query result = em.createQuery("delete from Book where id = :id");
            System.out.println("result = " + result);
            return "성공";
        } else {
            return "없는 데이터";
        }
    }
}
