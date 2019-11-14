package com.ww.JavaClone04.util;

import com.google.gson.Gson;

import java.io.*;

/**
 * @author: Sun
 * @create: 2019-11-14 17:05
 * @version: v1.0
 */
public class CloneUtil {

    /**
     * JDK序列化方式深拷贝
     */
    public static <T> T deepCloneByJdk(T origin) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(origin);
            objectOutputStream.flush();
        }
        byte[] bytes = byteArrayOutputStream.toByteArray();
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            return (T) objectInputStream.readObject();
        }
    }

    /**
     * JSON序列化方式实现深拷贝
     */
    public static <T> T deepCloneByGson(T origin, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(gson.toJson(origin), clazz);
    }
}
