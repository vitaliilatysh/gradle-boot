package com.globallogic.dc.dao;

import com.globallogic.dc.model.Chapter;

import java.util.List;
import java.util.StringTokenizer;

public class ChapterDaoTokenizerImpl extends AbstractFileSystemDAO<Chapter> implements ProductsDao<Chapter> {

    private static final String FILE_NAME = "chapters.csv";
    private static volatile ChapterDaoTokenizerImpl instance = null;

    private ChapterDaoTokenizerImpl() {
    }

    public static ChapterDaoTokenizerImpl getInstance() {
        if (instance == null) {
            synchronized (ChapterDaoTokenizerImpl.class) {
                if (instance == null) {
                    instance = new ChapterDaoTokenizerImpl();
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
        final StringTokenizer stringTokenizer = new StringTokenizer(dto, ",", false);

        return new Chapter(stringTokenizer.nextToken(), stringTokenizer.nextToken(), stringTokenizer.nextToken());
    }

    @Override
    protected String getFileName() {
        return FILE_NAME;
    }
}