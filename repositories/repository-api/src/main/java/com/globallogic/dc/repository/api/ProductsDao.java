package com.globallogic.dc.repository.api;

import java.util.List;

public interface ProductsDao<M> {

    List<M> getAll();

    M getById(String id);
}
