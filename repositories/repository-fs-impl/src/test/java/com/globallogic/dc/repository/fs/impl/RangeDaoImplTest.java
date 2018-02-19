package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Range;
import com.globallogic.dc.repository.fs.config.DaoConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RangeDaoImplTest {

    private AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(DaoConfig.class);
    private RangeDaoImpl rangeDaoImpl = container.getBean(RangeDaoImpl.class);

    @Test
    public void testGetRangesBySubChapterId() {
        List<Range> ranges = rangeDaoImpl.getRangesBySubChapterId("24");

        assertEquals(2, ranges.size());
    }

    @Test
    public void testGetRangesBySectionId() {
        List<Range> ranges = rangeDaoImpl.getRangesBySectionId("31");

        assertEquals(2, ranges.size());
    }
}
