package com.hendisantika.shopifyhendi.client;

import com.hendisantika.shopifyhendi.entity.ShopifyProduct;
import com.hendisantika.shopifyhendi.entity.ShopifyProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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


    @Value("${shopify.auth.X-Shopify-Access-Token}")
    private String ShopifyAccessToken;
    private final WebClient client = WebClient.create(storeURL);

    public Mono<ShopifyProduct> getAllProducts() {
        return client.get()
                .uri("https://hendi-shop.myshopify.com/admin/api/2023-07/products.json")
                .header("X-Shopify-Access-Token", ShopifyAccessToken)
                .retrieve()
                .bodyToMono(ShopifyProduct.class)
                .onErrorResume(ex -> Mono.empty());
    }

    public Mono<ShopifyProductDTO> addNewProduct(ShopifyProductDTO product) {
        return client.post()
                .uri("https://hendi-shop.myshopify.com/admin/api/2023-07/products.json")
                .header("X-Shopify-Access-Token", ShopifyAccessToken)
                .body(Mono.just(product), ShopifyProductDTO.class)
                .retrieve()
                .bodyToMono(ShopifyProductDTO.class);
    }

    public Mono<Void> deleteProductByID(Long productId) {
        return client.delete()
                .uri("https://hendi-shop.myshopify.com/admin/api/2023-07/products/" + productId + ".json")
                .header("X-Shopify-Access-Token", ShopifyAccessToken)
                .retrieve()
                .bodyToMono(Void.class);
    }
}
