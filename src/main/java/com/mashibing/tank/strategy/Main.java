package com.mashibing.tank.strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {4, 5, 2, 3, 7, 0};
        Sorter sorter = new Sorter();
        sorter.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
