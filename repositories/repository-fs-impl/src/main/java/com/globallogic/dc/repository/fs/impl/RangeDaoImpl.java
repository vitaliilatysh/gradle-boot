package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Range;
import com.globallogic.dc.model.Section;
import com.globallogic.dc.model.SubChapter;
import com.globallogic.dc.repository.RangeDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RangeDaoImpl extends AbstractFileSystemDAO<Range> implements RangeDao {

    private static final String FILE_NAME = "ranges.csv";
    private static volatile RangeDaoImpl instance = null;

    private RangeDaoImpl() {
    }

    public static RangeDaoImpl getInstance() {
        if (instance == null) {
            synchronized (RangeDaoImpl.class) {
                if (instance == null) {
                    instance = new RangeDaoImpl();
                }
            }
        }
        return instance;
    }

    @Override
    protected Range fromDto(final String dto) {
        final String[] fields = dto.split(",");

        final Range result = new Range(fields[0], fields[1], fields[2]);
        final Section section = new Section();
        final SubChapter subChapter = new SubChapter();

        subChapter.setKey(fields[3]);
        section.setKey(fields[4]);

        result.setSubChapters(Collections.singletonList(subChapter));
        result.setSections(Collections.singletonList(section));

        return result;
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

    @Override
    public List<Range> getRangesBySubChapterId(final String id) {
        List<Range> list = new ArrayList<>();
        for (String s : getConnector().readFile(getFile())) {
            Range item = fromDto(s);
            for (SubChapter subChapter : item.getSubChapters()) {
                if (subChapter.getIdentifier().equals(id)) {
                    list.add(item);
                }
            }
        }
        return list;
    }

    @Override
    public List<Range> getRangesBySectionId(final String id) {
        List<Range> list = new ArrayList<>();
        for (String s : getConnector().readFile(getFile())) {
            Range item = fromDto(s);
            for (Section section : item.getSections()) {
                if (section.getIdentifier().equals(id)) {
                    list.add(item);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Range> ranges = RangeDaoImpl.getInstance().getRangesBySectionId("31");
    }
}
