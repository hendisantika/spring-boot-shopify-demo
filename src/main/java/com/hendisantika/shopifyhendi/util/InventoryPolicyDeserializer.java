package com.hendisantika.shopifyhendi.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.hendisantika.shopifyhendi.entity.InventoryPolicy;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Project : shopify-hendi
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 8/17/23
 * Time: 09:35
 * To change this template use File | Settings | File Templates.
 */
public class InventoryPolicyDeserializer extends StdDeserializer<InventoryPolicy> {

    public InventoryPolicyDeserializer() {
        this(InventoryPolicy.class);
    }

    protected InventoryPolicyDeserializer(Class<?> vc) {
        super(vc);
    }


    /**
     * @param p
     * @param ctxt
     * @return InventoryPolicy
     * @throws IOException
     * @throws JsonProcessingException
     */
    @Override
    public InventoryPolicy deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return InventoryPolicy.toEnum(p.getText());
    }
}
