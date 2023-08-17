package com.hendisantika.shopifyhendi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hendisantika.shopifyhendi.client.ShopifyClient;
import com.hendisantika.shopifyhendi.entity.ShopifyProduct;
import com.hendisantika.shopifyhendi.entity.ShopifyProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import java.util.Collections;

/**
 * Created by IntelliJ IDEA.
 * Project : shopify-hendi
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 8/17/23
 * Time: 09:51
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("shopify")
@RequiredArgsConstructor
@Slf4j
public class ShopifyController {
    private final ShopifyClient shopifyClient;

    @Value("${shopify.auth.X-Shopify-Access-Token}")
    private String ShopifyAccessToken;

    @GetMapping("/products")
    public Mono<ShopifyProduct> getAllProducts() {
        log.info("Get All products ...");
        return shopifyClient.getAllProducts();
    }

    @PostMapping("/products")
    public Mono<ShopifyProductDTO> addNewProduct(@RequestBody ShopifyProductDTO shopifyProductDTO) {
        log.info("Add new product ...");
        return shopifyClient.addNewProduct(shopifyProductDTO);
    }

    @GetMapping("/products2")
    public ShopifyProduct getAllProducts2() throws JsonProcessingException {
        log.info("Get All products ...");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> httpEntity = new HttpEntity<>("some body", headers);
        headers.set("X-Shopify-Access-Token", ShopifyAccessToken);
        String storeUrl = "https://hendi-shop.myshopify.com/admin/api/2023-07/products.json";
        ResponseEntity<String> response = restTemplate.exchange(storeUrl, HttpMethod.GET, httpEntity, String.class);
        String resultObject = response.getBody();

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resultObject, ShopifyProduct.class);
    }
}
