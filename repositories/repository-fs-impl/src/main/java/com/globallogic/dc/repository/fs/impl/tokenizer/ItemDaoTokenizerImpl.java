package com.globallogic.dc.repository.fs.impl.tokenizer;

import com.globallogic.dc.model.Item;
import com.globallogic.dc.repository.ProductsDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;

import java.util.List;
import java.util.StringTokenizer;

public class ItemDaoTokenizerImpl extends AbstractFileSystemDAO<Item> implements ProductsDao<Item> {

    private static final String FILE_NAME = "items.csv";
    private static volatile ItemDaoTokenizerImpl instance = null;

    private ItemDaoTokenizerImpl() {
    }

    public static ItemDaoTokenizerImpl getInstance() {
        if (instance == null) {
            synchronized (ItemDaoTokenizerImpl.class) {
                if (instance == null) {
                    instance = new ItemDaoTokenizerImpl();
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
        final StringTokenizer stringTokenizer = new StringTokenizer(dto, ",", false);

        return new Item(stringTokenizer.nextToken(), stringTokenizer.nextToken(), stringTokenizer.nextToken());
    }

    @Override
    protected String getFileName() {
        return FILE_NAME;
    }
}
