package com.globallogic.dc.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SubChapterTest {

    @Test
    public void testHasSubChapter_NotSet() {
        assertFalse(buildSubChapter(false, false, false).hasChapter());
    }

    @Test
    public void testHasSubChapter() {
        assertTrue(buildSubChapter(true, false, false).hasChapter());
    }

    @Test
    public void testHasSections() {
        assertTrue(buildSubChapter(false, true, false).hasSections());
    }

    @Test
    public void testHasSections_Empty() {
        final SubChapter target = buildSubChapter(false, false, false);

        assertFalse(target.hasSections());

        target.addSections(new ArrayList<>());

        assertFalse(target.hasSections());
    }

    @Test
    public void testHasRanges() {
        assertTrue(buildSubChapter(false, false, true).hasRanges());
    }

    @Test
    public void testHasRanges_Empty() {
        final SubChapter target = buildSubChapter(false, false, false);

        assertFalse(target.hasRanges());

        target.addRanges(new ArrayList<>());

        assertFalse(target.hasRanges());
    }

    @Test
    public void addSection() {
        final SubChapter target = buildSubChapter(false, false, false);

        target.addSection(new Section("1", "Title", "Desc"));

        assertEquals(1, target.getSections().size());
    }

    @Test
    public void addSections() {
        final SubChapter target = buildSubChapter(false, false, false);

        target.addSections(Arrays.asList(
                new Section("2", "2", "2"),
                new Section("3", "3", "3")));

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

    @Test
    public void testEquals_NotEqual_Key() {
        final SubChapter target = buildSubChapter("2", "Title", "Desc", false, false, false);
        final SubChapter anotherSubChapter = buildSubChapter("1", "Title", "Desc", false, false, false);

        assertFalse(target.equals(anotherSubChapter));
    }

    @Test
    public void testEquals_NotEqual_Title() {
        final SubChapter target = buildSubChapter("1", "NewTitle", "Desc", false, false, false);
        final SubChapter anotherSubChapter = buildSubChapter("1", "Title", "Desc", false, false, false);

        assertFalse(target.equals(anotherSubChapter));
    }

    @Test
    public void testEquals_NotEqual_Desc() {
        final SubChapter target = buildSubChapter("1", "Title", "NewDesc", false, false, false);
        final SubChapter anotherSubChapter = buildSubChapter("1", "Title", "Desc", false, false, false);

        assertFalse(target.equals(anotherSubChapter));
    }

    @Test
    public void testEquals() {
        final SubChapter target = buildSubChapter(true, true, true);
        final SubChapter anotherSubChapter = buildSubChapter(true, true, true);

        assertTrue(target.equals(anotherSubChapter));
    }

    @Test
    public void testEquals_NotEqualChapterNotSet() {
        final SubChapter target = buildSubChapter(false, true, true);
        final SubChapter anotherSubChapter = buildSubChapter(true, true, true);

        assertFalse(target.equals(anotherSubChapter));
    }

    @Test
    public void testEquals_NotEqual_DiffChapter() {
        final SubChapter target = buildSubChapter(true, true, true);
        final SubChapter anotherSubChapter = buildSubChapter(true, true, true);

        target.setChapter(new Chapter("2", "Title", "Desc"));

        assertFalse(target.equals(anotherSubChapter));
    }

    @Test
    public void testEquals_NotEqual_SectionsListNotSet() {
        final SubChapter target = buildSubChapter(true, false, true);
        final SubChapter anotherSubChapter = buildSubChapter(true, true, true);

        assertFalse(target.equals(anotherSubChapter));
    }

    @Test
    public void testEquals_NotEqual_SectionsListEmpty() {
        final SubChapter target = buildSubChapter(true, true, true);
        final SubChapter anotherSubChapter = buildSubChapter(true, true, true);

        target.setSections(new ArrayList<>());

        assertFalse(target.equals(anotherSubChapter));
    }

    @Test
    public void testEquals_NotEqual_SectionsListContainsDiffNumberOfSections() {
        final SubChapter target = buildSubChapter(true, true, true);
        final SubChapter anotherSubChapter = buildSubChapter(true, true, true);

        target.addSection(new Section("1", "Title", "Desc"));

        assertFalse(target.equals(anotherSubChapter));
    }

    @Test
    public void testEquals_NotEqual_SectionsListContainsSameNumberOfSectionsButDiff() {
        final SubChapter target = buildSubChapter(true, true, true);
        final SubChapter anotherSubChapter = buildSubChapter(true, true, true);

        target.addSection(new Section("1", "Title", "Desc"));
        anotherSubChapter.addSection(new Section("2", "Title", "Desc"));

        assertFalse(target.equals(anotherSubChapter));
    }

    @Test
    public void testEquals_NotEqual_RangesListNotSet() {
        final SubChapter target = buildSubChapter(true, true, false);
        final SubChapter anotherSubChapter = buildSubChapter(true, true, true);

        assertFalse(target.equals(anotherSubChapter));
    }

    @Test
    public void testEquals_NotEqual_RangesListEmpty() {
        final SubChapter target = buildSubChapter(true, true, true);
        final SubChapter anotherSubChapter = buildSubChapter(true, true, true);

        target.setRanges(new ArrayList<>());

        assertFalse(target.equals(anotherSubChapter));
    }

    @Test
    public void testEquals_NotEqual_RangesListContainsDiffNumberOfRanges() {
        final SubChapter target = buildSubChapter(true, true, true);
        final SubChapter anotherSubChapter = buildSubChapter(true, true, true);

        target.addRange(new Range("1", "Title", "Desc"));

        assertFalse(target.equals(anotherSubChapter));
    }

    @Test
    public void testEquals_NotEqual_RangesListContainsSameNumberOfRangesButDiff() {
        final SubChapter target = buildSubChapter(true, true, true);
        final SubChapter anotherSubChapter = buildSubChapter(true, true, true);

        target.addRange(new Range("1", "Title", "Desc"));
        anotherSubChapter.addRange(new Range("2", "Title", "Desc"));

        assertFalse(target.equals(anotherSubChapter));
    }

    @Test
    public void testHashCode() {
        final SubChapter target = buildSubChapter(true, true, true);
        final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();

        hashCodeBuilder
                .append(target.getKey())
                .append(target.getTitle())
                .append(target.getDescription())
                .append(target.getChapter())
                .append(target.getSections())
                .append(target.getRanges());

        assertEquals(target.hashCode(), hashCodeBuilder.toHashCode());
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