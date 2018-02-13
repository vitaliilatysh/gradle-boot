package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Item;
import com.globallogic.dc.model.Range;
import com.globallogic.dc.repository.ItemDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;

import java.util.List;
import java.util.stream.Collectors;

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

        final Item result = new Item(fields[0], fields[1], fields[2]);
        final Range range = new Range();

        range.setKey(fields[3]);
        result.setRange(range);

        return result;
    }

    @Override
    protected String getFileName() {
        return FILE_NAME;
    }

    @Override
    public List<Item> getItemsByRangeId(final String id) {
        return getConnector().readFile(getFile())
                .stream()
                .map(this::fromDto)
                .filter(item -> item.getRange().getKey().equals(id))
                .collect(Collectors.toList());
    }
}
