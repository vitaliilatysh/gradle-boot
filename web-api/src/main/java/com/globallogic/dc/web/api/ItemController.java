package com.globallogic.dc.web.api;

import com.globallogic.dc.model.Item;
import com.globallogic.dc.service.api.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "/items", description = "Operations about items")
@RestController
@RequestMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemController {

    @Autowired
    private ItemService itemService;

    @ApiOperation(value = "Get all items")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "relatedItem", value = "Related item id", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "stringItem", value = "String item id", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "range", value = "Range id", dataType = "string", paramType = "query")}
    )
    @GetMapping
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @ApiOperation(value = "Get item by id")
    @GetMapping(value = "/{id}")
    public Item getItemById(@PathVariable("id") final String id) {
        return itemService.getItemById(id);
    }

    @ApiOperation(value = "Get items by relatedItem id", hidden = true)
    @GetMapping(params = "relatedItem")
    public List<Item> getItemsByRelatedItemId(@RequestParam("relatedItem") final String id) {
        return itemService.getItemsByRelatedItemId(id);
    }

    @ApiOperation(value = "Get items by stringItem id", hidden = true)
    @GetMapping(params = "stringItem")
    public List<Item> getItemsByStringItemId(@RequestParam("stringItem") final String id) {
        return itemService.getItemsByStringItemId(id);
    }

    @ApiOperation(value = "Get items by range id", hidden = true)
    @GetMapping(params = "range")
    public List<Item> getItemsByRangeId(@RequestParam("range") final String id) {
        return itemService.getItemsByRangeId(id);
    }
}
