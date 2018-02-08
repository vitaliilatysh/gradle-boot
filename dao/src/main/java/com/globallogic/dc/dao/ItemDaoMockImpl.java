package com.globallogic.dc.dao;

import com.globallogic.dc.model.Item;

import java.util.List;

public class ItemDaoMockImpl implements ItemDao {

    private static volatile ItemDaoMockImpl instance = null;

    public static ItemDaoMockImpl getInstance() {
        if (instance == null) {
            synchronized (ItemDaoMockImpl.class) {
                if (instance == null) {
                    instance = new ItemDaoMockImpl();
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
