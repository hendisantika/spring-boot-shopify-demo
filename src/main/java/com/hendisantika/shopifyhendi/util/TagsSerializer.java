package com.hendisantika.shopifyhendi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Project : shopify-hendi
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 8/17/23
 * Time: 09:32
 * To change this template use File | Settings | File Templates.
 */
public class TagsSerializer extends StdSerializer<Set<String>> {


    public static final String TAG_SERIALIZATION_DELIMITTER = ", ";

    public TagsSerializer() {
        this(null);
    }

    protected TagsSerializer(Class<Set<String>> t) {
        super(t);
    }


    /**
     * @param value
     * @param gen
     * @param provider
     * @throws IOException
     */
    @Override
    public void serialize(Set<String> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if ((value == null) || value.isEmpty()) {
            gen.writeNull();
        }

        final StringBuilder tagStringBuilder = new StringBuilder();
        if (value != null) {
            final Iterator<String> tagIterator = value.iterator();
            while (tagIterator.hasNext()) {
                final String tag = tagIterator.next();
                tagStringBuilder.append(tag);
                if (tagIterator.hasNext()) {
                    tagStringBuilder.append(TAG_SERIALIZATION_DELIMITTER);
                }
            }
        }
        gen.writeFieldName("tags");
        gen.writeString(tagStringBuilder.toString());
    }
}
