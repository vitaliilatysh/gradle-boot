package com.globallogic.dc.connector.config;

import com.globallogic.dc.connector.FileSystemConnectorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileSystemConnectorConfig {

    @Bean
    public FileSystemConnectorImpl fileSystemConnector() {
        return new FileSystemConnectorImpl();
    }
}
