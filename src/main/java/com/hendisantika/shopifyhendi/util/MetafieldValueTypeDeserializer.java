package com.hendisantika.shopifyhendi.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.hendisantika.shopifyhendi.entity.MetafieldValueType;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Project : shopify-hendi
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 8/17/23
 * Time: 11:35
 * To change this template use File | Settings | File Templates.
 */
public class MetafieldValueTypeDeserializer extends StdDeserializer<MetafieldValueType> {

    public MetafieldValueTypeDeserializer() {
        this(MetafieldValueType.class);
    }

    protected MetafieldValueTypeDeserializer(Class<MetafieldValueType> t) {
        super(t);
    }


    /**
     * @param p
     * @param ctxt
     * @return MetafieldValueType
     * @throws IOException
     * @throws JsonProcessingException
     */
    @Override
    public MetafieldValueType deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return MetafieldValueType.toEnum(p.getText());
    }
}
