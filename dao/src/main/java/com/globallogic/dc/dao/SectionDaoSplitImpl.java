package com.globallogic.dc.dao;

import com.globallogic.dc.model.Section;

import java.util.List;

public class SectionDaoSplitImpl extends AbstractFileSystemDAO<Section> implements ProductsDao<Section> {

    private static final String FILE_NAME = "sections.csv";
    private static volatile SectionDaoSplitImpl instance = null;

    private SectionDaoSplitImpl() {
    }

    public static SectionDaoSplitImpl getInstance() {
        if (instance == null) {
            synchronized (SectionDaoSplitImpl.class) {
                if (instance == null) {
                    instance = new SectionDaoSplitImpl();
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
        return FILE_NAME;
    }
}
