package com.globallogic.dc.services;

import com.globallogic.dc.model.Item;

import java.util.List;

public interface ItemService {

    List<Item> getItems();

    Item getItemById(String id);

    List<Item> getItemsByRelatedItemId(String id);

    List<Item> getItemsByStringItemId(String id);

    List<Item> getItemsByRangeId(String id);
}
