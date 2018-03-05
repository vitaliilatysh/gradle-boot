package com.globallogic.dc.service.impl;

import com.globallogic.dc.service.SubChapterService;
import com.globallogic.dc.service.config.ServiceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceConfig.class)
public class SubChapterServiceImplTest {

    @Autowired
    private SubChapterService subChapterService;

    @Test
    public void testGetSubChapters() {
        assertEquals(4, subChapterService.getSubChapters().size());
    }

    @Test
    public void testGetSubChapterById() {
        assertEquals("21", subChapterService.getSubChapterById("21").getKey());
    }

    @Test
    public void testGetSubChaptersByChapterId() {
        assertEquals(2, subChapterService.getSubChaptersByChapterId("12").size());
    }
}
