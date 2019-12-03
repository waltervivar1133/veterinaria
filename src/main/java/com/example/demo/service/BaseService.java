package com.example.demo.service;

import java.util.List;

public interface BaseService<X,Y> {

    void create(X x);
    void update(X x);
    void delete(Y y);

    List<X> findAll();
    X findById(Y y);


}
