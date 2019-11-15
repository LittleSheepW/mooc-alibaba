package com.ww.JavaSerializable03.entity;

import java.io.*;

/**
 * 如果Address类要在多个需要序列化的类中使用，在每个序列化的类中手动重写writeObject()方法是在是很繁琐，
 * 更好的方式是用一个支持序列化的Decorator去修饰Address。然后在那些需要做序列化的类中使用这个Decorator。
 */
public class SerializeAddress implements Serializable {

    private Address address;

    public SerializeAddress(String detail) {
        this.address = new Address(detail);
    }

    public String getAddressDetail() {
        return address.getDetail();
    }

    private void writeObject(final ObjectOutputStream out) throws IOException {
        out.writeUTF(this.address.getDetail());
    }

    private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.address = new Address(in.readUTF());
    }

    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("Stream data required");
    }

    @Override
    public String toString() {
        return "SerializeAddress{" +
                "address=" + address +
                '}';
    }
}