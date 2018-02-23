package com.globallogic.dc.services.impl;

import com.globallogic.dc.services.ChapterService;
import com.globallogic.dc.services.config.ServiceConfig;
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
    private ChapterService chapterServiceImpl;

    @Test
    public void testGetChapters() {
        assertEquals(3, chapterServiceImpl.getChapters().size());
    }

    @Test
    public void testGetChapterById() {
        assertEquals("12", chapterServiceImpl.getChapterById("12").getKey());
    }
}
