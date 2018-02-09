package com.globallogic.dc.repository.fs.impl.tokenizer;

import com.globallogic.dc.model.Range;
import com.globallogic.dc.repository.ProductsDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;

import java.util.List;
import java.util.StringTokenizer;

public class RangeDaoTokenizerImpl extends AbstractFileSystemDAO<Range> implements ProductsDao<Range> {

    private static final String FILE_NAME = "ranges.csv";
    private static volatile RangeDaoTokenizerImpl instance = null;

    private RangeDaoTokenizerImpl() {
    }

    public static RangeDaoTokenizerImpl getInstance() {
        if (instance == null) {
            synchronized (RangeDaoTokenizerImpl.class) {
                if (instance == null) {
                    instance = new RangeDaoTokenizerImpl();
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
        final StringTokenizer stringTokenizer = new StringTokenizer(dto, ",", false);

        return new Range(stringTokenizer.nextToken(), stringTokenizer.nextToken(), stringTokenizer.nextToken());
    }

    @Override
    protected String getFileName() {
        return FILE_NAME;
    }
}
