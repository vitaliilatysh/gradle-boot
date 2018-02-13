package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.model.SubChapter;
import com.globallogic.dc.repository.SubChapterDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;

import java.util.List;
import java.util.stream.Collectors;

public class SubChapterDaoImpl extends AbstractFileSystemDAO<SubChapter> implements SubChapterDao {

    private static final String FILE_NAME = "subchapters.csv";
    private static volatile SubChapterDaoImpl instance = null;

    private SubChapterDaoImpl() {
    }

    public static SubChapterDaoImpl getInstance() {
        if (instance == null) {
            synchronized (SubChapterDaoImpl.class) {
                if (instance == null) {
                    instance = new SubChapterDaoImpl();
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

        final SubChapter result = new SubChapter(fields[0], fields[1], fields[2]);
        final Chapter chapter = new Chapter();

        chapter.setKey(fields[3]);
        result.setChapter(chapter);

        return result;
    }

    @Override
    protected String getFileName() {
        return FILE_NAME;
    }

    @Override
    public List<SubChapter> getSubChaptersByChapterId(String id) {
        return getConnector().readFile(getFile())
                .stream()
                .map(this::fromDto)
                .filter(item -> item.getChapter().getKey().equals(id))
                .collect(Collectors.toList());
    }
}
