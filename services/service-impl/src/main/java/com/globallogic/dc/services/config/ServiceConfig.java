package com.globallogic.dc.services.config;

import com.globallogic.dc.connector.FileSystemConnectorImpl;
import com.globallogic.dc.repository.fs.impl.ChapterDaoImpl;
import com.globallogic.dc.services.impl.ChapterServiceImpl;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackageClasses = {ChapterServiceImpl.class, ChapterDaoImpl.class, FileSystemConnectorImpl.class})
public class ServiceConfig {
}
