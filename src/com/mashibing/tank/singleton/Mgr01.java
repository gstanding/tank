package com.mashibing.tank.singleton;

public class Mgr01 {
    private static final Mgr01 INSTANCE = new Mgr01();
    private Mgr01() {
    }
    public static Mgr01  getInstance() {
        return INSTANCE;
    }
}
