package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.connector.FileSystemConnector;
import com.globallogic.dc.model.SubChapter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SubChapterDaoImplTest {

    private List<String> subChapters;
    @Mock
    private FileSystemConnector fileSystemConnector;

    @InjectMocks
    private SubChapterDaoImpl subChapterDao;

    @Before
    public void setUp() {
        subChapters = new ArrayList<>();
        subChapters.add("21,Title,Desc");
        subChapters.add("22,Title,Desc");
        subChapters.add("23,Title,Desc");
        subChapters.add("24,Title,Desc");
        
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetSubChapters() {
        when(fileSystemConnector.readFile("subchapters.csv")).thenReturn(subChapters);

        List<SubChapter> subChapters = subChapterDao.getAll();

        assertEquals(4, subChapters.size());
    }

    @Test
    public void testGetSubChapterById() {
        when(fileSystemConnector.readFile("subchapters.csv")).thenReturn(subChapters);

        SubChapter subChapter = subChapterDao.getById("22");

        assertEquals("22", subChapter.getIdentifier());
        assertEquals("Title", subChapter.getTitle());
        assertEquals("Desc", subChapter.getDescription());
    }

    @Test
    public void testGetSubChaptersByChapterId() {
        List<String> subChaptersToChapters = new ArrayList<>();
        subChaptersToChapters.add("21,12");
        subChaptersToChapters.add("22,12");
        subChaptersToChapters.add("23,13");
        subChaptersToChapters.add("24,14");

        when(fileSystemConnector.readFile("subchapters.csv")).thenReturn(subChapters);
        when(fileSystemConnector.readFile("subChaptersToChapters.csv")).thenReturn(subChaptersToChapters);

        List<SubChapter> subChapters = subChapterDao.getSubChaptersByChapterId("12");

        assertEquals(2, subChapters.size());
    }
}
