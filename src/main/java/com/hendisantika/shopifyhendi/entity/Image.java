package com.hendisantika.shopifyhendi.entity;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hendisantika.shopifyhendi.util.EscapedStringSerializer;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : shopify-hendi
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 8/17/23
 * Time: 11:32
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Data
public class Image {
    private String id;
    @JsonProperty("product_id")
    private String productId;
    @JsonSerialize(using = EscapedStringSerializer.class)
    private String name;
    private int position;
    @JsonProperty("src")
    private String source;
    @JsonProperty("variant_ids")
    private List<String> variantIds = new LinkedList<>();
    private List<Metafield> metafields = new LinkedList<>();


    /**
     * @param name
     * @param value
     */
    @JsonAnySetter
    public void ignored(String name, Object value) {
        log.debug("ShopifyRestAPI Ignored Property: {} = {}", name, value);
    }
}
