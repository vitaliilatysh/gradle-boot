package com.globallogic.dc.services;

import com.globallogic.dc.services.impl.ChapterServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ChapterServiceImpl.class})
public class ChapterServiceImplTest {

    @Autowired
    private ChapterServiceImpl chapterServiceImpl;

    @Test
    public void testGetChapters() {
        assertEquals(3, chapterServiceImpl.getChapters().size());
    }
}
