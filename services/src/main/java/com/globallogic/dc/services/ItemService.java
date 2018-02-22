package com.globallogic.dc.services;

import com.globallogic.dc.model.Item;

import java.util.List;

public interface ItemService {

    List<Item> getItems();

    Item getItemById(String key);
}
