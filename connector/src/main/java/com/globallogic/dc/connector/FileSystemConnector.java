package com.globallogic.dc.connector;

import java.util.List;

public interface FileSystemConnector {
    List<String> readFile(String fileName);
}
