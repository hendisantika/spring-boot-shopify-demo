package com.hendisantika.shopifyhendi.entity;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hendisantika.shopifyhendi.util.EscapedStringSerializer;
import com.hendisantika.shopifyhendi.util.EscapedStringsSerializer;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

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
@Slf4j
@Data
public class Option {

    public String id;
    @JsonProperty("product_id")
    public String productId;
    @JsonSerialize(using = EscapedStringSerializer.class)
    public String name;
    public int position;
    @JsonSerialize(using = EscapedStringsSerializer.class)
    public List<String> values;


    /**
     * @param name
     * @param value
     */
    @JsonAnySetter
    public void ignored(String name, Object value) {
        log.debug("ShopifyRestAPI Ignored Property: {} = {}", name, value);
    }
}
