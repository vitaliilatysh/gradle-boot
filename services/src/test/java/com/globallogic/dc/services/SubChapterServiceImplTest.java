package com.globallogic.dc.services;

import com.globallogic.dc.services.config.ServiceConfig;
import com.globallogic.dc.services.impl.SubChapterServiceImpl;
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
    private SubChapterServiceImpl subChapterServiceImpl;

    @Test
    public void testGetSubChapters() {
        assertEquals(4, subChapterServiceImpl.getSubChapters().size());
    }

    @Test
    public void testGetSubChapterById() {
        assertEquals("21", subChapterServiceImpl.getSubChapterById("21").getKey());
    }

    @Test
    public void testGetSubChaptersByChapterId() {
        assertEquals(2, subChapterServiceImpl.getSubChaptersByChapterId("12").size());
    }
}
