package com.orderservice.orderservice;

import com.orderservice.orderservice.models.*;
import com.orderservice.orderservice.services.DeliveryRepository;
import com.orderservice.orderservice.services.OrderItemRepository;
import com.orderservice.orderservice.services.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;

@Component
public class Seeder {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Bean
    void LoadData() {
        var toy1 = new Product("toy 1", new BigDecimal(140));
        var toy2 = new Product("toy 2", new BigDecimal(90));
        productRepository.saveAll(new ArrayList<>(){
            {
                add(toy1);
                add(toy2);
                add(new Product("toy 3", new BigDecimal(99)));
            }
        });
        var items = new ArrayList<OrderItem>() {
            {
                add(new OrderItem(toy1, 2));
                add(new OrderItem(toy2, 3));
            }
        };
        orderItemRepository.saveAll(items);
        var created = new Delivery("Viktor Moldovan", DeliveryStatus.Created);
        deliveryRepository.saveAll(new ArrayList<>(){
            {
                add(created);
            }
        });
    }
}
