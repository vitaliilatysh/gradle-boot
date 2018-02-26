package com.globallogic.dc.controllers.config;

import com.globallogic.dc.connector.FileSystemConnectorImpl;
import com.globallogic.dc.controllers.*;
import com.globallogic.dc.repository.fs.impl.*;
import com.globallogic.dc.services.impl.*;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackageClasses = {
        ChapterController.class, ChapterDaoImpl.class, ChapterServiceImpl.class, FileSystemConnectorImpl.class,
        ItemController.class, ItemServiceImpl.class, ItemDaoImpl.class,
        RangeController.class, RangeServiceImpl.class, RangeDaoImpl.class,
        SectionController.class, SectionServiceImpl.class, SectionDaoImpl.class,
        SubChapterController.class, SubChapterServiceImpl.class, SubChapterDaoImpl.class})
public class ControllerConfig {
}
