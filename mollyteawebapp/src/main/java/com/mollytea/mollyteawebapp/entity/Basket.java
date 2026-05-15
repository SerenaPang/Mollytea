package com.mollytea.mollyteawebapp.entity;

import java.util.Collection;

public interface Basket {

    void add(Long id);

    int getTotalItems();

    Collection<BasketItem> getItems();

    void remove(Long id);

    void clear();
}