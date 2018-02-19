package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Section;
import com.globallogic.dc.repository.fs.config.DaoConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SectionDaoImplTest {

    private AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(DaoConfig.class);
    private SectionDaoImpl sectionDaoImpl = container.getBean(SectionDaoImpl.class);

    @Test
    public void testGetSectionsBySubChapterId() {
        List<Section> sections = sectionDaoImpl.getSectionsBySubChapterId("22");

        assertEquals(2, sections.size());
    }
}
