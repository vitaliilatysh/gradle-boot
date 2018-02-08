package com.globallogic.dc.dao;

import com.globallogic.dc.model.Chapter;

import java.util.List;

public class ChapterDaoSplitImpl extends AbstractFileSystemDAO<Chapter> implements ProductsDao<Chapter> {

    private static final String FILE_NAME = "chapters.csv";
    private static volatile ChapterDaoSplitImpl instance = null;

    private ChapterDaoSplitImpl() {
    }

    public static ChapterDaoSplitImpl getInstance() {
        if (instance == null) {
            synchronized (ChapterDaoSplitImpl.class) {
                if (instance == null) {
                    instance = new ChapterDaoSplitImpl();
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
        final String[] fields = dto.split(",");

        return new Chapter(fields[0], fields[1], fields[2]);
    }

    @Override
    protected String getFileName() {
        return FILE_NAME;
    }
}
