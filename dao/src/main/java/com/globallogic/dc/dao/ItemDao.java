package com.globallogic.dc.dao;

import com.globallogic.dc.model.Item;

import java.util.List;

public interface ItemDao {
    List<Item> getItems();

    Item getItemById(final String key);
}
