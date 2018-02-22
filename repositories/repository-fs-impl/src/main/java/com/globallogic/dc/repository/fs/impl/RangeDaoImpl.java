package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Range;
import com.globallogic.dc.repository.RangeDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("RangeDaoImpl")
public class RangeDaoImpl extends AbstractFileSystemDAO<Range> implements RangeDao {

    private static final String RANGES = "ranges.csv";
    private static final String RANGES_TO_SUB_CHAPTERS = "rangesToSubChapters.csv";
    private static final String RANGES_TO_SECTIONS = "rangesToSections.csv";

    @Override
    protected Range fromDto(final String dto) {
        final String[] fields = dto.split(",");

        return new Range(fields[0], fields[1], fields[2]);
    }

    @Override
    protected String getFileName() {
        return RANGES;
    }

    @Override
    public List<Range> getAll() {
        return super.getAll();
    }

    @Override
    public Range getById(final String rangeKey) {
        return super.getById(rangeKey);
    }

    @Override
    public List<Range> getRangesBySubChapterId(final String id) {
        return processRelations(id, RANGES_TO_SUB_CHAPTERS);
    }

    @Override
    public List<Range> getRangesBySectionId(final String id) {
        return processRelations(id, RANGES_TO_SECTIONS);
    }
}
