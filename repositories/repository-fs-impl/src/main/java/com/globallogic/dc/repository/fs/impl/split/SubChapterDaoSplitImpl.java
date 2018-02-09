package com.globallogic.dc.repository.fs.impl.split;

import com.globallogic.dc.model.SubChapter;
import com.globallogic.dc.repository.ProductsDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;

import java.util.List;

public class SubChapterDaoSplitImpl extends AbstractFileSystemDAO<SubChapter> implements ProductsDao<SubChapter> {

    private static final String FILE_NAME = "subchapters.csv";
    private static volatile SubChapterDaoSplitImpl instance = null;

    private SubChapterDaoSplitImpl() {
    }

    public static SubChapterDaoSplitImpl getInstance() {
        if (instance == null) {
            synchronized (SubChapterDaoSplitImpl.class) {
                if (instance == null) {
                    instance = new SubChapterDaoSplitImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public SubChapter getById(final String id) {
        return super.getById(id);
    }

    @Override
    public List<SubChapter> getAll() {
        return super.getAll();
    }

    @Override
    protected SubChapter fromDto(final String dto) {
        final String[] fields = dto.split(",");

        return new SubChapter(fields[0], fields[1], fields[2]);
    }

    @Override
    protected String getFileName() {
        return FILE_NAME;
    }
}
