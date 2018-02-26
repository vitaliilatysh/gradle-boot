package com.globallogic.dc.repository.fs.mockImpl;

import com.globallogic.dc.model.Range;
import com.globallogic.dc.repository.ProductsDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RangeDaoMockImpl extends AbstractFileSystemDAO<Range> implements ProductsDao<Range> {

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
