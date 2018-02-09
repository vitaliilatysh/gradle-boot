package com.globallogic.dc.dao;

import com.globallogic.dc.model.SubChapter;

import java.util.ArrayList;
import java.util.List;

public class SubChapterDaoIndexOfImpl extends AbstractFileSystemDAO<SubChapter> implements ProductsDao<SubChapter> {

    private static final String FILE_NAME = "subchapters.csv";
    private static volatile SubChapterDaoIndexOfImpl instance = null;

    private SubChapterDaoIndexOfImpl() {
    }

    public static SubChapterDaoIndexOfImpl getInstance() {
        if (instance == null) {
            synchronized (SubChapterDaoIndexOfImpl.class) {
                if (instance == null) {
                    instance = new SubChapterDaoIndexOfImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<SubChapter> getAll() {
        return super.getAll();
    }

    @Override
    protected SubChapter fromDto(final String dto) {
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
        return new SubChapter(elements.get(0), elements.get(1), elements.get(2));
    }

    @Override
    public SubChapter getById(final String id) {
        return super.getById(id);
    }

    @Override
    protected String getFileName() {
        return FILE_NAME;
    }
}
