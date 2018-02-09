package com.globallogic.dc.dao;

import com.globallogic.dc.model.Section;

import java.util.ArrayList;
import java.util.List;

public class SectionDaoIndexOfImpl extends AbstractFileSystemDAO<Section> implements ProductsDao<Section> {

    private static final String FILE_NAME = "sections.csv";
    private static volatile SectionDaoIndexOfImpl instance = null;

    private SectionDaoIndexOfImpl() {
    }

    public static SectionDaoIndexOfImpl getInstance() {
        if (instance == null) {
            synchronized (SectionDaoIndexOfImpl.class) {
                if (instance == null) {
                    instance = new SectionDaoIndexOfImpl();
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
        String row = dto;
        final List<String> elements = new ArrayList<>();
        String element = row.substring(0, row.indexOf(","));
        while (true) {
            elements.add(element);
            row = row.substring(row.indexOf(",") + 1);
            if (row.contains(",")) {
                element = row.substring(0, row.indexOf(","));
            } else {
                element = row.substring(0, row.length());
                elements.add(element);
                break;
            }

        }
        return new Section(elements.get(0), elements.get(1), elements.get(2));
    }

    @Override
    protected String getFileName() {
        return FILE_NAME;
    }
}
