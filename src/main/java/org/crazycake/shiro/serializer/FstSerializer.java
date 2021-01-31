package org.crazycake.shiro.serializer;

import org.crazycake.shiro.exception.SerializationException;
import org.nustaq.serialization.FSTConfiguration;

import java.io.Serializable;

public class FstSerializer implements RedisSerializer<Object> {

    private static FSTConfiguration configuration = FSTConfiguration
             .createDefaultConfiguration();
    @Override
    public byte[] serialize(Object object) throws SerializationException {
        byte[] result = new byte[0];

        if (object == null) {
            return result;
        }
        if (!(object instanceof Serializable)) {
            throw new SerializationException("requires a Serializable payload "
                    + "but received an object of type [" + object.getClass().getName() + "]");
        }
        return configuration.asByteArray(object);

    }

    @Override
    public Object deserialize(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        return configuration.asObject(bytes);
    }
}
