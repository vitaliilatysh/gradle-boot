package com.globallogic.dc.controllers;

import com.globallogic.dc.model.Item;
import com.globallogic.dc.services.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    @Qualifier("ItemServiceImpl")
    private ItemServiceImpl itemServiceImpl;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getItems() {
        return itemServiceImpl.getItems();
    }

    @GetMapping(value = "/item", produces = MediaType.APPLICATION_JSON_VALUE)
    public Item getItemById(@RequestParam("id") final String id) {
        return itemServiceImpl.getItemById(id);
    }

    @GetMapping(value = "/relatedItem", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getItemsByRelatedItemId(@RequestParam("id") final String id) {
        return itemServiceImpl.getItemsByRelatedItemId(id);
    }

    @GetMapping(value = "/stringItem", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getItemsByStringItemId(@RequestParam("id") final String id) {
        return itemServiceImpl.getItemsByStringItemId(id);
    }

    @GetMapping(value = "/range", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getItemsByRangeId(@RequestParam("id") final String id) {
        return itemServiceImpl.getItemsByRangeId(id);
    }
}
