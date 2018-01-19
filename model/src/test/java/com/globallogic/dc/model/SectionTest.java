package com.globallogic.dc.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SectionTest {

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

    @Test
    public void testEquals() {
        final Section target = buildSection(true, true);
        final Section anotherSection = buildSection(true, true);

        assertTrue(target.equals(anotherSection));
    }

    @Test
    public void testEquals_NotEqual_Key() {
        final Section target = buildSection("2", "Title", "Desc", true, true);
        final Section anotherSection = buildSection("1", "Title", "Desc", true, true);

        assertFalse(target.equals(anotherSection));
    }

    @Test
    public void testEquals_NotEqual_Title() {
        final Section target = buildSection("1", "NewTitle", "Desc", true, true);
        final Section anotherSection = buildSection("1", "Title", "Desc", true, true);

        assertFalse(target.equals(anotherSection));
    }

    @Test
    public void testEquals_NotEqual_Desc() {
        final Section target = buildSection("1", "Title", "NewDesc", true, true);
        final Section anotherSection = buildSection("1", "Title", "Desc", true, true);

        assertFalse(target.equals(anotherSection));
    }

    @Test
    public void testEquals_NotEqual_SubChapterNotSet() {
        final Section target = buildSection(false, true);
        final Section anotherSection = buildSection(true, true);

        assertFalse(target.equals(anotherSection));
    }

    @Test
    public void testEquals_NotEqual_DiffSubChapter() {
        final Section target = buildSection(true, true);
        final Section anotherSection = buildSection(true, true);

        target.setSubChapter(new SubChapter("2", "Title", "Desc"));

        assertFalse(target.equals(anotherSection));
    }

    @Test
    public void testEquals_NotEqual_RangesListNotSet() {
        final Section target = buildSection(true, false);
        final Section anotherSection = buildSection(true, true);

        assertFalse(target.equals(anotherSection));
    }

    @Test
    public void testEquals_NotEqual_RangesListEmpty() {
        final Section target = buildSection(true, true);
        final Section anotherSection = buildSection(true, true);

        target.setRanges(new ArrayList<>());

        assertFalse(target.equals(anotherSection));
    }

    @Test
    public void testEquals_NotEqual_RangesListContainsDiffNumberOfRanges() {
        final Section target = buildSection(true, true);
        final Section anotherSection = buildSection(true, true);

        target.addRange(new Range("1", "Title", "Desc"));

        assertFalse(target.equals(anotherSection));
    }

    @Test
    public void testEquals_NotEqual_RangesListContainsSameNumberOfRangesButDiff() {
        final Section target = buildSection(true, true);
        final Section anotherSection = buildSection(true, true);

        target.addRange(new Range("1", "Title", "Desc"));
        anotherSection.addRange(new Range("2", "Title", "Desc"));

        assertFalse(target.equals(anotherSection));
    }

    @Test
    public void testHashCode() {
        final Section target = buildSection(true, true);
        final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();

        hashCodeBuilder
                .append(target.getKey())
                .append(target.getTitle())
                .append(target.getDescription())
                .append(target.getSubChapter())
                .append(target.getRanges());

        assertEquals(target.hashCode(), hashCodeBuilder.toHashCode());
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