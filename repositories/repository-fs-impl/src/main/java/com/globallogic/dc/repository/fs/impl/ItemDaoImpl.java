package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Item;
import com.globallogic.dc.repository.ProductsDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;

import java.util.List;

public class ItemDaoImpl extends AbstractFileSystemDAO<Item> implements ProductsDao<Item> {

    private static final String FILE_NAME = "items.csv";
    private static volatile ItemDaoImpl instance = null;

    private ItemDaoImpl() {
    }

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
    public List<Item> getAll() {
        return super.getAll();
    }

    @Override
    public Item getById(final String id) {
        return super.getById(id);
    }

    protected Item fromDto(final String dto) {
        final String[] fields = dto.split(",");

        return new Item(fields[0], fields[1], fields[2]);
    }

    @Override
    protected String getFileName() {
        return FILE_NAME;
    }
}
