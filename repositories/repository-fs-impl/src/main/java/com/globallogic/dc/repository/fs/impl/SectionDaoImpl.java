package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Section;
import com.globallogic.dc.repository.ProductsDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;

import java.util.List;

public class SectionDaoImpl extends AbstractFileSystemDAO<Section> implements ProductsDao<Section> {

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

        return new Section(fields[0], fields[1], fields[2]);
    }

    @Override
    protected String getFileName() {
        return FILE_NAME;
    }
}
