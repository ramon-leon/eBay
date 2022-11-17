package com.example.eBayLatest.Controller;

import com.example.eBayLatest.Model.Item;
import com.example.eBayLatest.Repository.ItemRepository;
import com.example.eBayLatest.Service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/ItemsAPI", produces = "application/json")
public class ItemController {
    Logger logger = LoggerFactory.getLogger(ItemController.class);
    @Autowired
    ItemService itemService;

    @GetMapping("/{id}")
    public ResponseEntity<Item> findItemById(@PathVariable int id) {
        Item item;
        item = itemService.getItem(id);
        if (item == null) {
            logger.error("Cannot item. Item id: " + id + " does not exist");
            return new ResponseEntity<>(item, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Item>> findItems() {
        List<Item> result = itemService.getItems();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Item> saveItem(@RequestBody Item request) {

        if (request == null) {
            logger.error("Bad request: empty payload");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Item item = itemService.getItem(request.getSiteId());

        if (item != null) {
            logger.error("Cannot item: " + request.getSiteId() + " already exists");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        itemService.saveItem(request);
        logger.info("Successful ADD");

        return new ResponseEntity<>(request, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable int id) {
        Item item;
        item = itemService.getItem(id);
        if (item == null) {
            logger.error("Cannot item. Item id: " + id + " does not exist");
            return new ResponseEntity<>(item, HttpStatus.BAD_REQUEST);
        }
        itemService.deleteItem(item);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

}
