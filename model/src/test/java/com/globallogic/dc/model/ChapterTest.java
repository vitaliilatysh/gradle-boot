package com.globallogic.dc.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ChapterTest {

    @Test
    public void testHasSubChapters_Empty() {
        final Chapter target = buildChapter(false);

        assertNotNull(target.getSubChapters());
        assertFalse(target.hasSubChapters());

        target.addSubChapters(new ArrayList<>());

        assertFalse(target.hasSubChapters());
    }

    @Test
    public void testHasSubChapters() {
        final Chapter target = buildChapter(true);

        assertNotNull(target.getSubChapters());
        assertTrue(target.hasSubChapters());
    }

    @Test
    public void testAddSubChapter_IfChapterWithoutSubChapter() {
        final Chapter target = buildChapter(false);
        final SubChapter subChapter = new SubChapter("1", "Title", "Desc");

        target.addSubChapter(subChapter);

        assertTrue(target.hasSubChapters());
        assertTrue(subChapter.getChapter().equals(target));
        assertTrue(target.getSubChapters().contains(subChapter));
        assertEquals(1, target.getSubChapters().size());
    }

    @Test
    public void testAddSubChapter_IfChapterAlreadyHasSubChapter() {
        final Chapter target = buildChapter(false);
        final SubChapter subChapter = new SubChapter("1", "Title", "Desc");
        final SubChapter anotherSubChapter = new SubChapter("1", "Title", "Desc");

        target.addSubChapter(subChapter);
        target.addSubChapter(anotherSubChapter);

        assertTrue(target.hasSubChapters());
        assertTrue(subChapter.getChapter().equals(target));
        assertTrue(target.getSubChapters().contains(subChapter));
        assertTrue(anotherSubChapter.getChapter().equals(target));
        assertTrue(target.getSubChapters().contains(anotherSubChapter));
        assertEquals(2, target.getSubChapters().size());
    }

    @Test
    public void testAddSubChapter_IfChapterContainsSubChapterAndThisSubChapterAddedToAnotherChapter() {
        final Chapter target = buildChapter(false);
        final Chapter anotherChapter = buildChapter(false);
        final SubChapter subChapter = new SubChapter("1", "Title", "Desc");

        target.addSubChapter(subChapter);
        anotherChapter.addSubChapter(subChapter);

        assertFalse(target.hasSubChapters());
        assertTrue(anotherChapter.hasSubChapters());
        assertTrue(anotherChapter.getSubChapters().contains(subChapter));
        assertTrue(subChapter.getChapter().equals(anotherChapter));
        assertEquals(1, anotherChapter.getSubChapters().size());
    }

    @Test
    public void testAddSubChapter_IfChapterContains2SubChaptersAndThenOneSubChapterAddedToAnotherChapter(){
        final Chapter target = buildChapter(false);
        final Chapter anotherChapter = buildChapter(false);
        final SubChapter subChapter = new SubChapter("1", "Title", "Desc");
        final SubChapter anotherSubChapter = new SubChapter("2", "Title", "Desc");

        target.addSubChapter(subChapter);
        target.addSubChapter(anotherSubChapter);
        anotherChapter.addSubChapter(subChapter);

        assertTrue(target.hasSubChapters());
        assertFalse(target.getSubChapters().contains(subChapter));
        assertFalse(subChapter.getChapter().equals(target));
        assertTrue(anotherSubChapter.getChapter().equals(target));
        assertTrue(target.getSubChapters().contains(anotherSubChapter));
        assertTrue(anotherChapter.hasSubChapters());
        assertTrue(anotherChapter.getSubChapters().contains(subChapter));
        assertTrue(subChapter.getChapter().equals(anotherChapter));
        assertEquals(1, target.getSubChapters().size());
        assertEquals(1, anotherChapter.getSubChapters().size());
    }

    @Test
    public void testAddSubChapters() {
        final Chapter target = buildChapter(false);
        final List<SubChapter> subChapters = Arrays.asList(
                new SubChapter("1", "Title", "Desc"),
                new SubChapter("1", "Title", "Desc"));

        target.addSubChapters(subChapters);

        for (SubChapter subChapter : subChapters) {
            assertTrue(subChapter.hasChapter());
            assertTrue(subChapter.getChapter().equals(target));
        }
        assertEquals(2, target.getSubChapters().size());
    }

    @Test
    public void testEquals() {
        final Chapter target = buildChapter(true);
        final Chapter anotherChapter = buildChapter(true);

        assertTrue(target.equals(anotherChapter));
    }

    @Test
    public void testEquals_DifferentKeys() {
        final Chapter target = buildChapter("2", "Title", "Desc", true);
        final Chapter anotherChapter = buildChapter("1", "Title", "Desc", true);

        assertFalse(target.equals(anotherChapter));
    }

    @Test
    public void testEquals_DifferentTitles() {
        final Chapter target = buildChapter("1", "NewTitle", "Desc", true);
        final Chapter anotherChapter = buildChapter("1", "Title", "Desc", true);

        assertFalse(target.equals(anotherChapter));
    }

    @Test
    public void testEquals_DifferentDesc() {
        final Chapter target = buildChapter("1", "Title", "NewDesc", true);
        final Chapter anotherChapter = buildChapter("1", "Title", "Desc", true);

        assertFalse(target.equals(anotherChapter));
    }

    @Test
    public void testEquals_TargetSubChaptersListNotSet() {
        final Chapter target = buildChapter(false);
        final Chapter anotherChapter = buildChapter(true);

        assertFalse(target.equals(anotherChapter));
    }

    @Test
    public void testEquals_TargetSubChaptersListEmpty() {
        final Chapter target = buildChapter(true);
        final Chapter anotherChapter = buildChapter(true);

        target.setSubChapters(new ArrayList<>());

        assertFalse(target.equals(anotherChapter));
    }

    @Test
    public void testEquals_TargetSubChaptersListContainsDiffNumberOfSubChapters() {
        final Chapter target = buildChapter(true);
        final Chapter anotherChapter = buildChapter(true);

        target.addSubChapter(new SubChapter("1", "Title", "Desc"));

        assertFalse(target.equals(anotherChapter));
    }

    @Test
    public void testEquals_TargetSubChaptersListContainsTheSameNumberOfSubChaptersButDiff() {
        final Chapter target = buildChapter(true);
        final Chapter anotherChapter = buildChapter(true);

        target.addSubChapter(new SubChapter("1", "Title", "Desc"));
        anotherChapter.addSubChapter(new SubChapter("2", "Title", "Desc"));

        assertFalse(target.equals(anotherChapter));
    }

    @Test
    public void testHashCode() {
        final Chapter target = buildChapter(true);

        final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();

        hashCodeBuilder
                .append(target.getKey())
                .append(target.getTitle())
                .append(target.getDescription())
                .append(target.getSubChapters());

        assertEquals(target.hashCode(), hashCodeBuilder.toHashCode());
    }

    private Chapter buildChapter(final boolean fillSubChapters) {
        return this.buildChapter("1", "Title", "Desc", fillSubChapters);
    }

    private Chapter buildChapter(
            final String key,
            final String title,
            final String description,
            final boolean fillSubChapters) {
        final Chapter result = new Chapter(key, title, description);

        if (fillSubChapters) {
            result.addSubChapters(Arrays.asList(
                    new SubChapter("1", "Title", "Desc"),
                    new SubChapter("2", "Title", "Desc")));
        }

        return result;
    }


}