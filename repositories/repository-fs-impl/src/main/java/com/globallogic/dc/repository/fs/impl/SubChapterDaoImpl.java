package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.SubChapter;
import com.globallogic.dc.repository.SubChapterDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SubChapterDaoImpl extends AbstractFileSystemDAO<SubChapter> implements SubChapterDao {

    private static final String FILE_NAME = "subchapters.csv";
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
        return FILE_NAME;
    }

    @Override
    public List<SubChapter> getSubChaptersByChapterId(String id) {
        final String RELATIONS_FILE = "subChaptersToChapters.csv";

        List<String> ids = new ArrayList<>();
        for (String row : getConnector().readFile(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(RELATIONS_FILE)).getFile()))) {
            String[] rows = row.split(",");
            if (rows[1].equals(id)) {
                ids.add(rows[0]);
            }
        }


        List<SubChapter> elements = new ArrayList<>();
        for (String row : getConnector().readFile(getFile())) {
            String[] rows = row.split(",");
            for (String elementId : ids) {
                if (rows[0].equals(elementId)) {
                    SubChapter item = fromDto(row);
                    elements.add(item);
                }
            }
        }
        return elements;
    }
}
