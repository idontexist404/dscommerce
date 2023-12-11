package com.highlander.dscommerce.services;

import com.highlander.dscommerce.dto.ProductDTO;
import com.highlander.dscommerce.entities.Product;
import com.highlander.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {

        /*Optional<Product> result = repository.findById(id);
        Product product = result.get();
        ProductDTO dto = new ProductDTO(product);
        return dto;*/

        Product product = repository.findById(id).get();
        return new ProductDTO(product);

    }
}
