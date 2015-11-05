package com.microsoft.services.orc.serialization;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.microsoft.services.orc.http.Base64Encoder;

import java.lang.reflect.Type;

/**
 * The type Byte array type adapter base.
 */
public abstract class ByteArrayTypeAdapterBase implements JsonSerializer<byte[]>, JsonDeserializer<byte[]> {

    @Override
    public byte[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return getBase64Encoder().decode(json.getAsString());
    }

    @Override
    public JsonElement serialize(byte[] src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(getBase64Encoder().encode(src));
    }

    /**
     * Gets base 64 encoder.
     *
     * @return the base 64 encoder
     */
    protected abstract Base64Encoder getBase64Encoder();
}
