package com.globallogic.dc.repository;

import java.util.List;

public interface ProductsDao<M> {

    List<M> getAll();

    M getById(String id);
}
