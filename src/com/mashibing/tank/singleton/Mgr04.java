package com.mashibing.tank.singleton;

public class Mgr04 {
    private static Mgr04 INSTANCE;

    private Mgr04() {
    }

    public static synchronized Mgr04 getInstance() throws InterruptedException {
        if (INSTANCE == null) {
            Thread.sleep(1);
            INSTANCE = new Mgr04();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i=0; i < 100; i ++) {
            new Thread(() -> {
                try {
                    System.out.println(Mgr04.getInstance().hashCode());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
