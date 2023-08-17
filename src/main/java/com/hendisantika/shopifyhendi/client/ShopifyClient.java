package com.hendisantika.shopifyhendi.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Created by IntelliJ IDEA.
 * Project : shopify-hendi
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 8/17/23
 * Time: 09:44
 * To change this template use File | Settings | File Templates.
 */
@Component
@Slf4j
public class ShopifyClient {

    @Value("${shopify.app.hostname}")
    private String storeURL;
    private final WebClient client = WebClient.create(storeURL);
}
