package com.globallogic.dc.services;

import com.globallogic.dc.model.Item;

import java.util.List;

public interface ItemService {

    List<Item> getItems();

    Item getItemById(final String id);

    List<Item> getItemsByRelatedItemId(final String id);

    List<Item> getItemsByStringItemId(final String id);

    List<Item> getItemsByRangeId(final String id);
}
