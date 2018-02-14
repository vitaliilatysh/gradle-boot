package com.globallogic.dc.repository.fs;

import com.globallogic.dc.commons.model.Entity;
import com.globallogic.dc.connector.FileSystemConnector;
import com.globallogic.dc.connector.FileSystemConnectorImpl;
import com.globallogic.dc.repository.ProductsDao;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class AbstractFileSystemDAO<M extends Entity> implements ProductsDao<M> {

    private FileSystemConnector connector = FileSystemConnectorImpl.getInstance();

    @Override
    public List<M> getAll() {
        return connector.readFile(getFile())
                .stream()
                .map(this::fromDto)
                .collect(Collectors.toList());
    }

    @Override
    public M getById(final String id) {

        return connector.readFile(getFile())
                .stream()
                .map(this::fromDto)
                .filter(item -> item.getIdentifier().equals(id))
                .findFirst()
                .orElse(null);
    }

    protected abstract M fromDto(final String dto);

    protected abstract String getFileName();

    protected File getFile() {
        return new File(Objects.requireNonNull(getClass().getClassLoader().getResource(getFileName())).getFile());
    }

    protected FileSystemConnector getConnector() {
        return connector;
    }
}
