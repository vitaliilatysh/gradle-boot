package com.globallogic.dc.model;

import com.globallogic.dc.commons.test.ItemBuilder;
import com.globallogic.dc.commons.test.RangeBuilder;
import com.globallogic.dc.commons.test.SectionBuilder;
import com.globallogic.dc.commons.test.SubChapterBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RangeTest {

    private final Range target = new RangeBuilder().defaultInit();
    private final Range anotherRange = new RangeBuilder().defaultInit();
    private final SubChapter subChapter = new SubChapterBuilder().defaultInit();
    private final SubChapter anotherSubChapter = new SubChapterBuilder().defaultInit();
    private final Item item = new ItemBuilder().defaultInit();
    private final Item anotherItem = new ItemBuilder().defaultInit();
    private final Section section = new SectionBuilder().defaultInit();
    private final Section anotherSection = new SectionBuilder().defaultInit();

    @Test
    public void testHasSubChapters_Empty() {
        assertNull(target.getSubChapters());
        assertFalse(target.hasSubChapters());

        target.addSubChapters(new ArrayList<>());

        assertFalse(target.hasSubChapters());
    }

    @Test
    public void testHasSubChapters() {
        target.addSubChapter(subChapter);

        assertNotNull(target.getSubChapters());
        assertTrue(target.hasSubChapters());
    }

    @Test
    public void testAddSubChapter_NoSubChapterInRange() {
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
        anotherRange.setKey("2");

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
        final List<SubChapter> subChapters = Arrays.asList(subChapter, anotherSubChapter);

        target.addSubChapters(subChapters);

        assertTrue(target.hasSubChapters());

        assertTrue(target.containsSubChapter(subChapter));
        assertTrue(target.containsSubChapter(anotherSubChapter));

        assertTrue(subChapter.hasRanges());
        assertTrue(anotherSubChapter.hasRanges());

        assertTrue(subChapter.containsRange(target));
        assertTrue(anotherSubChapter.containsRange(target));
    }

    @Test
    public void testHasItems_Empty() {
        assertNull(target.getItems());
        assertFalse(target.hasItems());

        target.addItems(new ArrayList<>());

        assertFalse(target.hasItems());
    }

    @Test
    public void testHasItems() {
        target.addItem(item);

        assertNotNull(target.getItems());
        assertTrue(target.hasItems());
    }

    @Test
    public void testAddItem_NoItemInRange() {
        target.addItem(item);

        assertTrue(target.hasItems());
        assertTrue(item.getRange().equals(target));
        assertTrue(target.containsItem(item));
        assertEquals(1, target.getItems().size());
    }

    @Test
    public void testAddItem_MoveItemToAnotherRange() {
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
        final List<Item> items = Arrays.asList(item, anotherItem);

        target.addItems(items);

        assertTrue(target.hasItems());

        assertTrue(target.containsItem(item));
        assertTrue(target.containsItem(anotherItem));

        assertTrue(item.hasRange());
        assertTrue(anotherItem.hasRange());

        assertTrue(item.getRange().equals(target));
        assertTrue(anotherItem.getRange().equals(target));
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

    @Test(expected = IllegalArgumentException.class)
    public void testAddSection_IllegalArgumentException() {
        target.addSection(null);
    }

    @Test
    public void testAddSection_NoSectionInRange() {
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
        anotherRange.setKey("2");

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
        target.addSections(null);
    }

    @Test
    public void testAddSections() {
        final List<Section> sections = Arrays.asList(section, anotherSection);

        target.addSections(sections);

        assertTrue(target.hasSections());

        assertTrue(target.containsSection(section));
        assertTrue(target.containsSection(anotherSection));

        assertTrue(section.hasRanges());
        assertTrue(anotherSection.hasRanges());

        assertTrue(section.containsRange(target));
        assertTrue(anotherSection.containsRange(target));
    }
}