package com.globallogic.dc.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SubChapterTest {

    private SubChapter target;
    private Chapter chapter;
    private List<Section> sections;
    private Section section;
    private List<Range> ranges;
    private Range range;

    @Before
    public void initParameters() {
        chapter = new Chapter("11", "SubChapTitle11", "SubChapDesc11");

        sections = new ArrayList<>();
        section = new Section("11", "SectionTitle11", "SectionDesc11");
        sections.add(section);

        ranges = new ArrayList<>();
        range = new Range("11", "RangeTitle11", "RangeDesc11");
        ranges.add(range);

    }

    @Before
    public void init() {
        target = new SubChapter("1", "Title", "Desc", chapter, sections, ranges) {
        };
    }

    @Test
    public void hasChapter() {
        assertTrue(target.hasChapter());

        target = new SubChapter("2", "Title", "Desc");
        assertFalse(target.hasChapter());

        target.setChapter(null);
        assertFalse(target.hasChapter());
    }

    @Test
    public void hasSections() {
        assertTrue(target.hasSections());

        sections.remove(section);
        assertFalse(target.hasSections());

        target.setSections(null);
        assertFalse(target.hasSections());

        target = new SubChapter("2", "Title2", "Desc2") {
        };
        assertFalse(target.hasSections());
    }

    @Test
    public void hasRanges() {
        assertTrue(target.hasRanges());

        ranges.remove(range);
        assertFalse(target.hasRanges());

        target.setRanges(null);
        assertFalse(target.hasRanges());

        target = new SubChapter("2", "Title2", "Desc2") {
        };
        assertFalse(target.hasRanges());
    }

    @Test
    public void addSections() {
        target.addSections(sections);
        assertThat(target.getSections().size(), is(2));

        target.addSections(null);
        assertThat(target.getSections().size(), is (2));

        sections.clear();
        target.addSections(sections);
        assertThat(target.getSections().size(), is (0));
    }

    @Test
    public void addSection() {
        target.addSection(new Section("15", "Title15", "Desc15"));
        assertThat(target.getSections().size(), is(2));

        target.addSection(null);
        assertThat(target.getSections().size(), is (2));
    }

    @Test
    public void addRanges() {
        target.addRanges(ranges);
        assertThat(target.getRanges().size(), is(2));

        target.addRanges(null);
        assertThat(target.getRanges().size(), is (2));

        ranges.clear();
        target.addRanges(ranges);
        assertThat(target.getRanges().size(), is (0));
    }

    @Test
    public void addRange() {
        target.addRange(new Range("15", "Title15", "Desc15"));
        assertThat(target.getRanges().size(), is(2));

        target.addRange(null);
        assertThat(target.getRanges().size(), is (2));
    }
}