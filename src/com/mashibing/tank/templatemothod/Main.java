package com.mashibing.tank.templatemothod;

public class Main {
    public static void main(String[] args) {
        F f = new c1();
        f.m();
    }
}

abstract class F {
    /**
     * 模板方法
     */
    void m() {
        op1();
        op2();
    }

    protected abstract void op1();
    protected abstract void op2();
}

class c1 extends F {
    @Override
    protected void op1() {
        System.out.println("op1");
    }

    @Override
    protected void op2() {
        System.out.println("op2");
    }
}
