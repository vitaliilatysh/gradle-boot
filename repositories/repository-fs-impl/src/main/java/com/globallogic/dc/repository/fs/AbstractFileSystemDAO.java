package com.globallogic.dc.repository.fs;

import com.globallogic.dc.commons.model.Entity;
import com.globallogic.dc.connector.FileSystemConnector;
import com.globallogic.dc.connector.FileSystemConnectorImpl;
import com.globallogic.dc.repository.ProductsDao;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public abstract class AbstractFileSystemDAO<M extends Entity> implements ProductsDao<M> {

    private FileSystemConnector connector = FileSystemConnectorImpl.getInstance();

    @Override
    public List<M> getAll() {
        return connector.readFile(getFileName())
                .stream()
                .map(this::fromDto)
                .collect(Collectors.toList());
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

    protected FileSystemConnector getConnector() {
        return connector;
    }

    protected List<M> processRelations(final String id, final String fileName) {
        return getConnector().readFile(getFileName())
                .stream()
                .map(row -> row.split(","))
                .filter(row -> getConnector().readFile(fileName)
                        .stream()
                        .map(line -> line.split(","))
                        .filter(line -> line[1].equals(id))
                        .map(line -> line[0])
                        .collect(toList())
                        .contains(row[0]))
                .map(row -> fromDto(String.join(",", row)))
                .collect(toList());
    }
}
