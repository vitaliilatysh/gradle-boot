package com.globallogic.dc.model;

import com.globallogic.dc.commons.test.RangeBuilder;
import com.globallogic.dc.commons.test.SectionBuilder;
import com.globallogic.dc.commons.test.SubChapterBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SectionTest {

    private final Section target = new SectionBuilder().buildDefault();
    private final SubChapter subChapter = new SubChapterBuilder().buildDefault();
    private final Section anotherSection = new SectionBuilder().buildDefault();
    private final Range range = new RangeBuilder().buildDefault();
    private final Range anotherRange = new RangeBuilder().buildDefault();

    @Test
    public void testSetSubChapter_NoSubChapterInSection() {
        target.setSubChapter(subChapter);

        assertTrue(target.hasSubChapter());
        assertTrue(target.getSubChapter().equals(subChapter));
        assertTrue(subChapter.containsSection(target));
        assertEquals(1, subChapter.getSections().size());
    }

    @Test
    public void testSetSubChapter_MoveSubChapterToAnotherSection() {
        target.setSubChapter(subChapter);
        anotherSection.setSubChapter(subChapter);

        assertTrue(target.hasSubChapter());
        assertTrue(target.getSubChapter().equals(subChapter));
        assertTrue(subChapter.containsSection(target));
        assertTrue(anotherSection.hasSubChapter());
        assertTrue(anotherSection.getSubChapter().equals(subChapter));
        assertTrue(subChapter.containsSection(anotherSection));
        assertEquals(2, subChapter.getSections().size());
    }

    @Test
    public void testHasSubChapter_NotSet() {
        assertNull(target.getSubChapter());
        assertFalse(target.hasSubChapter());
    }

    @Test
    public void testHasSubChapter() {
        target.setSubChapter(subChapter);

        assertNotNull(target.getSubChapter());
        assertTrue(target.hasSubChapter());
    }

    @Test
    public void testHasRanges_Empty() {
        assertNull(target.getRanges());
        assertFalse(target.hasRanges());

        target.addRanges(new ArrayList<>());

        assertFalse(target.hasRanges());
    }

    @Test
    public void testHasRanges() {
        target.addRange(range);

        assertNotNull(target.getRanges());
        assertTrue(target.hasRanges());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRange_IllegalArgumentException() {
        target.addRange(null);
    }

    @Test
    public void testAddRange_NoRangeInSection() {
        target.addRange(range);

        assertTrue(target.hasRanges());
        assertTrue(range.hasSections());
        assertTrue(target.containsRange(range));
        assertTrue(range.containsSection(target));
        assertEquals(1, target.getRanges().size());
        assertEquals(1, range.getSections().size());
    }

    @Test
    public void testAddRange_MoveRangeToAnotherSection() {
        anotherSection.setKey("2");

        target.addRange(range);
        anotherSection.addRange(range);

        assertTrue(target.hasRanges());
        assertTrue(range.hasSections());
        assertTrue(anotherSection.hasRanges());
        assertTrue(target.containsRange(range));
        assertTrue(range.containsSection(target));
        assertTrue(range.containsSection(anotherSection));
        assertTrue(anotherSection.containsRange(range));
        assertEquals(1, target.getRanges().size());
        assertEquals(1, anotherSection.getRanges().size());
        assertEquals(2, range.getSections().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRanges_IllegalArgumentException() {
        target.addRanges(null);
    }

    @Test
    public void testAddRanges() {
        final List<Range> ranges = Arrays.asList(range, anotherRange);

        target.addRanges(ranges);

        assertTrue(target.hasRanges());
        assertTrue(target.containsRange(range));
        assertTrue(target.containsRange(anotherRange));

        assertTrue(range.hasSections());
        assertTrue(anotherRange.hasSections());

        assertTrue(range.containsSection(target));
        assertTrue(anotherRange.containsSection(target));
    }
}