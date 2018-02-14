package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Range;
import com.globallogic.dc.repository.RangeDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RangeDaoImpl extends AbstractFileSystemDAO<Range> implements RangeDao {

    private static final String FILE_NAME = "ranges.csv";
    private static volatile RangeDaoImpl instance = null;

    private RangeDaoImpl() {
    }

    public static RangeDaoImpl getInstance() {
        if (instance == null) {
            synchronized (RangeDaoImpl.class) {
                if (instance == null) {
                    instance = new RangeDaoImpl();
                }
            }
        }
        return instance;
    }

    @Override
    protected Range fromDto(final String dto) {
        final String[] fields = dto.split(",");

        return new Range(fields[0], fields[1], fields[2]);
    }

    @Override
    protected String getFileName() {
        return FILE_NAME;
    }

    @Override
    public List<Range> getAll() {
        return super.getAll();
    }

    @Override
    public Range getById(final String rangeKey) {
        return super.getById(rangeKey);
    }

    @Override
    public List<Range> getRangesBySubChapterId(final String id) {
        final String RELATIONS_FILE = "rangesToSubChapters.csv";

        List<String> ids = new ArrayList<>();
        for (String row : getConnector().readFile(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(RELATIONS_FILE)).getFile()))) {
            String[] rows = row.split(",");
            if (rows[1].equals(id)) {
                ids.add(rows[0]);
            }
        }


        List<Range> elements = new ArrayList<>();
        for (String row : getConnector().readFile(getFile())) {
            String[] rows = row.split(",");
            for (String elementId : ids) {
                if (rows[0].equals(elementId)) {
                    Range item = fromDto(row);
                    elements.add(item);
                }
            }
        }
        return elements;
    }

    @Override
    public List<Range> getRangesBySectionId(final String id) {
        final String RELATIONS_FILE = "rangesToSections.csv";

        List<String> ids = new ArrayList<>();
        for (String row : getConnector().readFile(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(RELATIONS_FILE)).getFile()))) {
            String[] rows = row.split(",");
            if (rows[1].equals(id)) {
                ids.add(rows[0]);
            }
        }


        List<Range> elements = new ArrayList<>();
        for (String row : getConnector().readFile(getFile())) {
            String[] rows = row.split(",");
            for (String elementId : ids) {
                if (rows[0].equals(elementId)) {
                    Range item = fromDto(row);
                    elements.add(item);
                }
            }
        }
        return elements;
    }
}
