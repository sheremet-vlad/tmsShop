package com.teachmeskills.entity.CustomerEntity;

public class NegativeCustomer extends Customer implements Movable
{
    private final boolean isPositive = false;

    @Override
    public boolean isMovable() {
        return false;
    }
}
