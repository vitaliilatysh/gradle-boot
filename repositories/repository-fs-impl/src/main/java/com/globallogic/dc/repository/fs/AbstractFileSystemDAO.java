package com.globallogic.dc.repository.fs;

import com.globallogic.dc.commons.model.Entity;
import com.globallogic.dc.connector.FileSystemConnector;
import com.globallogic.dc.connector.FileSystemConnectorImpl;
import com.globallogic.dc.repository.ProductsDao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractFileSystemDAO<M extends Entity> implements ProductsDao<M> {

    private FileSystemConnector connector = FileSystemConnectorImpl.getInstance();

    @Override
    public List<M> getAll() {
        final List<M> items = new ArrayList<>();

        return connector.readFile(getFileName())
                .stream()
                .map(this::fromDto)
                .collect(Collectors.toCollection(() -> items));
    }

    @Override
    public M getById(final String id) {

        return connector.readFile(getFileName())
                .stream()
                .map(this::fromDto)
                .filter(item -> item.getIdentifier().equals(id))
                .findFirst()
                .orElse(null);
    }

    protected abstract M fromDto(final String dto);

    protected abstract String getFileName();
}
