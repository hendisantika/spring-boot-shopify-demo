package com.hendisantika.shopifyhendi.entity;

/**
 * Created by IntelliJ IDEA.
 * Project : shopify-hendi
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 8/17/23
 * Time: 09:36
 * To change this template use File | Settings | File Templates.
 */
public enum InventoryPolicy {

    DENY("deny"), CONTINUE("continue");

    static final String NO_MATCHING_ENUMS_ERROR_MESSAGE = "No matching enum found for %s";
    private final String value;

    InventoryPolicy(final String value) {
        this.value = value;
    }

    public static InventoryPolicy toEnum(String value) {
        if (DENY.toString().equals(value)) {
            return InventoryPolicy.DENY;
        } else if (CONTINUE.toString().equals(value)) {
            return InventoryPolicy.CONTINUE;
        }
        throw new IllegalArgumentException(String.format(NO_MATCHING_ENUMS_ERROR_MESSAGE, value));
    }

    @Override
    public String toString() {
        return value;
    }
}
