package com.globallogic.dc.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.globallogic.dc.commons.test.RangeBuilder.buildRange;
import static org.junit.Assert.*;

public class RangeTest {

    @Test
    public void testHasSubChapters_Empty() {
        final Range target = buildRange(false, false, false);

        assertNull(target.getSubChapters());
        assertFalse(target.hasSubChapters());

        target.addSubChapters(new ArrayList<>());

        assertFalse(target.hasSubChapters());
    }

    @Test
    public void testHasSubChapters() {
        final Range target = buildRange(true, false, false);

        assertNotNull(target.getSubChapters());
        assertTrue(target.hasSubChapters());
    }

    @Test
    public void testAddSubChapter_NoSubChapterInRange() {
        final Range target = buildRange(false, false, false);
        final SubChapter subChapter = new SubChapter("1", "Title", "Desc");

        target.addSubChapter(subChapter);

        assertTrue(target.hasSubChapters());
        assertTrue(subChapter.hasRanges());
        assertTrue(target.containsSubChapter(subChapter));
        assertTrue(subChapter.containsRange(target));
        assertEquals(1, target.getSubChapters().size());
        assertEquals(1, subChapter.getRanges().size());
    }

    @Test
    public void testAddSubChapter_MoveSubChapterToAnotherRange() {
        final Range target = buildRange(false, false, false);
        final Range anotherRange = new Range("3", "Title", "Desc");
        final SubChapter subChapter = new SubChapter("1", "Title", "Desc");

        target.addSubChapter(subChapter);
        anotherRange.addSubChapter(subChapter);

        assertTrue(target.hasSubChapters());
        assertTrue(subChapter.hasRanges());
        assertTrue(target.containsSubChapter(subChapter));
        assertTrue(subChapter.containsRange(target));
        assertTrue(subChapter.containsRange(anotherRange));
        assertEquals(1, target.getSubChapters().size());
        assertEquals(1, anotherRange.getSubChapters().size());
        assertEquals(2, subChapter.getRanges().size());
    }

    @Test
    public void testAddSubChapters() {
        final Range target = buildRange(false, false, false);
        final SubChapter subChapter1 = new SubChapter("2", "2", "2");
        final SubChapter subChapter2 = new SubChapter("3", "3", "3");
        final List<SubChapter> subChapters = Arrays.asList(subChapter1, subChapter2);

        target.addSubChapters(subChapters);

        assertTrue(target.hasSubChapters());

        assertTrue(target.containsSubChapter(subChapter1));
        assertTrue(target.containsSubChapter(subChapter2));

        assertTrue(subChapter1.hasRanges());
        assertTrue(subChapter2.hasRanges());

        assertTrue(subChapter1.containsRange(target));
        assertTrue(subChapter2.containsRange(target));
    }

    @Test
    public void testHasItems_Empty() {
        final Range target = buildRange(false, false, false);

        assertNull(target.getItems());
        assertFalse(target.hasItems());

        target.addItems(new ArrayList<>());

        assertFalse(target.hasItems());
    }

    @Test
    public void testHasItems() {
        final Range target = buildRange(false, true, false);

        assertNotNull(target.getItems());
        assertTrue(target.hasItems());
    }

    @Test
    public void testAddItem_NoItemInRange() {
        final Range target = buildRange(false, false, false);
        final Item item = new Item("1", "Title", "Desc");

        target.addItem(item);

        assertTrue(target.hasItems());
        assertTrue(item.getRange().equals(target));
        assertTrue(target.containsItem(item));
        assertEquals(1, target.getItems().size());
    }

    @Test
    public void testAddItem_MoveItemToAnotherRange() {
        final Range target = buildRange(false, false, false);
        final Range anotherRange = buildRange(false, false, false);
        final Item item = new Item("1", "Title", "Desc");

        target.addItem(item);
        anotherRange.addItem(item);

        assertFalse(target.hasItems());
        assertTrue(anotherRange.hasItems());
        assertTrue(anotherRange.containsItem(item));
        assertTrue(item.getRange().equals(anotherRange));
        assertEquals(1, anotherRange.getItems().size());
    }

    @Test
    public void testAddItems() {
        final Range target = buildRange(false, false, false);
        final Item item1 = new Item("1", "Title", "Desc");
        final Item item2 = new Item("1", "Title", "Desc");
        final List<Item> items = Arrays.asList(item1, item2);

        target.addItems(items);

        assertTrue(target.hasItems());

        assertTrue(target.containsItem(item1));
        assertTrue(target.containsItem(item2));

        assertTrue(item1.hasRange());
        assertTrue(item2.hasRange());

        assertTrue(item1.getRange().equals(target));
        assertTrue(item2.getRange().equals(target));
    }

    @Test
    public void testHasSections_Empty() {
        final Range target = buildRange(false, false, false);

        assertNull(target.getSections());
        assertFalse(target.hasSections());

        target.addSections(new ArrayList<>());

        assertFalse(target.hasSections());
    }

    @Test
    public void testHasSections() {
        final Range target = buildRange(false, false, true);

        assertNotNull(target.getSections());
        assertTrue(target.hasSections());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddSection_IllegalArgumentException() {
        final Range target = buildRange(false, false, false);

        target.addSection(null);
    }

    @Test
    public void testAddSection_NoSectionInRange() {
        final Range target = buildRange(false, false, false);
        final Section section = new Section("1", "Title", "Desc");

        target.addSection(section);

        assertTrue(target.hasSections());
        assertTrue(section.hasRanges());
        assertTrue(target.containsSection(section));
        assertTrue(section.containsRange(target));
        assertEquals(1, target.getSections().size());
        assertEquals(1, section.getRanges().size());
    }

    @Test
    public void testAddSection_MoveSectionToAnotherRange() {
        final Range target = buildRange(false, false, false);
        final Range anotherRange = new Range("3", "Title", "Desc");
        final Section section = new Section("1", "Title", "Desc");

        target.addSection(section);
        anotherRange.addSection(section);

        assertTrue(target.hasSections());
        assertTrue(section.hasRanges());
        assertTrue(anotherRange.hasSections());
        assertTrue(target.containsSection(section));
        assertTrue(section.containsRange(target));
        assertTrue(section.containsRange(anotherRange));
        assertTrue(anotherRange.containsSection(section));
        assertEquals(1, target.getSections().size());
        assertEquals(1, anotherRange.getSections().size());
        assertEquals(2, section.getRanges().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddSections_IllegalArgumentException() {
        final Range target = buildRange(false, false, false);

        target.addSections(null);
    }

    @Test
    public void testAddSections() {
        final Range target = buildRange(false, false, false);
        final Section section1 = new Section("2", "2", "2");
        final Section section2 = new Section("3", "3", "3");
        final List<Section> sections = Arrays.asList(section1, section2);

        target.addSections(sections);

        assertTrue(target.hasSections());

        assertTrue(target.containsSection(section1));
        assertTrue(target.containsSection(section2));

        assertTrue(section1.hasRanges());
        assertTrue(section2.hasRanges());

        assertTrue(section1.containsRange(target));
        assertTrue(section2.containsRange(target));
    }
}