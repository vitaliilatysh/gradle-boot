package com.globallogic.dc.model;

import com.globallogic.dc.commons.test.ChapterBuilder;
import com.globallogic.dc.commons.test.SubChapterBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SubChapterTest {

    private SubChapter target;

    @Before
    public void setUp() {
        target = new SubChapterBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
    }

    @Test
    public void testSetChapter_NoChapterInSubChapter() {
        final Chapter chapter = new ChapterBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();

        target.setChapter(chapter);

        assertTrue(target.hasChapter());
        assertTrue(target.getChapter().equals(chapter));
        assertTrue(chapter.containsSubChapter(target));
        assertEquals(1, chapter.getSubChapters().size());
    }

    @Test
    public void testSetChapter_MoveChapterToAnotherSubChapter() {
        final SubChapter anotherSubChapter = new SubChapterBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        final Chapter chapter = new ChapterBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();

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
        assertNull(target.getChapter());
        assertFalse(target.hasChapter());
    }

    @Test
    public void testHasChapter() {
        final Chapter chapter = new ChapterBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        final SubChapter target = new SubChapterBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .withChapter(chapter)
                .build();

        assertNotNull(target.getChapter());
        assertTrue(target.hasChapter());
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
        final SubChapter target = new SubChapterBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .withSections(Arrays.asList(new Section("1", "Title", "Desc"), new Section("2", "Title", "Desc")))
                .build();

        assertNotNull(target.getSections());
        assertTrue(target.hasSections());
    }

    @Test
    public void testAddSection_NoSectionInSubChapter() {
        final Section section = new Section("1", "Title", "Desc");

        target.addSection(section);

        assertTrue(target.hasSections());
        assertTrue(section.getSubChapter().equals(target));
        assertTrue(target.containsSection(section));
        assertEquals(1, target.getSections().size());
    }

    @Test
    public void testAddSection_MoveSectionToAnotherSubChapter() {
        final SubChapter anotherSubChapter = new SubChapterBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
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
    public void testAddSections() {
        final SubChapter target = new SubChapterBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        final Section section1 = new Section("1", "Title", "Desc");
        final Section section2 = new Section("1", "Title", "Desc");
        final List<Section> sections = Arrays.asList(section1, section2);

        target.addSections(sections);

        assertTrue(target.hasSections());

        assertTrue(target.containsSection(section1));
        assertTrue(target.containsSection(section2));

        assertTrue(section1.hasSubChapter());
        assertTrue(section2.hasSubChapter());

        assertTrue(section1.getSubChapter().equals(target));
        assertTrue(section2.getSubChapter().equals(target));
    }

    @Test
    public void testHasRanges_Empty() {
        assertNull(target.getRanges());
        assertFalse(target.hasRanges());

        target.addRanges(new ArrayList<>());

        assertFalse(target.hasRanges());
    }

    @Test
    public void testHasRanges() {
        final SubChapter target = new SubChapterBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .withRanges(Arrays.asList(new Range("1", "Title", "Desc"), new Range("2", "Title", "Desc")))
                .build();

        assertNotNull(target.getRanges());
        assertTrue(target.hasRanges());
    }

    @Test
    public void testAddRange_NoRangeInSubChapter() {
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
    public void testAddRange_MoveRangeToAnotherSubChapter() {
        final SubChapter anotherSubChapter = new SubChapter("3", "Title", "Desc");
        final Range range = new Range("1", "Title", "Desc");

        target.addRange(range);
        anotherSubChapter.addRange(range);

        assertTrue(target.hasRanges());
        assertTrue(range.hasSubChapters());
        assertTrue(target.containsRange(range));
        assertTrue(range.containsSubChapter(target));
        assertTrue(range.containsSubChapter(anotherSubChapter));
        assertTrue(anotherSubChapter.containsRange(range));
        assertEquals(1, target.getRanges().size());
        assertEquals(1, anotherSubChapter.getRanges().size());
        assertEquals(2, range.getSubChapters().size());
    }

    @Test
    public void testAddRanges() {
        final Range range1 = new Range("2", "2", "2");
        final Range range2 = new Range("3", "3", "3");
        final List<Range> ranges = Arrays.asList(range1, range2);

        target.addRanges(ranges);

        assertTrue(target.hasRanges());

        assertTrue(target.containsRange(range1));
        assertTrue(target.containsRange(range2));

        assertTrue(range1.hasSubChapters());
        assertTrue(range2.hasSubChapters());

        assertTrue(range1.containsSubChapter(target));
        assertTrue(range2.containsSubChapter(target));
    }
}