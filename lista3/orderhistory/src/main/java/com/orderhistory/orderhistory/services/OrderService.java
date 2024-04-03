package com.orderhistory.orderhistory.services;

import com.orderhistory.orderhistory.models.OrderHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository repository;

    public List<OrderHistory> getAll() {
        return new ArrayList<>(repository.findAll());
    }

    public OrderHistory getById(long id) {
        Optional<OrderHistory> optionalOrder = repository.findById(id);
        if (optionalOrder.isPresent()) {
            return optionalOrder.get();
        } else {
            System.out.println("Order with id " + id + " not found");
            return null;
        }
    }

    public void save(OrderHistory elem) {
        repository.save(elem);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}