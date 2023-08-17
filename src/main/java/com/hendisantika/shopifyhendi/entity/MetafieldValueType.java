package com.hendisantika.shopifyhendi.entity;

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
public enum MetafieldValueType {
    STRING("string"), INTEGER("integer");

    static final String NO_MATCHING_ENUMS_ERROR_MESSAGE = "No matching enum found for %s";
    private final String value;

    MetafieldValueType(final String value) {
        this.value = value;
    }

    public static MetafieldValueType toEnum(final String value) {
        if (STRING.toString().equals(value)) {
            return MetafieldValueType.STRING;
        } else if (INTEGER.toString().equals(value)) {
            return MetafieldValueType.INTEGER;
        }
        throw new IllegalArgumentException(String.format(NO_MATCHING_ENUMS_ERROR_MESSAGE, value));
    }

    @Override
    public String toString() {
        return value;
    }
}
