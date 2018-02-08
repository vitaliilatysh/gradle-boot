package com.globallogic.dc.dao;

import com.globallogic.dc.commons.model.Entity;
import com.globallogic.dc.connector.FileSystemConnector;
import com.globallogic.dc.connector.FileSystemConnectorImpl;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFileSystemDAO<M extends Entity> implements ProductsDao<M> {

    private FileSystemConnector connector = FileSystemConnectorImpl.getInstance();

    @Override
    public List<M> getAll() {
        final List<M> items = new ArrayList<>();

        for (final String row : connector.readFile(getFileName())) {
            items.add(fromDto(row));
        }

        return items;
    }

    @Override
    public M getById(final String id) {
        for (final String row : connector.readFile(getFileName())) {
            final M item = fromDto(row);

            if (item.getIdentifier().equals(id)) {
                return item;
            }
        }
        return null;
    }

    protected abstract M fromDto(final String dto);

    protected abstract String getFileName();
}
