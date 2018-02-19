package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Item;
import com.globallogic.dc.repository.ItemDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;

import java.util.List;

public class ItemDaoImpl extends AbstractFileSystemDAO<Item> implements ItemDao {

    private static final String ITEMS = "items.csv";
    private static final String ITEMS_TO_RANGES = "itemsToRanges.csv";
    private static final String ITEMS_TO_STRING_ITEMS = "itemsToStringItems.csv";
    private static final String ITEMS_TO_RELATED_ITEMS = "itemsToRelatedItems.csv";

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
    public List<Item> getItemsByRelatedItemId(final String id) {
        return super.processRelations(id, ITEMS_TO_RELATED_ITEMS);
    }

    @Override
    public List<Item> getItemsByStringItemId(final String id) {
        return processRelations(id, ITEMS_TO_STRING_ITEMS);
    }

    @Override
    public List<Item> getItemsByRangeId(final String id) {
        return processRelations(id, ITEMS_TO_RANGES);
    }
}
