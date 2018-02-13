package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Section;
import com.globallogic.dc.model.SubChapter;
import com.globallogic.dc.repository.SectionDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;

import java.util.List;
import java.util.stream.Collectors;

public class SectionDaoImpl extends AbstractFileSystemDAO<Section> implements SectionDao {

    private static final String FILE_NAME = "sections.csv";
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

        final Section result = new Section(fields[0], fields[1], fields[2]);
        final SubChapter subChapter = new SubChapter();

        subChapter.setKey(fields[3]);
        result.setSubChapter(subChapter);

        return result;

    }

    @Override
    protected String getFileName() {
        return FILE_NAME;
    }

    @Override
    public List<Section> getSectionsBySubChapterId(final String id) {
        return getConnector().readFile(getFile())
                .stream()
                .map(this::fromDto)
                .filter(item -> item.getSubChapter().getKey().equals(id))
                .collect(Collectors.toList());
    }
}
