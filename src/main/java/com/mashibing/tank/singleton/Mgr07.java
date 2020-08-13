package com.mashibing.tank.singleton;

public class Mgr07 {
    private Mgr07() {
    }

    private static class Mgr07Holder {
        private static final Mgr07 INSTANCE = new Mgr07();
    }

    private static Mgr07 getInstance() throws InterruptedException {
        Thread.sleep(1);
        return Mgr07Holder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i=0; i < 100; i ++) {
            new Thread(() -> {
                try {
                    System.out.println(Mgr07.getInstance().hashCode());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
