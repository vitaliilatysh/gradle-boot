package com.globallogic.dc.dao;

import com.globallogic.dc.model.Section;

import java.util.List;
import java.util.StringTokenizer;

public class SectionDaoTokenizerImpl extends AbstractFileSystemDAO<Section> implements ProductsDao<Section> {

    private static final String FILE_NAME = "sections.csv";
    private static volatile SectionDaoTokenizerImpl instance = null;

    private SectionDaoTokenizerImpl() {
    }

    public static SectionDaoTokenizerImpl getInstance() {
        if (instance == null) {
            synchronized (SectionDaoTokenizerImpl.class) {
                if (instance == null) {
                    instance = new SectionDaoTokenizerImpl();
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
        final StringTokenizer stringTokenizer = new StringTokenizer(dto, ",", false);

        return new Section(stringTokenizer.nextToken(), stringTokenizer.nextToken(), stringTokenizer.nextToken());
    }

    @Override
    protected String getFileName() {
        return FILE_NAME;
    }
}
