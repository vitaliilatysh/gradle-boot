package com.globallogic.dc.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SectionTest {

    @Test
    public void testSetSubChapter_NoSubChapterInSection() {
        final Section target = buildSection(false, false);
        final SubChapter subChapter = new SubChapter("1", "Title", "Desc");

        target.setSubChapter(subChapter);

        assertTrue(target.hasSubChapter());
        assertTrue(target.getSubChapter().equals(subChapter));
        assertTrue(subChapter.containsSection(target));
        assertEquals(1, subChapter.getSections().size());
    }

    @Test
    public void testSetSubChapter_MoveSubChapterToAnotherSection() {
        final Section target = buildSection(false, true);
        final Section anotherSection = buildSection(false, false);
        final SubChapter subChapter = new SubChapter("1", "Title", "Desc");

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
        final Section target = buildSection(false, false);

        assertNull(target.getSubChapter());
        assertFalse(target.hasSubChapter());
    }

    @Test
    public void testHasSubChapter() {
        final Section target = buildSection(true, false);

        assertNotNull(target.getSubChapter());
        assertTrue(target.hasSubChapter());
    }

    @Test
    public void testHasRanges_Empty() {
        final Section target = buildSection(false, false);

        assertNull(target.getRanges());
        assertFalse(target.hasRanges());

        target.addRanges(new ArrayList<>());

        assertFalse(target.hasRanges());
    }

    @Test
    public void testHasRanges() {
        final Section target = buildSection(false, true);

        assertNotNull(target.getRanges());
        assertTrue(target.hasRanges());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRange_Null(){
        final Section target = buildSection(false, false);

        target.addRange(null);
    }

    @Test
    public void testAddRange_NoRangeInSection() {
        final Section target = buildSection(false, false);
        final Range range = new Range("1", "Title", "Desc");

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
        final Section target = buildSection(false, false);
        final Section anotherSection = new Section("2", "Title", "Desc");
        final Range range = new Range("1", "Title", "Desc");

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
    public void testAddRanges_Null(){
        final Section target = buildSection(false, false);

        target.addRanges(null);
    }

    @Test
    public void testAddRanges() {
        final Section target = buildSection(false, false);
        final List<Range> ranges = Arrays.asList(
                new Range("2", "2", "2"),
                new Range("3", "3", "3"));

        target.addRanges(ranges);

        for(Range range: ranges){
            assertTrue(target.hasRanges());
            assertTrue(target.containsRange(range));
            assertTrue(range.hasSections());
            assertTrue(range.containsSection(target));
        }
        assertEquals(2, target.getRanges().size());
    }

    private Section buildSection(final boolean fillSubChapter, final boolean fillRanges) {
        return this.buildSection("1", "Title", "Desc", fillSubChapter, fillRanges);
    }

    private Section buildSection(
            final String key,
            final String title,
            final String description,
            final boolean fillSubChapter,
            final boolean fillRanges) {
        final Section result = new Section(key, title, description);

        if (fillRanges) {
            result.addRanges(Arrays.asList(
                    new Range("1", "Title", "Desc"),
                    new Range("2", "Title", "Desc")
            ));
        }

        if (fillSubChapter) {
            result.setSubChapter(new SubChapter("1", "Title", "Desc"));
        }
        return result;
    }
}