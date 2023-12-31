package com.hendisantika.shopifyhendi.entity;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hendisantika.shopifyhendi.util.EscapedStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * Project : shopify-hendi
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 8/17/23
 * Time: 09:27
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String id;

    @JsonSerialize(using = EscapedStringSerializer.class)
    private String title;

    @JsonProperty("product_type")
    private String productType;

    @JsonProperty("body_html")
    @JsonSerialize(using = EscapedStringSerializer.class)
    private String bodyHtml;

    @JsonSerialize(using = EscapedStringSerializer.class)
    private String vendor;

//    @JsonSerialize(using = TagsSerializer.class)
//    @JsonDeserialize(using = TagsDeserializer.class)
//    @JsonProperty("tags")
//    private Set<String> tags = new HashSet<>();

    private List<Option> options = new LinkedList<>();

    @JsonProperty("metafields_global_title_tag")
    private String metafieldsGlobalTitleTag;

    @JsonProperty("metafields_global_description_tag")
    private String metafieldsGlobalDescriptionTag;
    private List<Image> images = new LinkedList<>();
    private Image image;
    private List<Variant> variants = new LinkedList<>();

    @JsonProperty("published_at")
    private String publishedAt;
    private Boolean published;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonProperty("published_scope")
    private String publishedScope;
    private String handle;

    @JsonProperty("template_suffix")
    private String templateSuffix;
    private String status;

    @JsonProperty("admin_graphql_api_id")
    private String adminGraphqlApiId;

    /**
     * @return Boolean
     */
    public Boolean isPublished() {
        return (published == null) ? StringUtils.isNotBlank(publishedAt) : published;
    }


    /**
     * @return List<String>
     */
    public List<String> getSortedOptionNames() {
        final Comparator<Option> optionPositionCompartor = new Comparator<Option>() {
            @Override
            public int compare(final Option o1, final Option o2) {
                return o1.getPosition() - o2.getPosition();
            }
        };
        return options.stream().sorted(optionPositionCompartor).map(Option::getName).collect(Collectors.toList());
    }


    /**
     * @param name
     * @param value
     */
    @JsonAnySetter
    public void ignored(String name, Object value) {
        log.debug("ShopifyRestAPI Ignored Property: {} = {}", name, value);
    }
}
