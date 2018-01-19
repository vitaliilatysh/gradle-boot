package com.globallogic.dc.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ChapterTest {

    @Test
    public void testHasSubChapters_Empty() {
        final Chapter target = buildChapter(false);

        assertNull(target.getSubChapters());
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
    public void testAddSubChapter() {
        final Chapter target = buildChapter(false);

        target.addSubChapter(new SubChapter("1", "Title", "Desc"));

        assertEquals(1, target.getSubChapters().size());
    }

    @Test
    public void testAddSubChapters() {
        final Chapter target = buildChapter(false);

        target.addSubChapters(Arrays.asList(
                new SubChapter("1", "Title", "Desc"),
                new SubChapter("1", "Title", "Desc")));

        assertEquals(2, target.getSubChapters().size());
    }

    @Test
    public void testEquals() {
        final Chapter target = buildChapter(true);
        final Chapter anotherChapter = buildChapter(true);

        assertTrue(target.equals(anotherChapter));
    }

    @Test
    public void testEquals_NotEqual_Key() {
        final Chapter target = buildChapter("2", "Title", "Desc", true);
        final Chapter anotherChapter = buildChapter("1", "Title", "Desc", true);

        assertFalse(target.equals(anotherChapter));
    }

    @Test
    public void testEquals_NotEqual_Title() {
        final Chapter target = buildChapter("1", "NewTitle", "Desc", true);
        final Chapter anotherChapter = buildChapter("1", "Title", "Desc", true);

        assertFalse(target.equals(anotherChapter));
    }

    @Test
    public void testEquals_NotEqual_Desc() {
        final Chapter target = buildChapter("1", "Title", "NewDesc", true);
        final Chapter anotherChapter = buildChapter("1", "Title", "Desc", true);

        assertFalse(target.equals(anotherChapter));
    }

    @Test
    public void testEquals_NotEqual_SubChaptersListNotSet() {
        final Chapter target = buildChapter(false);
        final Chapter anotherChapter = buildChapter(true);

        assertFalse(target.equals(anotherChapter));
    }

    @Test
    public void testEquals_NotEqual_SubChaptersListEmpty(){
        final Chapter target = buildChapter( true);
        final Chapter anotherChapter = buildChapter(true);

        target.setSubChapters(new ArrayList<>());

        assertFalse(target.equals(anotherChapter));
    }

    @Test
    public void testEquals_NotEqual_SubChaptersListContainsDiffNumberOfSubChapters(){
        final Chapter target = buildChapter( true);
        final Chapter anotherChapter = buildChapter(true);

        target.addSubChapter(new SubChapter("1", "Title", "Desc"));

        assertFalse(target.equals(anotherChapter));
    }

    @Test
    public void testEquals_NotEqual_SubChaptersListContainsTheSameNumberOfSubChaptersButDiff(){
        final Chapter target = buildChapter( true);
        final Chapter anotherChapter = buildChapter(true);

        target.addSubChapter(new SubChapter("1", "Title", "Desc"));
        anotherChapter.addSubChapter(new SubChapter("2", "Title", "Desc"));

        assertFalse(target.equals(anotherChapter));
    }

    @Test
    public void testHashCode() {
        final Chapter target = buildChapter( true);

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