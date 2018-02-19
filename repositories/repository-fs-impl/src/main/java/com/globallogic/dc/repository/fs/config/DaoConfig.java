package com.globallogic.dc.repository.fs.config;

import com.globallogic.dc.repository.fs.impl.*;
import com.globallogic.dc.repository.fs.impl.mock.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {

    @Bean
    ChapterDaoImpl chapterDao() {
        return new ChapterDaoImpl();
    }

    @Bean
    ChapterDaoMockImpl chapterDaoMock() {
        return new ChapterDaoMockImpl();
    }

    @Bean
    SubChapterDaoImpl subChapterDao() {
        return new SubChapterDaoImpl();
    }

    @Bean
    SubChapterDaoMockImpl subChapterDaoMock() {
        return new SubChapterDaoMockImpl();
    }

    @Bean
    SectionDaoImpl sectionDao() {
        return new SectionDaoImpl();
    }

    @Bean
    SectionDaoMockImpl sectionDaoMock() {
        return new SectionDaoMockImpl();
    }

    @Bean
    RangeDaoImpl rangeDao() {
        return new RangeDaoImpl();
    }

    @Bean
    RangeDaoMockImpl rangeDaoMock() {
        return new RangeDaoMockImpl();
    }

    @Bean
    ItemDaoImpl itemDao() {
        return new ItemDaoImpl();
    }

    @Bean
    ItemDaoMockImpl itemDaoMock() {
        return new ItemDaoMockImpl();
    }
}

