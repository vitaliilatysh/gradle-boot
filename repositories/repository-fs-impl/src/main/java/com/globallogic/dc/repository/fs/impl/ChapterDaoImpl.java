package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.repository.ChapterDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;

import java.util.List;

public class ChapterDaoImpl extends AbstractFileSystemDAO<Chapter> implements ChapterDao {

    private static final String FILE_NAME = "chapters.csv";
    private static volatile ChapterDaoImpl instance = null;

    private ChapterDaoImpl() {
    }

    public static ChapterDaoImpl getInstance() {
        if (instance == null) {
            synchronized (ChapterDaoImpl.class) {
                if (instance == null) {
                    instance = new ChapterDaoImpl();
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
