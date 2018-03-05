package com.globallogic.dc.repository.fs.mockImpl;

import com.globallogic.dc.model.SubChapter;
import com.globallogic.dc.repository.ProductsDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
