package com.globallogic.dc.model;

import com.globallogic.dc.commons.test.RangeBuilder;
import com.globallogic.dc.commons.test.SectionBuilder;
import com.globallogic.dc.commons.test.SubChapterBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SectionTest {

    private Section target;

    @Before
    public void setUp() {
        target = new SectionBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
    }

    @Test
    public void testSetSubChapter_NoSubChapterInSection() {
        final SubChapter subChapter = new SubChapterBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();

        target.setSubChapter(subChapter);

        assertTrue(target.hasSubChapter());
        assertTrue(target.getSubChapter().equals(subChapter));
        assertTrue(subChapter.containsSection(target));
        assertEquals(1, subChapter.getSections().size());
    }

    @Test
    public void testSetSubChapter_MoveSubChapterToAnotherSection() {
        final Section anotherSection = new SectionBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        final SubChapter subChapter = new SubChapterBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();

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
        final SubChapter subChapter = new SubChapterBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        final Section target = new SectionBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .withSubChapter(subChapter)
                .build();

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
        final Range range = new RangeBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        final Section target = new SectionBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .withRanges(Collections.singletonList(range))
                .build();

        assertNotNull(target.getRanges());
        assertTrue(target.hasRanges());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRange_IllegalArgumentException() {
        target.addRange(null);
    }

    @Test
    public void testAddRange_NoRangeInSection() {
        final Range range = new RangeBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();

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
        final Section anotherSection = new SectionBuilder()
                .withKey("2")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        final Range range = new RangeBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();

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
        final Range range1 = new RangeBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        final Range range2 = new RangeBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        final List<Range> ranges = Arrays.asList(range1, range2);

        target.addRanges(ranges);

        assertTrue(target.hasRanges());
        assertTrue(target.containsRange(range1));
        assertTrue(target.containsRange(range2));

        assertTrue(range1.hasSections());
        assertTrue(range2.hasSections());

        assertTrue(range1.containsSection(target));
        assertTrue(range2.containsSection(target));
    }
}