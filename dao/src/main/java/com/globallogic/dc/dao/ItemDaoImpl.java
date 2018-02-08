package com.globallogic.dc.dao;

import com.globallogic.dc.model.Item;

import java.util.List;

public class ItemDaoImpl implements ItemDao {

    private static volatile ItemDaoImpl instance = null;

    public static ItemDaoImpl getInstance() {
        if (instance == null) {
            synchronized (ItemDaoImpl.class) {
                if (instance == null) {
                    instance = new ItemDaoImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Item> getItems() {
        return null;
    }

    @Override
    public Item getItemById() {
        return null;
    }

    @Override
    public List<Item> getRelatedItems() {
        return null;
    }

    @Override
    public Item getRelatedItemById() {
        return null;
    }
}
