package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Item;
import com.globallogic.dc.repository.ItemDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemDaoImpl extends AbstractFileSystemDAO<Item> implements ItemDao {

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

    @Override
    public List<Item> getItemsByRelatedItemId(String id) {
        final String RELATIONS_FILE = "itemsToRelatedItems.csv";

        List<String> ids = new ArrayList<>();
        for (String row : getConnector().readFile(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(RELATIONS_FILE)).getFile()))) {
            String[] rows = row.split(",");
            if (rows[1].equals(id)) {
                ids.add(rows[0]);
            }
        }


        List<Item> elements = new ArrayList<>();
        for (String row : getConnector().readFile(getFile())) {
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
        final String RELATIONS_FILE = "itemsToStringItems.csv";

        List<String> ids = new ArrayList<>();
        for (String row : getConnector().readFile(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(RELATIONS_FILE)).getFile()))) {
            String[] rows = row.split(",");
            if (rows[1].equals(id)) {
                ids.add(rows[0]);
            }
        }


        List<Item> elements = new ArrayList<>();
        for (String row : getConnector().readFile(getFile())) {
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
        final String RELATIONS_FILE = "itemsToRanges.csv";

        List<String> ids = new ArrayList<>();
        for (String row : getConnector().readFile(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(RELATIONS_FILE)).getFile()))) {
            String[] rows = row.split(",");
            if (rows[1].equals(id)) {
                ids.add(rows[0]);
            }
        }


        List<Item> elements = new ArrayList<>();
        for (String row : getConnector().readFile(getFile())) {
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
