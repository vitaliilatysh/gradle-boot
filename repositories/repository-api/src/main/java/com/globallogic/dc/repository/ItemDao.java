package com.globallogic.dc.repository;

import com.globallogic.dc.model.Item;

import java.util.List;

public interface ItemDao extends ProductsDao<Item> {

    Item getItemById();

    List<Item> getRelatedItemById();
}
