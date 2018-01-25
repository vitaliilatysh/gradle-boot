package com.globallogic.dc.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SubChapterTest {

    @Test
    public void testSetChapter_IfSubChapterNotAssignedToChapterBefore() {
        final SubChapter target = buildSubChapter(false, false, false);
        final Chapter chapter = new Chapter("1", "Title", "Desc");

        target.setChapter(chapter);

        assertTrue(target.hasChapter());
        assertTrue(target.getChapter().equals(chapter));
        assertTrue(chapter.getSubChapters().contains(target));
        assertEquals(1, chapter.getSubChapters().size());
    }

    @Test
    public void testSetChapter_IfAnotherSubChapterAlreadyAssignedToChapter() {
        final SubChapter target = buildSubChapter(false, false, true);
        final SubChapter anotherSubChapter = buildSubChapter(false, false, false);
        final Chapter chapter = new Chapter("1", "Title", "Desc");

        target.setChapter(chapter);
        anotherSubChapter.setChapter(chapter);

        assertTrue(target.hasChapter());
        assertTrue(target.getChapter().equals(chapter));
        assertTrue(chapter.getSubChapters().contains(target));
        assertTrue(anotherSubChapter.hasChapter());
        assertTrue(anotherSubChapter.getChapter().equals(chapter));
        assertTrue(chapter.getSubChapters().contains(anotherSubChapter));
        assertEquals(2, chapter.getSubChapters().size());
    }

    @Test
    public void testSetChapter_IfSubChapterWasAssignedAndThenReassignedToAnotherChapter() {
        final SubChapter target = buildSubChapter(false, false, false);
        final Chapter chapter = new Chapter("1", "Title", "Desc");
        final Chapter anotherChapter = new Chapter("1", "Title", "Desc");

        target.setChapter(chapter);
        target.setChapter(anotherChapter);

        assertTrue(target.hasChapter());
        assertTrue(target.getChapter().equals(anotherChapter));
        assertTrue(anotherChapter.getSubChapters().contains(target));
        assertEquals(1, anotherChapter.getSubChapters().size());
    }

    @Test
    public void testSetChapter_IfChapterContainsTwoSubChaptersAndThenOneSubChapterReassignedToAnother() {
        final SubChapter target = buildSubChapter(false, false, true);
        final SubChapter anotherSubChapter = buildSubChapter(false, false, false);
        final Chapter chapter = new Chapter("1", "Title", "Desc");
        final Chapter anotherChapter = new Chapter("1", "Title", "Desc");

        target.setChapter(chapter);
        anotherSubChapter.setChapter(chapter);

        assertTrue(target.hasChapter());
        assertTrue(target.getChapter().equals(chapter));
        assertTrue(chapter.getSubChapters().contains(target));
        assertTrue(anotherSubChapter.hasChapter());
        assertEquals(2, chapter.getSubChapters().size());

        target.setChapter(anotherChapter);

        assertTrue(chapter.getSubChapters().contains(anotherSubChapter));
        assertTrue(anotherSubChapter.getChapter().equals(chapter));
        assertTrue(anotherChapter.getSubChapters().contains(target));
        assertTrue(target.getChapter().equals(anotherChapter));
        assertEquals(1, chapter.getSubChapters().size());
        assertEquals(1, anotherChapter.getSubChapters().size());

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
    public void testAddSection_IfSubChapterWithoutSection() {
        final SubChapter target = buildSubChapter(false, false, false);
        final Section section = new Section("1", "Title", "Desc");

        target.addSection(section);

        assertTrue(target.hasSections());
        assertTrue(section.getSubChapter().equals(target));
        assertTrue(target.getSections().contains(section));
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
        assertTrue(target.getSections().contains(section));
        assertTrue(anotherSection.getSubChapter().equals(target));
        assertTrue(target.getSections().contains(anotherSection));
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
        assertTrue(anotherSubChapter.getSections().contains(section));
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
        assertFalse(target.getSections().contains(section));
        assertTrue(anotherSubChapter.hasSections());
        assertTrue(anotherSubChapter.getSections().contains(section));
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
            assertTrue(section.hasSubChapter());
            assertTrue(section.getSubChapter().equals(target));
        }
        assertEquals(2, target.getSections().size());
    }

    @Test
    public void addRange() {
        final SubChapter target = buildSubChapter(false, false, false);

        target.addRange(new Range("1", "Title", "Desc"));

        assertEquals(1, target.getRanges().size());
    }

    @Test
    public void addRanges() {
        final SubChapter target = buildSubChapter(false, false, false);

        target.addRanges(Arrays.asList(
                new Range("2", "2", "2"),
                new Range("3", "3", "3")));

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