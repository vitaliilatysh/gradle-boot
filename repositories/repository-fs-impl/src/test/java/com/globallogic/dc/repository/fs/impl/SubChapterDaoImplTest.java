package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.SubChapter;
import com.globallogic.dc.repository.SubChapterDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SubChapterDaoImplTest {

    @Mock
    private SubChapterDao subChapterDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetSubChapters() {
        when(subChapterDao.getAll()).thenReturn(Arrays.asList(
                new SubChapter("21", "Title", "Desc"),
                new SubChapter("22", "Title", "Desc"),
                new SubChapter("23", "Title", "Desc"),
                new SubChapter("24", "Title", "Desc")));

        List<SubChapter> subChapters = subChapterDao.getAll();

        assertEquals(4, subChapters.size());
    }

    @Test
    public void testGetSubChapterById() {
        when(subChapterDao.getById("22")).thenReturn(
                new SubChapter("22", "Title", "Desc"));
        SubChapter subChapter = subChapterDao.getById("22");

        assertEquals("22", subChapter.getIdentifier());
        assertEquals("Title", subChapter.getTitle());
        assertEquals("Desc", subChapter.getDescription());
    }

    @Test
    public void testGetSubChaptersByChapterId() {
        List<SubChapter> subChapters = subChapterDao.getSubChaptersByChapterId("12");

        assertEquals(2, subChapters.size());
    }
}
