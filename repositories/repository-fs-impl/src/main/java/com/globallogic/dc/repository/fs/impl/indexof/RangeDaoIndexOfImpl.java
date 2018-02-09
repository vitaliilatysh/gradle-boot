package com.globallogic.dc.repository.fs.impl.indexof;

import com.globallogic.dc.model.Range;
import com.globallogic.dc.repository.ProductsDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;

import java.util.ArrayList;
import java.util.List;

public class RangeDaoIndexOfImpl extends AbstractFileSystemDAO<Range> implements ProductsDao<Range> {

    private static final String FILE_NAME = "ranges.csv";
    private static volatile RangeDaoIndexOfImpl instance = null;

    private RangeDaoIndexOfImpl() {
    }

    public static RangeDaoIndexOfImpl getInstance() {
        if (instance == null) {
            synchronized (RangeDaoIndexOfImpl.class) {
                if (instance == null) {
                    instance = new RangeDaoIndexOfImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Range> getAll() {
        return super.getAll();
    }

    @Override
    public Range getById(final String id) {
        return super.getById(id);
    }

    @Override
    protected Range fromDto(final String dto) {
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
        return new Range(elements.get(0), elements.get(1), elements.get(2));
    }

    @Override
    protected String getFileName() {
        return FILE_NAME;
    }
}
