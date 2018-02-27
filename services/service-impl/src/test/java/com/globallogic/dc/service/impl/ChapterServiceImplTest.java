package com.globallogic.dc.service.impl;

import com.globallogic.dc.service.ChapterService;
import com.globallogic.dc.service.config.ServiceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceConfig.class)
public class ChapterServiceImplTest {

    @Autowired
    private ChapterService chapterService;

    @Test
    public void testGetChapters() {
        assertEquals(3, chapterService.getChapters().size());
    }

    @Test
    public void testGetChapterById() {
        assertEquals("12", chapterService.getChapterById("12").getKey());
    }
}
