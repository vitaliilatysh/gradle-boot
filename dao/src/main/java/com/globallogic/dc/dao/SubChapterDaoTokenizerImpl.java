package com.globallogic.dc.dao;

import com.globallogic.dc.model.SubChapter;

import java.util.List;
import java.util.StringTokenizer;

public class SubChapterDaoTokenizerImpl extends AbstractFileSystemDAO<SubChapter> implements ProductsDao<SubChapter> {

    private static final String FILE_NAME = "subchapters.csv";
    private static volatile SubChapterDaoTokenizerImpl instance = null;

    private SubChapterDaoTokenizerImpl() {
    }

    public static SubChapterDaoTokenizerImpl getInstance() {
        if (instance == null) {
            synchronized (SubChapterDaoTokenizerImpl.class) {
                if (instance == null) {
                    instance = new SubChapterDaoTokenizerImpl();
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
    public SubChapter getById(final String id) {
        return super.getById(id);
    }

    @Override
    protected SubChapter fromDto(final String dto) {
        final StringTokenizer stringTokenizer = new StringTokenizer(dto, ",", false);

        return new SubChapter(stringTokenizer.nextToken(), stringTokenizer.nextToken(), stringTokenizer.nextToken());
    }

    @Override
    protected String getFileName() {
        return FILE_NAME;
    }
}
