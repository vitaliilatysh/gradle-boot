package com.globallogic.dc.model;

import com.globallogic.dc.commons.test.ChapterBuilder;
import com.globallogic.dc.commons.test.RangeBuilder;
import com.globallogic.dc.commons.test.SectionBuilder;
import com.globallogic.dc.commons.test.SubChapterBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SubChapterTest {

    private final SubChapter target = new SubChapterBuilder().buildDefault();
    private final SubChapter anotherSubChapter = new SubChapterBuilder().buildDefault();
    private final Chapter chapter = new ChapterBuilder().buildDefault();
    private final Section section = new SectionBuilder().buildDefault();
    private final Section anotherSection = new SectionBuilder().buildDefault();
    private final Range range = new RangeBuilder().buildDefault();
    private final Range anotherRange = new RangeBuilder().buildDefault();


    @Test
    public void testSetChapter_NoChapterInSubChapter() {
        target.setChapter(chapter);

        assertTrue(target.hasChapter());
        assertTrue(target.getChapter().equals(chapter));
        assertTrue(chapter.containsSubChapter(target));
        assertEquals(1, chapter.getSubChapters().size());
    }

    @Test
    public void testSetChapter_MoveChapterToAnotherSubChapter() {
        target.setChapter(chapter);
        anotherSubChapter.setChapter(chapter);

        assertTrue(target.hasChapter());
        assertTrue(target.getChapter().equals(chapter));
        assertTrue(chapter.containsSubChapter(target));
        assertTrue(anotherSubChapter.hasChapter());
        assertTrue(anotherSubChapter.getChapter().equals(chapter));
        assertTrue(chapter.containsSubChapter(anotherSubChapter));
        assertEquals(2, chapter.getSubChapters().size());
    }

    @Test
    public void testHasChapter_NotSet() {
        assertNull(target.getChapter());
        assertFalse(target.hasChapter());
    }

    @Test
    public void testHasChapter() {
        target.setChapter(chapter);

        assertNotNull(target.getChapter());
        assertTrue(target.hasChapter());
    }

    @Test
    public void testHasSections_Empty() {
        assertNull(target.getSections());
        assertFalse(target.hasSections());

        target.addSections(new ArrayList<>());

        assertFalse(target.hasSections());
    }

    @Test
    public void testHasSections() {
        target.addSection(section);

        assertNotNull(target.getSections());
        assertTrue(target.hasSections());
    }

    @Test
    public void testAddSection_NoSectionInSubChapter() {
        target.addSection(section);

        assertTrue(target.hasSections());
        assertTrue(section.getSubChapter().equals(target));
        assertTrue(target.containsSection(section));
        assertEquals(1, target.getSections().size());
    }

    @Test
    public void testAddSection_MoveSectionToAnotherSubChapter() {
        target.addSection(section);
        anotherSubChapter.addSection(section);

        assertFalse(target.hasSections());
        assertTrue(anotherSubChapter.hasSections());
        assertTrue(anotherSubChapter.containsSection(section));
        assertTrue(section.getSubChapter().equals(anotherSubChapter));
        assertEquals(1, anotherSubChapter.getSections().size());
    }

    @Test
    public void testAddSections() {
        final List<Section> sections = Arrays.asList(section, anotherSection);

        target.addSections(sections);

        assertTrue(target.hasSections());

        assertTrue(target.containsSection(section));
        assertTrue(target.containsSection(anotherSection));

        assertTrue(section.hasSubChapter());
        assertTrue(anotherSection.hasSubChapter());

        assertTrue(section.getSubChapter().equals(target));
        assertTrue(anotherSection.getSubChapter().equals(target));
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

    @Test
    public void testAddRange_NoRangeInSubChapter() {
        target.addRange(range);

        assertTrue(target.hasRanges());
        assertTrue(range.hasSubChapters());
        assertTrue(target.containsRange(range));
        assertTrue(range.containsSubChapter(target));
        assertEquals(1, target.getRanges().size());
        assertEquals(1, range.getSubChapters().size());
    }

    @Test
    public void testAddRange_MoveRangeToAnotherSubChapter() {
        anotherSubChapter.setKey("2");

        target.addRange(range);
        anotherSubChapter.addRange(range);

        assertTrue(target.hasRanges());
        assertTrue(range.hasSubChapters());
        assertTrue(target.containsRange(range));
        assertTrue(range.containsSubChapter(target));
        assertTrue(range.containsSubChapter(anotherSubChapter));
        assertTrue(anotherSubChapter.containsRange(range));
        assertEquals(1, target.getRanges().size());
        assertEquals(1, anotherSubChapter.getRanges().size());
        assertEquals(2, range.getSubChapters().size());
    }

    @Test
    public void testAddRanges() {
        final List<Range> ranges = Arrays.asList(range, anotherRange);

        target.addRanges(ranges);

        assertTrue(target.hasRanges());

        assertTrue(target.containsRange(range));
        assertTrue(target.containsRange(anotherRange));

        assertTrue(range.hasSubChapters());
        assertTrue(anotherRange.hasSubChapters());

        assertTrue(range.containsSubChapter(target));
        assertTrue(anotherRange.containsSubChapter(target));
    }
}