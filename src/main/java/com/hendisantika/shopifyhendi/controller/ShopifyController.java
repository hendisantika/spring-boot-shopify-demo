package com.hendisantika.shopifyhendi.controller;

import com.hendisantika.shopifyhendi.client.ShopifyClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class ShopifyController {
    private final ShopifyClient shopifyClient;


}
