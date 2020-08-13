package com.mashibing.tank.factormethod;

public class Main {

    public static void main(String[] args) {
        Car c = new Car();
        c.go();
        Plane p = new Plane();
        p.go();
//        Movable m = new Plane();
//        m.go();
        Movable m = new CarFactory().creatCar();
        m.go();
    }
}
