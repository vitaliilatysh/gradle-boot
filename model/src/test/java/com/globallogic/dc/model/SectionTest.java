package com.globallogic.dc.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SectionTest {

    @Test
    public void testSetSubChapter_IfSectionNotAssignedToSubChapterBefore() {
        final Section target = buildSection(false, false);
        final SubChapter subChapter = new SubChapter("1", "Title", "Desc");

        target.setSubChapter(subChapter);

        assertTrue(target.hasSubChapter());
        assertTrue(target.getSubChapter().equals(subChapter));
        assertTrue(subChapter.getSections().contains(target));
        assertEquals(1, subChapter.getSections().size());
    }

    @Test
    public void testSetSubChapter_IfAnotherSectionAlreadyAssignedToSubChapter() {
        final Section target = buildSection( false, true);
        final Section anotherSection = buildSection( false, false);
        final SubChapter subChapter = new SubChapter("1", "Title", "Desc");

        target.setSubChapter(subChapter);
        anotherSection.setSubChapter(subChapter);

        assertTrue(target.hasSubChapter());
        assertTrue(target.getSubChapter().equals(subChapter));
        assertTrue(subChapter.getSections().contains(target));
        assertTrue(anotherSection.hasSubChapter());
        assertTrue(anotherSection.getSubChapter().equals(subChapter));
        assertTrue(subChapter.getSections().contains(anotherSection));
        assertEquals(2, subChapter.getSections().size());
    }

    @Test
    public void testSetSubChapter_IfSectionWasAssignedAndThenReassignedToAnotherSubChapter() {
        final Section target = buildSection( false, false);
        final SubChapter subChapter = new SubChapter("1", "Title", "Desc");
        final SubChapter anotherSubChapter = new SubChapter("1", "Title", "Desc");

        target.setSubChapter(subChapter);
        target.setSubChapter(anotherSubChapter);

        assertTrue(target.hasSubChapter());
        assertTrue(target.getSubChapter().equals(anotherSubChapter));
        assertTrue(anotherSubChapter.getSections().contains(target));
        assertEquals(1, anotherSubChapter.getSections().size());
    }

    @Test
    public void testSetSubChapter_IfSubChapterContains2SectionsAndThen1SectionReassignedToAnotherSubChapter() {
        final Section target = buildSection( false, true);
        final Section anotherSection = buildSection( false, false);
        final SubChapter subChapter = new SubChapter("1", "Title", "Desc");
        final SubChapter anotherSubChapter = new SubChapter("1", "Title", "Desc");

        target.setSubChapter(subChapter);
        anotherSection.setSubChapter(subChapter);

        assertTrue(target.hasSubChapter());
        assertTrue(target.getSubChapter().equals(subChapter));
        assertTrue(subChapter.getSections().contains(target));
        assertTrue(anotherSection.hasSubChapter());
        assertEquals(2, subChapter.getSections().size());

        target.setSubChapter(anotherSubChapter);

        assertTrue(subChapter.getSections().contains(anotherSection));
        assertTrue(anotherSection.getSubChapter().equals(subChapter));
        assertTrue(anotherSubChapter.getSections().contains(target));
        assertTrue(target.getSubChapter().equals(anotherSubChapter));
        assertEquals(1, subChapter.getSections().size());
        assertEquals(1, anotherSubChapter.getSections().size());

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
    public void testAddRanges() {
        final Section target = buildSection(false, false);

        target.addRange(new Range("1", "Title", "Desc"));

        assertEquals(1, target.getRanges().size());
    }

    @Test
    public void testAddRange() {
        final Section target = buildSection(false, false);

        target.addRanges(Arrays.asList(
                new Range("2", "2", "2"),
                new Range("3", "3", "3")));

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