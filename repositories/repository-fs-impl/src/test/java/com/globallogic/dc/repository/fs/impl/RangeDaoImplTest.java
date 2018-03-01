package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.connector.FileSystemConnector;
import com.globallogic.dc.model.Range;
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
public class RangeDaoImplTest {

    private List<String> ranges;

    @Mock
    private FileSystemConnector fileSystemConnector;

    @InjectMocks
    private RangeDaoImpl rangeDao;

    @Before
    public void setUp() {
        ranges = new ArrayList<>();
        ranges.add("41,Title,Desc");
        ranges.add("42,Title,Desc");
        ranges.add("43,Title,Desc");
        ranges.add("44,Title,Desc");
        ranges.add("45,Title,Desc");
        ranges.add("46,Title,Desc");
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetRanges() {
        when(fileSystemConnector.readFile("ranges.csv")).thenReturn(ranges);

        List<Range> ranges = rangeDao.getAll();

        assertEquals(6, ranges.size());
    }

    @Test
    public void testGetRangeById() {
        when(fileSystemConnector.readFile("ranges.csv")).thenReturn(ranges);

        Range range = rangeDao.getById("42");

        assertEquals("42", range.getIdentifier());
        assertEquals("Title", range.getTitle());
        assertEquals("Desc", range.getDescription());
    }

    @Test
    public void testGetRangesBySubChapterId() {
        List<String> subChapters = new ArrayList<>();
        subChapters.add("44,24");
        subChapters.add("45,23");
        subChapters.add("45,24");

        when(fileSystemConnector.readFile("ranges.csv")).thenReturn(ranges);
        when(fileSystemConnector.readFile("rangesToSubChapters.csv")).thenReturn(subChapters);

        List<Range> ranges = rangeDao.getRangesBySubChapterId("24");

        assertEquals(2, ranges.size());
    }

    @Test
    public void testGetRangesBySectionId() {
        List<String> rangesToSections = new ArrayList<>();
        rangesToSections.add("41,31");
        rangesToSections.add("41,32");
        rangesToSections.add("42,32");
        rangesToSections.add("42,31");
        rangesToSections.add("43,32");

        when(fileSystemConnector.readFile("ranges.csv")).thenReturn(ranges);
        when(fileSystemConnector.readFile("rangesToSections.csv")).thenReturn(rangesToSections);

        List<Range> ranges = rangeDao.getRangesBySectionId("31");

        assertEquals(2, ranges.size());
    }
}
