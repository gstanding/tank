package com.mashibing.tank.abstractfactor;

public class MagicFactory extends AbstarctFactory {
    @Override
    Food createFood() {
        return new MashRoom();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Wepon createWepon() {
        return new MagicStick();
    }
}
