package com.globallogic.dc.web.api;

import com.globallogic.dc.model.Item;
import com.globallogic.dc.service.api.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @GetMapping(value = "/{id}")
    public Item getItemById(@PathVariable("id") final String id) {
        return itemService.getItemById(id);
    }

    @GetMapping(params = "relatedItem")
    public List<Item> getItemsByRelatedItemId(@RequestParam("relatedItem") final String id) {
        return itemService.getItemsByRelatedItemId(id);
    }

    @GetMapping(params = "stringItem")
    public List<Item> getItemsByStringItemId(@RequestParam("stringItem") final String id) {
        return itemService.getItemsByStringItemId(id);
    }

    @GetMapping(params = "range")
    public List<Item> getItemsByRangeId(@RequestParam("range") final String id) {
        return itemService.getItemsByRangeId(id);
    }
}
