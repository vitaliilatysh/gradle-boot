package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.repository.api.ChapterDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChapterDaoImpl extends AbstractFileSystemDAO<Chapter> implements ChapterDao {

    private static final String CHAPTERS = "chapters.csv";

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
        return CHAPTERS;
    }
}
