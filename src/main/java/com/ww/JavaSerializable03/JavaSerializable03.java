package com.ww.JavaSerializable03;

import com.ww.JavaSerializable03.entity.Address;
import com.ww.JavaSerializable03.entity.PersonTransit;
import com.ww.JavaSerializable03.entity.SerializeAddress;
import com.ww.JavaSerializable03.entity.SerializePersonTransit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Sun
 * @create: 2019-11-07 18:35
 * @version: v1.0
 */
public class JavaSerializable03 implements Serializable {

    /**
     *《手册》第9页“OOP规约”部分有一段关于序列化的约定
     *【强制】当序列化类新增属性时，请不要修改serialVersionUID字段，以避免反序列失败;如果完全不兼容升级，
     * 避免反序列化混乱，那么请修改serialVersionUID 值。
     * 说明:注意serialVersionUID值不一致会抛出序列化运行时异常。
     */

    /**
     * 包装类型不可强转，为什么包装类型不可强转？
     * Integer i = 100000;
     * Long l = (Long) i;
     * <p>
     * 并不是包装类型不可强转，而是只有具有子父类关系的类才可以相关强制转换。
     * 子类对象声明为父类类型后，可以通过强制转型转换为子类类型
     * 父类对象声明为父类类型后，不可以通过强制转换转换为子类型
     */

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 使用自定义writeObject()实现对不可序列化的属性进行序列化
        PersonTransit personTransit = new PersonTransit();
        personTransit.setId(1L);
        personTransit.setName("sunshine");
        personTransit.setMale(true);

        Address address = new Address("liuran");
        personTransit.setAddress(address);

        List<PersonTransit> personTransitList = new ArrayList<PersonTransit>();
        personTransitList.add(new PersonTransit(2L, "sun", false,
                new ArrayList<PersonTransit>(), new Address("liuran2")));
        personTransit.setFriends(personTransitList);


        File file1 = new File("/Users/sun/Desktop/JavaSerializable03-01");
        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(new FileOutputStream(file1));
        objectOutputStream1.writeObject(personTransit);

        ObjectInputStream objectInputStream1 = new ObjectInputStream(new FileInputStream(file1));
        PersonTransit readPersonTransit = (PersonTransit) objectInputStream1.readObject();
        System.out.println(readPersonTransit);

        System.out.println("------------------------------------------------------------------");

        // 使用默认的objectOutputStream.writeObject()实现对不可序列化属性序列化
        SerializePersonTransit serializePersonTransit = new SerializePersonTransit();
        serializePersonTransit.setId(1L);
        serializePersonTransit.setName("sunshine");
        serializePersonTransit.setMale(true);

        SerializeAddress serializeAddress = new SerializeAddress("liuran");
        serializePersonTransit.setSerializeAddress(serializeAddress);

        List<SerializePersonTransit> serializePersonTransitList = new ArrayList<SerializePersonTransit>();
        serializePersonTransitList.add(new SerializePersonTransit(2L, "sun", false,
                new ArrayList<SerializePersonTransit>(), new SerializeAddress("liuran2")));
        serializePersonTransit.setFriends(serializePersonTransitList);

        File file2 = new File("/Users/sun/Desktop/JavaSerializable03-02");
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(file2));
        objectOutputStream2.writeObject(serializePersonTransit);

        ObjectInputStream objectInputStream2 = new ObjectInputStream(new FileInputStream(file2));
        SerializePersonTransit readSerializePersonTransit = (SerializePersonTransit) objectInputStream2.readObject();
        System.out.println(readSerializePersonTransit);
    }
}
