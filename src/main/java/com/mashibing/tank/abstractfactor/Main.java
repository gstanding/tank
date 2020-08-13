package com.mashibing.tank.abstractfactor;

public class Main {
    public static void main(String[] args) {
        Car c = new Car();
        c.go();
        AK47 ak47 = new AK47();
        ak47.shoot();
        Bread b = new Bread();
        b.eat();

        /**
         * 产品簇
         */
        AbstarctFactory abstarctFactory = new ModernFactory();
        Vehicle vehicle = abstarctFactory.createVehicle();
        vehicle.go();
        Food food = abstarctFactory.createFood();
        food.eat();
        Wepon wepon = abstarctFactory.createWepon();
        wepon.shoot();
    }
}
