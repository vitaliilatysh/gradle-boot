package com.globallogic.dc.repository.fs.impl.mock;

import com.globallogic.dc.model.Range;
import com.globallogic.dc.repository.ProductsDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;

import java.util.List;

public class RangeDaoMockImpl extends AbstractFileSystemDAO<Range> implements ProductsDao<Range> {

    private static volatile RangeDaoMockImpl instance = null;

    private RangeDaoMockImpl() {
    }

    public static RangeDaoMockImpl getInstance() {
        if (instance == null) {
            synchronized (RangeDaoMockImpl.class) {
                if (instance == null) {
                    instance = new RangeDaoMockImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Range> getAll() {
        return null;
    }

    @Override
    public Range getById(final String id) {
        return null;
    }

    @Override
    protected Range fromDto(final String dto) {
        return null;
    }

    @Override
    protected String getFileName() {
        return null;
    }
}
