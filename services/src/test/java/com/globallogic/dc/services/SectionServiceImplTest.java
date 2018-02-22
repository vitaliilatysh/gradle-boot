package com.globallogic.dc.services;

import com.globallogic.dc.services.config.ServiceConfig;
import com.globallogic.dc.services.impl.SectionServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceConfig.class)
public class SectionServiceImplTest {

    @Autowired
    private SectionServiceImpl sectionServiceImpl;

    @Test
    public void testGetSections() {
        assertEquals(4, sectionServiceImpl.getSections().size());
    }

    @Test
    public void testGetSectionById() {
        assertEquals("31", sectionServiceImpl.getSectionById("31").getKey());
    }

    @Test
    public void getSectionsBySubChapterId() {
        assertEquals(2, sectionServiceImpl.getSectionsBySubChapterId("22").size());
    }
}
