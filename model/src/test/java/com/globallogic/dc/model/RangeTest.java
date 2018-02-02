package com.globallogic.dc.model;

import com.globallogic.dc.commons.test.ItemBuilder;
import com.globallogic.dc.commons.test.RangeBuilder;
import com.globallogic.dc.commons.test.SectionBuilder;
import com.globallogic.dc.commons.test.SubChapterBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class RangeTest {

    private Range target;

    @Before
    public void setUp() {
        target = new RangeBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
    }

    @Test
    public void testHasSubChapters_Empty() {
        assertNull(target.getSubChapters());
        assertFalse(target.hasSubChapters());

        target.addSubChapters(new ArrayList<>());

        assertFalse(target.hasSubChapters());
    }

    @Test
    public void testHasSubChapters() {
        final SubChapter subChapter = new SubChapterBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        final Range target = new RangeBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .withSubChapters(Collections.singletonList(subChapter))
                .build();

        assertNotNull(target.getSubChapters());
        assertTrue(target.hasSubChapters());
    }

    @Test
    public void testAddSubChapter_NoSubChapterInRange() {
        final SubChapter subChapter = new SubChapterBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();

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
        final Range anotherRange = new RangeBuilder()
                .withKey("2")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        final SubChapter subChapter = new SubChapterBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();

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
        final SubChapter subChapter1 = new SubChapterBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        final SubChapter subChapter2 = new SubChapterBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();

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
        assertNull(target.getItems());
        assertFalse(target.hasItems());

        target.addItems(new ArrayList<>());

        assertFalse(target.hasItems());
    }

    @Test
    public void testHasItems() {
        final Item item = new ItemBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        final Range target = new RangeBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .withItems(Collections.singletonList(item))
                .build();

        assertNotNull(target.getItems());
        assertTrue(target.hasItems());
    }

    @Test
    public void testAddItem_NoItemInRange() {
        final Item item = new ItemBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();

        target.addItem(item);

        assertTrue(target.hasItems());
        assertTrue(item.getRange().equals(target));
        assertTrue(target.containsItem(item));
        assertEquals(1, target.getItems().size());
    }

    @Test
    public void testAddItem_MoveItemToAnotherRange() {
        final Range anotherRange = new RangeBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        final Item item = new ItemBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();

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
        final Item item1 = new ItemBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        final Item item2 = new ItemBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
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
        assertNull(target.getSections());
        assertFalse(target.hasSections());

        target.addSections(new ArrayList<>());

        assertFalse(target.hasSections());
    }

    @Test
    public void testHasSections() {
        final Section section = new SectionBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        final Range target = new RangeBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .withSections(Collections.singletonList(section))
                .build();

        assertNotNull(target.getSections());
        assertTrue(target.hasSections());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddSection_IllegalArgumentException() {
        target.addSection(null);
    }

    @Test
    public void testAddSection_NoSectionInRange() {
        final Section section = new SectionBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();

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
        final Range anotherRange = new RangeBuilder()
                .withKey("2")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        final Section section = new SectionBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();

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
        final Section section1 = new SectionBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        final Section section2 = new SectionBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
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