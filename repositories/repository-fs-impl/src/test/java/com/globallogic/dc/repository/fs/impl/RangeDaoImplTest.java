package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Range;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RangeDaoImplTest {

    private RangeDaoImpl rangeDaoImpl = RangeDaoImpl.getInstance();

    @Test
    public void testGetRangesBySubChapterId() {
        List<Range> ranges = rangeDaoImpl.getRangesBySubChapterId("22");

        assertEquals(2, ranges.size());
    }

    @Test
    public void testGetRangesBySectionId() {
        List<Range> ranges = rangeDaoImpl.getRangesBySectionId("31");

        assertEquals(2, ranges.size());
    }
}
