package com.ww.JavaSerializable03.entity;

import java.io.*;

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