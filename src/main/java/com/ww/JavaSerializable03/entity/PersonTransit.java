package com.ww.JavaSerializable03.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonTransit implements Serializable {

    private Long id;
    private String name;
    private Boolean male;
    private List<PersonTransit> friends;
    private Address address;


    /**
     * 自定义反序列化方法支持不可系列化属性序列化之后的反序列化
     *
     * @param in
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        System.out.println("PersonTransit readObject");
        this.id = in.readLong();
        this.name = in.readUTF();
        this.male = in.readBoolean();
        this.friends = (List<PersonTransit>) in.readObject();
        this.address = new Address(in.readUTF());
    }

    /**
     * 自定义序列化方法支持不可序列化属性进行序列化
     * 本方法可以允许我们在一个可序列化的类中使用不可序列化的属性，而且不需要transient。看上去已经挺不错了，
     * 但是如果前面Address类要在多个需要序列化的类中使用，更好的方式是用一个支持序列化的Decorator去修饰Address。
     * 然后在那些需要做序列化的类中使用这个Decorator。
     *
     * @param out
     * @throws IOException
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("PersonTransit writeObject");
        out.writeLong(id);
        out.writeUTF(name);
        out.writeBoolean(male);
        out.writeObject(friends);
        out.writeUTF(address.getDetail());
    }
}