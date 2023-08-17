package com.hendisantika.shopifyhendi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.hendisantika.shopifyhendi.entity.MetafieldValueType;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Project : shopify-hendi
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 8/17/23
 * Time: 11:34
 * To change this template use File | Settings | File Templates.
 */
public class MetafieldValueTypeSerializer extends StdSerializer<MetafieldValueType> {

    public MetafieldValueTypeSerializer() {
        this(MetafieldValueType.class);
    }

    protected MetafieldValueTypeSerializer(Class<MetafieldValueType> t) {
        super(t);
    }


    /**
     * @param value
     * @param gen
     * @param provider
     * @throws IOException
     */
    @Override
    public void serialize(MetafieldValueType value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.toString());

    }
}
