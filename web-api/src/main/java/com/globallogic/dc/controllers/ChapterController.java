package com.globallogic.dc.controllers;

import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.services.ChapterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@ComponentScan(basePackages = {"com.globallogic.dc.controllers", "com.globallogic.dc.services"})
@Configuration
public class ChapterController {

    private final ChapterServiceImpl chapterService;

    @Autowired
    public ChapterController(ChapterServiceImpl chapterService) {
        this.chapterService = chapterService;
    }

    @GetMapping(value = "/chapters", produces = "application/json; charset=utf-8")
    public @ResponseBody
    List<Chapter> getAllChapters(HttpServletResponse response) {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        return chapterService.getChapters();
    }
}
