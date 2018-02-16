package com.globallogic.dc.repository;

import com.globallogic.dc.model.Item;

import java.util.List;

public interface ItemDao extends ProductsDao<Item> {

    List<Item> getItemsByRelatedItemId(String id);

    List<Item> getItemsByStringItemId(String id);
    List<Item> getItemsByRangeId(String id);
}
