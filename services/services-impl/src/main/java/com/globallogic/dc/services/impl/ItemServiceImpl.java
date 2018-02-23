package com.globallogic.dc.services.impl;

import com.globallogic.dc.model.Item;
import com.globallogic.dc.repository.ItemDao;
import com.globallogic.dc.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ItemServiceImpl")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDaoImpl;

    @Override
    public List<Item> getItems() {
        return itemDaoImpl.getAll();
    }

    @Override
    public Item getItemById(final String id) {
        return itemDaoImpl.getById(id);
    }

    @Override
    public List<Item> getItemsByRelatedItemId(final String id) {
        return itemDaoImpl.getItemsByRelatedItemId(id);
    }

    @Override
    public List<Item> getItemsByStringItemId(final String id) {
        return itemDaoImpl.getItemsByStringItemId(id);
    }

    @Override
    public List<Item> getItemsByRangeId(final String id) {
        return itemDaoImpl.getItemsByRangeId(id);
    }
}
