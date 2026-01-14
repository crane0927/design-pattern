package com.example.behavioral.iterator;

import java.util.Iterator;
/**
 * 名字仓库
 */
public class NameRepository implements Aggregate<String> {

    private String[] names = { "Robert", "John", "Julie", "Lora" };

    @Override
    public Iterator<String> iterator() {
        return new NameIterator();
    }

    class NameIterator implements Iterator<String> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public String next() {
            return names[index++];
        }
    }
}