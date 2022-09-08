package com.teachmeskills.entity.customer;

public class NegativeCustomer extends Customer implements Movable
{
    private final boolean isPositive = false;

    @Override
    public boolean isMovable() {
        return false;
    }
}
