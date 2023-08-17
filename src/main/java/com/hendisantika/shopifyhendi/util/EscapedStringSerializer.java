package com.hendisantika.shopifyhendi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.apache.commons.text.StringEscapeUtils;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Project : shopify-hendi
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 8/17/23
 * Time: 09:29
 * To change this template use File | Settings | File Templates.
 */
public class EscapedStringSerializer extends StdSerializer<String> {

    public EscapedStringSerializer() {
        super(String.class);
    }


    /**
     * @param value
     * @param jgen
     * @param provider
     * @throws IOException
     * @throws JsonProcessingException
     */
    @Override
    public void serialize(String value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeString(StringEscapeUtils.unescapeHtml4(value));
    }
}
