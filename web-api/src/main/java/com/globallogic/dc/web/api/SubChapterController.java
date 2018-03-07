package com.globallogic.dc.web.api;

import com.globallogic.dc.model.SubChapter;
import com.globallogic.dc.service.api.SubChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/subChapters", produces = MediaType.APPLICATION_JSON_VALUE)
public class SubChapterController {

    @Autowired
    private SubChapterService subChapterService;

    @GetMapping
    public List<SubChapter> getSubChapters() {
        return subChapterService.getSubChapters();
    }

    @GetMapping(value = "/{id}")
    public SubChapter getSubChapterById(@PathVariable("id") final String id) {
        return subChapterService.getSubChapterById(id);
    }

    @GetMapping(params = "chapter")
    public List<SubChapter> getSubChaptersByChapterId(@RequestParam("chapter") final String id) {
        return subChapterService.getSubChaptersByChapterId(id);
    }
}
