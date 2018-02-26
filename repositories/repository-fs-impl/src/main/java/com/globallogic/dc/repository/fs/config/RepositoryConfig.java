package com.globallogic.dc.repository.fs.config;

import com.globallogic.dc.connector.FileSystemConnectorImpl;
import com.globallogic.dc.repository.fs.impl.ItemDaoImpl;
import com.globallogic.dc.repository.fs.impl.RangeDaoImpl;
import com.globallogic.dc.repository.fs.impl.SectionDaoImpl;
import com.globallogic.dc.repository.fs.impl.SubChapterDaoImpl;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackageClasses = {ItemDaoImpl.class, FileSystemConnectorImpl.class,
        ItemDaoImpl.class, RangeDaoImpl.class, SectionDaoImpl.class, SubChapterDaoImpl.class})
public class RepositoryConfig {
}
