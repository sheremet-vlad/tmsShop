package com.teachmeskills.entity.customers;

public class PositiveCustomer extends Customer implements Movable
{
    private final boolean isPositive = true;

    @Override
    public boolean isMovable() {
        return true;
    }
}

