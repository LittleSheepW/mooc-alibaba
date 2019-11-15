package com.ww.JavaSerializable03;

import com.ww.JavaSerializable03.entity.Address;
import com.ww.JavaSerializable03.entity.PersonTransit;
import com.ww.JavaSerializable03.entity.SerializeAddress;
import com.ww.JavaSerializable03.entity.SerializePersonTransit;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Sun
 * @create: 2019-11-14 18:16
 * @version: v1.0
 */
public class JavaSerializable03Test {


    /**
     * 使用自定义writeObject()实现对不可序列化的属性进行序列化
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void customizeWriteObject() throws IOException, ClassNotFoundException {
        // 构造将要序列化的对象
        PersonTransit personTransit = new PersonTransit();
        personTransit.setId(1L);
        personTransit.setName("sunshine");
        personTransit.setMale(true);
        Address address = new Address("liuran");
        personTransit.setAddress(address);
        List<PersonTransit> personTransitList = new ArrayList<>();
        personTransitList.add(new PersonTransit(2L, "sun", false,
                new ArrayList<>(), new Address("liuran2")));
        personTransit.setFriends(personTransitList);

        // Start serialization
        File file1 = new File("/Users/sun/Desktop/JavaSerializable03-01");
        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(new FileOutputStream(file1));
        objectOutputStream1.writeObject(personTransit);

        ObjectInputStream objectInputStream1 = new ObjectInputStream(new FileInputStream(file1));
        PersonTransit readPersonTransit = (PersonTransit) objectInputStream1.readObject();
        System.out.println(readPersonTransit);
    }

    /**
     * 使用自定义的装饰器更加方便快捷的实现序列化
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void customDecoratorImplementSerialize() throws IOException, ClassNotFoundException {
        // 构造将要序列化的对象
        SerializePersonTransit serializePersonTransit = new SerializePersonTransit();
        serializePersonTransit.setId(1L);
        serializePersonTransit.setName("sunshine");
        serializePersonTransit.setMale(true);

        SerializeAddress serializeAddress = new SerializeAddress("liuran");
        serializePersonTransit.setSerializeAddress(serializeAddress);

        List<SerializePersonTransit> serializePersonTransitList = new ArrayList<>();
        serializePersonTransitList.add(new SerializePersonTransit(2L, "sun", false,
                new ArrayList<>(), new SerializeAddress("liuran2")));
        serializePersonTransit.setFriends(serializePersonTransitList);

        // Start serialization
        File file2 = new File("/Users/sun/Desktop/JavaSerializable03-02");
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(file2));
        objectOutputStream2.writeObject(serializePersonTransit);

        ObjectInputStream objectInputStream2 = new ObjectInputStream(new FileInputStream(file2));
        SerializePersonTransit readSerializePersonTransit = (SerializePersonTransit) objectInputStream2.readObject();
        System.out.println(readSerializePersonTransit);
    }
}
