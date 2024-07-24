package com.highlander.dscommerce.services;

import com.highlander.dscommerce.dto.OrderDTO;
import com.highlander.dscommerce.entities.Order;
import com.highlander.dscommerce.repositories.OrderRepository;
import com.highlander.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found"));
        return new OrderDTO(order);
    }
}
