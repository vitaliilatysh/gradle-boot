package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Section;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SectionDaoImplTest {

    private SectionDaoImpl sectionDaoImpl = SectionDaoImpl.getInstance();

    @Test
    public void testGetSectionsBySubChapterId() {
        List<Section> sections = sectionDaoImpl.getSectionsBySubChapterId("22");

        assertEquals(2, sections.size());
    }
}
