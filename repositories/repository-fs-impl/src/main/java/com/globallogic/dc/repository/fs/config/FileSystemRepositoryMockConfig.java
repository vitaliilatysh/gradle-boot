package com.globallogic.dc.repository.fs.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.globallogic.dc.repository.fs.mockImpl")
@ConditionalOnProperty(name = "impl", havingValue = "false")
public class FileSystemRepositoryMockConfig {
}
