package com.globallogic.dc.repository.fs.impl.indexof;

import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.repository.ProductsDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;

import java.util.ArrayList;
import java.util.List;

public class ChapterDaoIndexOfImpl extends AbstractFileSystemDAO<Chapter> implements ProductsDao<Chapter> {

    private static final String FILE_NAME = "chapters.csv";
    private static volatile ChapterDaoIndexOfImpl instance = null;

    private ChapterDaoIndexOfImpl() {
    }

    public static ChapterDaoIndexOfImpl getInstance() {
        if (instance == null) {
            synchronized (ChapterDaoIndexOfImpl.class) {
                if (instance == null) {
                    instance = new ChapterDaoIndexOfImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Chapter> getAll() {
        return super.getAll();
    }

    @Override
    public Chapter getById(final String id) {
        return super.getById(id);
    }

    @Override
    protected Chapter fromDto(final String dto) {
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
        return new Chapter(elements.get(0), elements.get(1), elements.get(2));
    }

    @Override
    protected String getFileName() {
        return FILE_NAME;
    }
}
