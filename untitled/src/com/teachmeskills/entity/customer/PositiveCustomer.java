package com.teachmeskills.entity.customer;

public class PositiveCustomer extends Customer implements Movable
{
    private final boolean isPositive = true;

    @Override
    public boolean isMovable() {
        return true;
    }
}

