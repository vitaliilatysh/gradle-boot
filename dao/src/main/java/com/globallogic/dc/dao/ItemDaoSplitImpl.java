package com.globallogic.dc.dao;

import com.globallogic.dc.model.Item;

import java.util.List;

public class ItemDaoSplitImpl extends AbstractFileSystemDAO<Item> implements ProductsDao<Item> {

    private static final String FILE_NAME = "items.csv";
    private static volatile ItemDaoSplitImpl instance = null;

    private ItemDaoSplitImpl() {
    }

    public static ItemDaoSplitImpl getInstance() {
        if (instance == null) {
            synchronized (ItemDaoSplitImpl.class) {
                if (instance == null) {
                    instance = new ItemDaoSplitImpl();
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
