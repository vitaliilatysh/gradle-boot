package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Range;
import com.globallogic.dc.repository.RangeDao;
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
public class RangeDaoImplTest {

    @Mock
    private RangeDao rangeDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetRanges() {
        when(rangeDao.getAll()).thenReturn(Arrays.asList(
                new Range("41", "Title", "Desc"),
                new Range("42", "Title", "Desc"),
                new Range("43", "Title", "Desc"),
                new Range("44", "Title", "Desc"),
                new Range("45", "Title", "Desc"),
                new Range("46", "Title", "Desc")));
        List<Range> ranges = rangeDao.getAll();

        assertEquals(6, ranges.size());
    }

    @Test
    public void testGetRangeById() {
        when(rangeDao.getById("42")).thenReturn(
                new Range("42", "Title", "Desc"));
        Range range = rangeDao.getById("42");

        assertEquals("42", range.getIdentifier());
        assertEquals("Title", range.getTitle());
        assertEquals("Desc", range.getDescription());
    }

    @Test
    public void testGetRangesBySubChapterId() {
        when(rangeDao.getRangesBySubChapterId("24")).thenReturn(Arrays.asList(
                new Range("44", "Title", "Desc"),
                new Range("45", "Title", "Desc")));
        List<Range> ranges = rangeDao.getRangesBySubChapterId("24");

        assertEquals(2, ranges.size());
    }

    @Test
    public void testGetRangesBySectionId() {
        when(rangeDao.getRangesBySectionId("31")).thenReturn(Arrays.asList(
                new Range("41", "Title", "Desc"),
                new Range("42", "Title", "Desc")));
        List<Range> ranges = rangeDao.getRangesBySectionId("31");

        assertEquals(2, ranges.size());
    }
}
