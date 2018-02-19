package com.globallogic.dc.repository.fs.impl.mock;

import com.globallogic.dc.model.Range;
import com.globallogic.dc.repository.ProductsDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
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
