package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Section;
import com.globallogic.dc.repository.SectionDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;

import java.util.ArrayList;
import java.util.List;

public class SectionDaoImpl extends AbstractFileSystemDAO<Section> implements SectionDao {

    private static final String SECTIONS = "sections.csv";
    private static final String SECTIONS_TO_SUB_CHAPTERS = "sectionsToSubChapters.csv";
    private static volatile SectionDaoImpl instance = null;

    private SectionDaoImpl() {
    }

    public static SectionDaoImpl getInstance() {
        if (instance == null) {
            synchronized (SectionDaoImpl.class) {
                if (instance == null) {
                    instance = new SectionDaoImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Section> getAll() {
        return super.getAll();
    }

    @Override
    public Section getById(final String id) {
        return super.getById(id);
    }

    @Override
    protected Section fromDto(final String dto) {
        final String[] fields = dto.split(",");

        return new Section(fields[0], fields[1], fields[2]);

    }

    @Override
    protected String getFileName() {
        return SECTIONS;
    }

    @Override
    public List<Section> getSectionsBySubChapterId(final String id) {
        List<String> ids = new ArrayList<>();
        for (String row : getConnector().readFile(SECTIONS_TO_SUB_CHAPTERS)) {
            String[] rows = row.split(",");
            if (rows[1].equals(id)) {
                ids.add(rows[0]);
            }
        }

        List<Section> elements = new ArrayList<>();
        for (String row : getConnector().readFile(getFileName())) {
            String[] rows = row.split(",");
            for (String elementId : ids) {
                if (rows[0].equals(elementId)) {
                    Section item = fromDto(row);
                    elements.add(item);
                }
            }
        }
        return elements;
    }
}
