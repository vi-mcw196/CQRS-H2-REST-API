package com.orderservice.orderservice.services;

import com.orderservice.orderservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements CustomService<Product> {
    @Autowired
    ProductRepository repository;

    public List<Product> getAll() {
        List<Product> elems = new ArrayList<>();
        repository.findAll().forEach(elems::add);
        return elems;
    }

    public Product getById(long id) {
        return repository.findById(id).get();
    }

    public void save(Product elem) {
        repository.save(elem);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}