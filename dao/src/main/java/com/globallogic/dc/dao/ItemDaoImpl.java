package com.globallogic.dc.dao;

import com.globallogic.dc.connector.FileSystemConnectorImpl;
import com.globallogic.dc.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {

    private static volatile ItemDaoImpl instance = null;
    private String fileName = "D:\\projects\\java-trainee-latysh\\connector\\src\\main\\resources\\items.csv";
    private Item item = new Item();
    private List<Item> items = new ArrayList<>();

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
        final List<String> rows = new FileSystemConnectorImpl().readFile(fileName);
        for (String row : rows) {
            final String[] itemElements = row.split(",");
            final String key = itemElements[0];
            final String title = itemElements[1];
            final String description = itemElements[2];
            items.add(new Item(key, title, description));
        }
        return items;
    }

    @Override
    public Item getItemById(final String itemKey) {
        final List<String> rows = new FileSystemConnectorImpl().readFile(fileName);
        for (String row : rows) {
            final String[] itemElements = row.split(",");

            if (itemElements[0].equals(itemKey)) {
                final String key = itemElements[0];
                final String title = itemElements[1];
                final String description = itemElements[2];
                item = new Item(key, title, description);
            }
            if (item.getIdentifier() != null && item.getIdentifier().equals(itemKey)) {
                break;
            }
        }
        return item;
    }
}
