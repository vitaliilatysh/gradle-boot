package com.globallogic.dc.service.impl;

import com.globallogic.dc.commons.test.SubChapterBuilder;
import com.globallogic.dc.model.SubChapter;
import com.globallogic.dc.repository.api.SubChapterDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SubChapterServiceImplTest {

    @Mock
    private SubChapterDao subChapterDao;

    @InjectMocks
    private SubChapterServiceImpl subChapterService;

    @Test
    public void testGetSubChapters() {
        when(subChapterDao.getAll()).thenReturn(new SubChapterBuilder().buildAllSubChapters());

        assertEquals(4, subChapterService.getSubChapters().size());
    }

    @Test
    public void testGetSubChapterById() {
        when(subChapterDao.getById("21")).thenReturn(new SubChapter("21", "Title", "Desc"));

        assertEquals("21", subChapterService.getSubChapterById("21").getKey());
    }

    @Test
    public void testGetSubChaptersByChapterId() {
        when(subChapterDao.getSubChaptersByChapterId("12")).thenReturn(Arrays.asList(
                new SubChapter("21", "Title", "Desc"),
                new SubChapter("22", "Title", "Desc")));

        assertEquals(2, subChapterService.getSubChaptersByChapterId("12").size());
    }
}
