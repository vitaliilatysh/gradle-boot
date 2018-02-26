package com.globallogic.dc.controllers;

import com.globallogic.dc.model.Item;
import com.globallogic.dc.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Item getItemById(@PathVariable("id") final String id) {
        return itemService.getItemById(id);
    }

    @GetMapping(params = "relatedItem", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getItemsByRelatedItemId(@RequestParam("relatedItem") final String id) {
        return itemService.getItemsByRelatedItemId(id);
    }

    @GetMapping(params = "stringItem", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getItemsByStringItemId(@RequestParam("stringItem") final String id) {
        return itemService.getItemsByStringItemId(id);
    }

    @GetMapping(params = "range", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getItemsByRangeId(@RequestParam("range") final String id) {
        return itemService.getItemsByRangeId(id);
    }
}
