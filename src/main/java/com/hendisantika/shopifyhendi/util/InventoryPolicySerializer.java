package com.hendisantika.shopifyhendi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.hendisantika.shopifyhendi.entity.InventoryPolicy;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Project : shopify-hendi
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 8/17/23
 * Time: 09:34
 * To change this template use File | Settings | File Templates.
 */
public class InventoryPolicySerializer extends StdSerializer<InventoryPolicy> {

    public InventoryPolicySerializer() {
        this(InventoryPolicy.class);
    }

    protected InventoryPolicySerializer(Class<InventoryPolicy> t) {
        super(t);
    }


    /**
     * @param value
     * @param gen
     * @param provider
     * @throws IOException
     */
    @Override
    public void serialize(InventoryPolicy value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.toString());

    }
}
