package com.globallogic.dc.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SubChapterTest {

    @Test
    public void testSetChapter_NoChapterInSubChapter() {
        final SubChapter target = buildSubChapter(false, false, false);
        final Chapter chapter = new Chapter("1", "Title", "Desc");

        target.setChapter(chapter);

        assertTrue(target.hasChapter());
        assertTrue(target.getChapter().equals(chapter));
        assertTrue(chapter.containsSubChapter(target));
        assertEquals(1, chapter.getSubChapters().size());
    }

    @Test
    public void testSetChapter_MoveChapterToAnotherSubChapter() {
        final SubChapter target = buildSubChapter(false, false, true);
        final SubChapter anotherSubChapter = buildSubChapter(false, false, false);
        final Chapter chapter = new Chapter("1", "Title", "Desc");

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
        final SubChapter target = buildSubChapter(false, false, false);

        assertNull(target.getChapter());
        assertFalse(target.hasChapter());
    }

    @Test
    public void testHasChapter() {
        final SubChapter target = buildSubChapter(true, false, false);

        assertNotNull(target.getChapter());
        assertTrue(target.hasChapter());
    }

    @Test
    public void testHasSections_Empty() {
        final SubChapter target = buildSubChapter(false, false, false);

        assertNull(target.getSections());
        assertFalse(target.hasSections());

        target.addSections(new ArrayList<>());

        assertFalse(target.hasSections());
    }

    @Test
    public void testHasSections() {
        final SubChapter target = buildSubChapter(false, true, false);

        assertNotNull(target.getSections());
        assertTrue(target.hasSections());
    }

    @Test
    public void testAddSection_IfSubChapterWithoutSection() {
        final SubChapter target = buildSubChapter(false, false, false);
        final Section section = new Section("1", "Title", "Desc");

        target.addSection(section);

        assertTrue(target.hasSections());
        assertTrue(section.getSubChapter().equals(target));
        assertTrue(target.containsSection(section));
        assertEquals(1, target.getSections().size());
    }

    @Test
    public void testAddSection_IfSubChapterAlreadyHasSection() {
        final SubChapter target = buildSubChapter(false, false, false);
        final Section section = new Section("1", "Title", "Desc");
        final Section anotherSection = new Section("1", "Title", "Desc");

        target.addSection(section);
        target.addSection(anotherSection);

        assertTrue(target.hasSections());
        assertTrue(section.getSubChapter().equals(target));
        assertTrue(target.containsSection(section));
        assertTrue(anotherSection.getSubChapter().equals(target));
        assertTrue(target.containsSection(anotherSection));
        assertEquals(2, target.getSections().size());
    }

    @Test
    public void testAddSection_IfSubChapterContainsSectionAndThisSectionAddedToAnotherSubChapter() {
        final SubChapter target = buildSubChapter(false, false, false);
        final SubChapter anotherSubChapter = buildSubChapter(false, false, false);
        final Section section = new Section("1", "Title", "Desc");

        target.addSection(section);
        anotherSubChapter.addSection(section);

        assertFalse(target.hasSections());
        assertTrue(anotherSubChapter.hasSections());
        assertTrue(anotherSubChapter.containsSection(section));
        assertTrue(section.getSubChapter().equals(anotherSubChapter));
        assertEquals(1, anotherSubChapter.getSections().size());
    }

    @Test
    public void testAddSection_IfSubChapterContains2SectionsAndThenOneSectionAddedToAnotherSubChapter() {
        final SubChapter target = buildSubChapter(false, false, false);
        final SubChapter anotherSubChapter = buildSubChapter(false, false, false);
        final Section section = new Section("1", "Title", "Desc");
        final Section anotherSection = new Section("2", "Title", "Desc");

        target.addSection(section);
        target.addSection(anotherSection);
        anotherSubChapter.addSection(section);

        assertTrue(target.hasSections());
        assertFalse(target.containsSection(section));
        assertTrue(anotherSubChapter.hasSections());
        assertTrue(anotherSubChapter.containsSection(section));
        assertTrue(section.getSubChapter().equals(anotherSubChapter));
        assertEquals(1, target.getSections().size());
        assertEquals(1, anotherSubChapter.getSections().size());
    }

    @Test
    public void testAddSections() {
        final SubChapter target = buildSubChapter(false, false, false);
        final List<Section> sections = Arrays.asList(
                new Section("1", "Title", "Desc"),
                new Section("1", "Title", "Desc"));

        target.addSections(sections);

        for (Section section : sections) {
            assertTrue(target.hasSections());
            assertTrue(target.containsSection(section));
            assertTrue(section.hasSubChapter());
            assertTrue(section.getSubChapter().equals(target));
        }
        assertEquals(2, target.getSections().size());
    }

    @Test
    public void testHasRanges_Empty() {
        final SubChapter target = buildSubChapter(false, false, false);

        assertNull(target.getRanges());
        assertFalse(target.hasRanges());

        target.addRanges(new ArrayList<>());

        assertFalse(target.hasRanges());
    }

    @Test
    public void testHasRanges() {
        final SubChapter target = buildSubChapter(false, false, true);

        assertNotNull(target.getRanges());
        assertTrue(target.hasRanges());
    }

    @Test
    public void testAddRange_IfSubChapterWithoutRange() {
        final SubChapter target = buildSubChapter(false, false, false);
        final Range range = new Range("1", "Title", "Desc");

        target.addRange(range);

        assertTrue(target.hasRanges());
        assertTrue(range.hasSubChapters());
        assertTrue(target.containsRange(range));
        assertTrue(range.containsSubChapter(target));
        assertEquals(1, target.getRanges().size());
        assertEquals(1, range.getSubChapters().size());
    }

    @Test
    public void testAddRange_IfSubChapterAlreadyHasRange() {
        final SubChapter target = buildSubChapter(false, false, false);
        final Range range = new Range("1", "Title", "Desc");
        final Range anotherRange = new Range("1", "Title", "Desc");

        target.addRange(range);
        target.addRange(anotherRange);

        assertTrue(target.hasRanges());
        assertTrue(range.hasSubChapters());
        assertTrue(anotherRange.hasSubChapters());
        assertTrue(range.containsSubChapter(target));
        assertTrue(target.containsRange(range));
        assertTrue(anotherRange.containsSubChapter(target));
        assertTrue(target.containsRange(anotherRange));
        assertEquals(2, target.getRanges().size());
        assertEquals(1, range.getSubChapters().size());
        assertEquals(1, anotherRange.getSubChapters().size());
    }

    @Test
    public void testAddRanges() {
        final SubChapter target = buildSubChapter(false, false, false);
        final List<Range> ranges = Arrays.asList(
                new Range("2", "2", "2"),
                new Range("3", "3", "3"));

        target.addRanges(ranges);

        for (Range range : ranges) {
            assertTrue(target.hasRanges());
            assertTrue(target.containsRange(range));
            assertTrue(range.hasSubChapters());
            assertTrue(range.containsSubChapter(target));
        }

        assertEquals(2, target.getRanges().size());
    }

    private SubChapter buildSubChapter(final boolean fillChapter, final boolean fillSections, final boolean fillRanges) {
        return this.buildSubChapter("1", "Title", "Desc", fillChapter, fillSections, fillRanges);
    }

    private SubChapter buildSubChapter(
            final String key,
            final String title,
            final String description,
            final boolean fillChapter,
            final boolean fillSections,
            final boolean fillRanges) {
        final SubChapter result = new SubChapter(key, title, description);

        if (fillRanges) {
            result.addRanges(Arrays.asList(
                    new Range("1", "Title", "Desc"),
                    new Range("2", "Title", "Desc")
            ));
        }
        if (fillSections) {
            result.addSections(Arrays.asList(
                    new Section("1", "Title", "Desc"),
                    new Section("2", "Title", "Desc")
            ));
        }
        if (fillChapter) {
            result.setChapter(new Chapter("1", "Title", "Desc"));
        }
        return result;
    }
}