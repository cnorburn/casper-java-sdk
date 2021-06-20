package com.casper.sdk.service.serialization.cltypes;

import com.casper.sdk.service.serialization.util.ByteArrayBuilder;
import com.casper.sdk.service.serialization.util.ByteUtils;

/**
 * Converts a Java Byte array to a casper byte array
 */
public class ByteArraySerializer  implements TypesSerializer {
    @Override
    public byte[] serialize(Object toSerialize) {

        byte [] originalBytes = toBytes(toSerialize);

        return new ByteArrayBuilder()
                .append(ByteUtils.toU32(originalBytes.length))
                .append(originalBytes)
                .toByteArray();
    }

    private byte[] toBytes(Object toSerialize) {
        if (toSerialize instanceof String) {
            return ByteUtils.decodeHex((String) toSerialize);
        } if (toSerialize instanceof byte[]) {
            return (byte[]) toSerialize;
        } else {
            return new byte[0];
        }
    }
}