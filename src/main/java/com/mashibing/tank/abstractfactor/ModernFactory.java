package com.mashibing.tank.abstractfactor;

public class ModernFactory extends AbstarctFactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Wepon createWepon() {
        return new AK47();
    }
}
