package com.example.behavioral.iterator;

import java.util.Iterator;

/**
 * 自定义聚合接口
 */
public interface Aggregate<T> {

    
    Iterator<T> iterator();
}
