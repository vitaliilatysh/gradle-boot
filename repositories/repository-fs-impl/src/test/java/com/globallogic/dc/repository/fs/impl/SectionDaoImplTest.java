package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.connector.FileSystemConnector;
import com.globallogic.dc.model.Section;
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
public class SectionDaoImplTest {

    private List<String> sections;

    @Mock
    private FileSystemConnector fileSystemConnector;

    @InjectMocks
    private SectionDaoImpl sectionDao;

    @Before
    public void setUp() {
        sections = new ArrayList<>();
        sections.add("31,Title,Desc");
        sections.add("32,Title,Desc");
        sections.add("33,Title,Desc");
        sections.add("34,Title,Desc");

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetSections() {
        when(fileSystemConnector.readFile("sections.csv")).thenReturn(sections);

        List<Section> sections = sectionDao.getAll();

        assertEquals(4, sections.size());
    }

    @Test
    public void testGetSectionById() {
        when(fileSystemConnector.readFile("sections.csv")).thenReturn(sections);

        Section section = sectionDao.getById("32");

        assertEquals("32", section.getIdentifier());
        assertEquals("Title", section.getTitle());
        assertEquals("Desc", section.getDescription());
    }

    @Test
    public void testGetSectionsBySubChapterId() {
        List<String> sectionsToSubChapters = new ArrayList<>();
        sectionsToSubChapters.add("31,21");
        sectionsToSubChapters.add("32,22");
        sectionsToSubChapters.add("33,22");

        when(fileSystemConnector.readFile("sections.csv")).thenReturn(sections);
        when(fileSystemConnector.readFile("sectionsToSubChapters.csv")).thenReturn(sectionsToSubChapters);

        List<Section> sections = sectionDao.getSectionsBySubChapterId("22");

        assertEquals(2, sections.size());
    }
}
