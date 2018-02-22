package com.globallogic.dc.repository.fs.mockImpl;

import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.repository.ProductsDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ChapterDaoMockImpl")
public class ChapterDaoMockImpl extends AbstractFileSystemDAO<Chapter> implements ProductsDao<Chapter> {

    @Override
    public List<Chapter> getAll() {
        return null;
    }

    @Override
    public Chapter getById(final String id) {
        return null;
    }

    @Override
    protected Chapter fromDto(final String dto) {
        return null;
    }

    @Override
    protected String getFileName() {
        return null;
    }
}
