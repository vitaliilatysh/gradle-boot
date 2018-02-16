package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.SubChapter;
import com.globallogic.dc.repository.SubChapterDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;

import java.util.List;

public class SubChapterDaoImpl extends AbstractFileSystemDAO<SubChapter> implements SubChapterDao {

    private static final String SUB_CHAPTERS = "subchapters.csv";
    private static final String SUB_CHAPTERS_TO_CHAPTERS = "subChaptersToChapters.csv";

    private static volatile SubChapterDaoImpl instance = null;

    private SubChapterDaoImpl() {
    }

    public static SubChapterDaoImpl getInstance() {
        if (instance == null) {
            synchronized (SubChapterDaoImpl.class) {
                if (instance == null) {
                    instance = new SubChapterDaoImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public SubChapter getById(final String id) {
        return super.getById(id);
    }

    @Override
    public List<SubChapter> getAll() {
        return super.getAll();
    }

    @Override
    protected SubChapter fromDto(final String dto) {
        final String[] fields = dto.split(",");

        return new SubChapter(fields[0], fields[1], fields[2]);

    }

    @Override
    protected String getFileName() {
        return SUB_CHAPTERS;
    }

    @Override
    public List<SubChapter> getSubChaptersByChapterId(String id) {
        return processRelations(id, SUB_CHAPTERS_TO_CHAPTERS);
    }
}
