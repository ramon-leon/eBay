package com.example.eBayLatest.Repository;

import com.example.eBayLatest.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository <Item, Integer> {

}
