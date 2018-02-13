package com.globallogic.dc.connector;

import java.io.File;
import java.util.List;

public interface FileSystemConnector {
    List<String> readFile(File fileName);
}
