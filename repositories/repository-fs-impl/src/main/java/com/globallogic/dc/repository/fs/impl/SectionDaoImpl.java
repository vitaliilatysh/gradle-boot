package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Section;
import com.globallogic.dc.repository.SectionDao;
import com.globallogic.dc.repository.fs.AbstractFileSystemDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("SectionDaoImpl")
public class SectionDaoImpl extends AbstractFileSystemDAO<Section> implements SectionDao {

    private static final String SECTIONS = "sections.csv";
    private static final String SECTIONS_TO_SUB_CHAPTERS = "sectionsToSubChapters.csv";

    @Override
    public List<Section> getAll() {
        return super.getAll();
    }

    @Override
    public Section getById(final String id) {
        return super.getById(id);
    }

    @Override
    protected Section fromDto(final String dto) {
        final String[] fields = dto.split(",");

        return new Section(fields[0], fields[1], fields[2]);

    }

    @Override
    protected String getFileName() {
        return SECTIONS;
    }

    @Override
    public List<Section> getSectionsBySubChapterId(final String id) {
        return processRelations(id, SECTIONS_TO_SUB_CHAPTERS);
    }
}
