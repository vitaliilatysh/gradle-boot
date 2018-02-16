package com.globallogic.dc.repository.fs.impl.mock;

import com.globallogic.dc.model.Item;
import com.globallogic.dc.repository.ProductsDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;

import java.util.List;

public class ItemDaoMockImpl extends AbstractFileSystemDAO<Item> implements ProductsDao<Item> {

    private static volatile ItemDaoMockImpl instance = null;

    private ItemDaoMockImpl() {
    }

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
    public List<Item> getAll() {
        return null;
    }

    @Override
    public Item getById(final String id) {
        return null;
    }

    @Override
    protected Item fromDto(final String dto) {
        return null;
    }

    @Override
    protected String getFileName() {
        return null;
    }
}
