package com.globallogic.dc.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.globallogic.dc.repository.fs.mock")
@ConditionalOnProperty(name = "dc.repository.mock.enabled", havingValue = "true")
public class FileSystemRepositoryMockConfig {
}
