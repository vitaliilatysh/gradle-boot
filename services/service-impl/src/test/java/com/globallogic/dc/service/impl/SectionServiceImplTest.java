package com.globallogic.dc.service.impl;

import com.globallogic.dc.service.SectionService;
import com.globallogic.dc.service.config.ServiceConfig;
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
    private SectionService sectionService;

    @Test
    public void testGetSections() {
        assertEquals(4, sectionService.getSections().size());
    }

    @Test
    public void testGetSectionById() {
        assertEquals("31", sectionService.getSectionById("31").getKey());
    }

    @Test
    public void getSectionsBySubChapterId() {
        assertEquals(2, sectionService.getSectionsBySubChapterId("22").size());
    }
}
