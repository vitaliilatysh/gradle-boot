package com.globallogic.dc.repository.fs.impl.mock;

import com.globallogic.dc.model.SubChapter;
import com.globallogic.dc.repository.ProductsDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;

import java.util.List;

public class SubChapterDaoMockImpl extends AbstractFileSystemDAO<SubChapter> implements ProductsDao<SubChapter> {

    @Override
    public List<SubChapter> getAll() {
        return null;
    }

    @Override
    public SubChapter getById(final String id) {
        return null;
    }

    @Override
    protected SubChapter fromDto(final String dto) {
        return null;
    }

    @Override
    protected String getFileName() {
        return null;
    }
}
