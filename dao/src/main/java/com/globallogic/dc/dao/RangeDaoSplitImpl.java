package com.globallogic.dc.dao;

import com.globallogic.dc.model.Range;

import java.util.List;

public class RangeDaoSplitImpl extends AbstractFileSystemDAO<Range> implements ProductsDao<Range> {

    private static final String FILE_NAME = "ranges.csv";
    private static volatile RangeDaoSplitImpl instance = null;

    private RangeDaoSplitImpl() {
    }

    public static RangeDaoSplitImpl getInstance() {
        if (instance == null) {
            synchronized (RangeDaoSplitImpl.class) {
                if (instance == null) {
                    instance = new RangeDaoSplitImpl();
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
}
