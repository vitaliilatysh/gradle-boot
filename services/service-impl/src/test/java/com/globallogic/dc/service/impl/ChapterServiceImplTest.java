package com.globallogic.dc.service.impl;

import com.globallogic.dc.commons.test.ChapterBuilder;
import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.repository.ChapterDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ChapterServiceImplTest {

    @Mock
    private ChapterDao chapterDao;

    @InjectMocks
    private ChapterServiceImpl chapterService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetChapters() {
        List<Chapter> chapters = new ChapterBuilder().buildAllChapters();

        when(chapterDao.getAll()).thenReturn(chapters);

        assertEquals(3, chapterService.getChapters().size());
    }

    @Test
    public void testGetChapterById() {
        when(chapterDao.getById("12")).thenReturn(new Chapter("12", "Title", "Desc"));

        assertEquals("12", chapterService.getChapterById("12").getKey());
    }
}
