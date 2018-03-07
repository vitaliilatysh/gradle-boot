package com.globallogic.dc.service.impl;

import com.globallogic.dc.model.Item;
import com.globallogic.dc.repository.api.ItemDao;
import com.globallogic.dc.service.api.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Override
    public List<Item> getItems() {
        return itemDao.getAll();
    }

    @Override
    public Item getItemById(final String id) {
        return itemDao.getById(id);
    }

    @Override
    public List<Item> getItemsByRelatedItemId(final String id) {
        return itemDao.getItemsByRelatedItemId(id);
    }

    @Override
    public List<Item> getItemsByStringItemId(final String id) {
        return itemDao.getItemsByStringItemId(id);
    }

    @Override
    public List<Item> getItemsByRangeId(final String id) {
        return itemDao.getItemsByRangeId(id);
    }
}
