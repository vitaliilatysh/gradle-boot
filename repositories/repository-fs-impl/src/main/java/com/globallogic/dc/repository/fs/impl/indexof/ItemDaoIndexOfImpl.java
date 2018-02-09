package com.globallogic.dc.repository.fs.impl.indexof;

import com.globallogic.dc.model.Item;
import com.globallogic.dc.repository.ProductsDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;

import java.util.ArrayList;
import java.util.List;

public class ItemDaoIndexOfImpl extends AbstractFileSystemDAO<Item> implements ProductsDao<Item> {

    private static final String FILE_NAME = "chapters.csv";
    private static volatile ItemDaoIndexOfImpl instance = null;

    private ItemDaoIndexOfImpl() {
    }

    public static ItemDaoIndexOfImpl getInstance() {
        if (instance == null) {
            synchronized (ItemDaoIndexOfImpl.class) {
                if (instance == null) {
                    instance = new ItemDaoIndexOfImpl();
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

    @Override
    protected Item fromDto(final String dto) {
        String row = dto;
        final List<String> elements = new ArrayList<>();
        String element = row.substring(0, row.indexOf(","));
        while (true) {
            elements.add(element);
            row = row.substring(row.indexOf(",") + 1);
            if (row.contains(",")) {
                element = row.substring(0, row.indexOf(","));
            } else {
                element = row.substring(0, row.length());
                elements.add(element);
                break;
            }

        }
        return new Item(elements.get(0), elements.get(1), elements.get(2));
    }

    @Override
    protected String getFileName() {
        return FILE_NAME;
    }
}
