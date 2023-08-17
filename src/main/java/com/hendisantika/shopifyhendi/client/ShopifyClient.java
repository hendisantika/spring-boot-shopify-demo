package com.hendisantika.shopifyhendi.client;

import com.hendisantika.shopifyhendi.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

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


    @Value("${shopify.app.X-Shopify-Access-Token}")
    private String ShopifyAccessToken;
    private final WebClient client = WebClient.create(storeURL);

    public Flux<Product> getAllProducts() {
        return client.get()
                .uri("/admin/api/2023-07/products.json")
                .header("X-Shopify-Access-Token", ShopifyAccessToken)
                .exchange().flatMapMany(clientResponse -> clientResponse.bodyToFlux(Product.class)).log("Users Fetched :" +
                        " ");
    }
}
