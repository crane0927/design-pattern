package com.example.creational.singleton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 序列化破坏单例示例。
 */
public class SerializationBreakDemo {

    public static void main(String[] args) throws Exception {
        SerializableSingleton s1 = SerializableSingleton.getInstance();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        new ObjectOutputStream(bos).writeObject(s1);

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        SerializableSingleton s2 = (SerializableSingleton) ois.readObject();

        System.out.println(s1 == s2);
    }

    static class SerializableSingleton implements Serializable {
        private static final long serialVersionUID = 1L;
        private static final SerializableSingleton INSTANCE = new SerializableSingleton();

        private SerializableSingleton() {
        }

        public static SerializableSingleton getInstance() {
            return INSTANCE;
        }
    }
}
