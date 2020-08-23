package com.mashibing.tank;

import java.io.Serializable;

public interface FireStrategy<T> extends Serializable {
    void fire(T t);
}
