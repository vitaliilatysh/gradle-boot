package com.globallogic.dc.dao;

import java.util.List;

public interface ProductsDao<M> {

    List<M> getAll();

    M getById(String id);
}
