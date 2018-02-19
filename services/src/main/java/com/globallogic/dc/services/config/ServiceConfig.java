package com.globallogic.dc.services.config;

import com.globallogic.dc.services.ChapterServiceImpl;
import com.globallogic.dc.services.ChapterServiceMockImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public ChapterServiceImpl chapterService() {
        return new ChapterServiceImpl();
    }

    @Bean
    public ChapterServiceMockImpl chapterServiceMock() {
        return new ChapterServiceMockImpl();
    }

}
