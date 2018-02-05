package com.globallogic.dc.services;

import com.globallogic.dc.model.Chapter;

import java.util.List;

public class ChapterServiceImpl implements ChapterService {

    private static volatile ChapterServiceImpl instance = null;

    public static ChapterServiceImpl getInstance(){
        if(instance == null){
            synchronized (ChapterServiceImpl.class){
                if (instance == null){
                    instance = new ChapterServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Chapter> getChapters() {
        return null;
    }

    @Override
    public Chapter getChapterById(final String key) {
        return null;
    }
}