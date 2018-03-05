package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Range;
import com.globallogic.dc.repository.RangeDao;
import com.globallogic.dc.repository.fs.config.RepositoryConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RepositoryConfig.class)
public class RangeDaoImplTest {

    @Autowired
    private RangeDao rangeDao;

    @Test
    public void testGetRangesBySubChapterId() {
        List<Range> ranges = rangeDao.getRangesBySubChapterId("24");

        assertEquals(2, ranges.size());
    }

    @Test
    public void testGetRangesBySectionId() {
        List<Range> ranges = rangeDao.getRangesBySectionId("31");

        assertEquals(2, ranges.size());
    }
}
