package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Item;
import com.globallogic.dc.repository.ItemDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;

import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl extends AbstractFileSystemDAO<Item> implements ItemDao {

    private static final String ITEMS = "items.csv";
    private static final String ITEMS_TO_RANGES = "itemsToRanges.csv";
    private static final String ITEMS_TO_STRING_ITEMS = "itemsToStringItems.csv";
    private static final String ITEMS_TO_RELATED_ITEMS = "itemsToRelatedItems.csv";

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
        return ITEMS;
    }

    @Override
    public List<Item> getItemsByRelatedItemId(String id) {
        List<String> ids = new ArrayList<>();
        for (String row : getConnector().readFile(ITEMS_TO_RELATED_ITEMS)) {
            String[] rows = row.split(",");
            if (rows[1].equals(id)) {
                ids.add(rows[0]);
            }
        }

        List<Item> elements = new ArrayList<>();
        for (String row : getConnector().readFile(getFileName())) {
            String[] rows = row.split(",");
            for (String elementId : ids) {
                if (rows[0].equals(elementId)) {
                    Item item = fromDto(row);
                    elements.add(item);
                }
            }
        }
        return elements;
    }

    @Override
    public List<Item> getItemsByStringItemId(String id) {
        List<String> ids = new ArrayList<>();
        for (String row : getConnector().readFile(ITEMS_TO_STRING_ITEMS)) {
            String[] rows = row.split(",");
            if (rows[1].equals(id)) {
                ids.add(rows[0]);
            }
        }

        List<Item> elements = new ArrayList<>();
        for (String row : getConnector().readFile(getFileName())) {
            String[] rows = row.split(",");
            for (String elementId : ids) {
                if (rows[0].equals(elementId)) {
                    Item item = fromDto(row);
                    elements.add(item);
                }
            }
        }
        return elements;
    }

    @Override
    public List<Item> getItemsByRangeId(final String id) {
        final List<String> ids = new ArrayList<>();

        for (final String row : getConnector().readFile(ITEMS_TO_RANGES)) {
            String[] rows = row.split(",");
            if (rows[1].equals(id)) {
                ids.add(rows[0]);
            }
        }

        List<Item> elements = new ArrayList<>();
        for (String row : getConnector().readFile(getFileName())) {
            String[] rows = row.split(",");
            for (String elementId : ids) {
                if (rows[0].equals(elementId)) {
                    Item item = fromDto(row);
                    elements.add(item);
                }
            }
        }
        return elements;
    }
}
