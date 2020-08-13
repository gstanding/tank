package com.mashibing.tank.factormethod;
/**
 * 简单工厂
 * 可扩展性不好
 */
public class SimpleVehicleFactory {
    public Car creatCar() {
        // before process
        return new Car();
    }

    public Plane createPlane() {
        // 权限、日志...
        return new Plane();
    }
}
