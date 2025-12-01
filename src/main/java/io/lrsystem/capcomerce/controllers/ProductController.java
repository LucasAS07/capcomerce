package io.lrsystem.capcomerce.controllers;

import io.lrsystem.capcomerce.dto.ProductDTO;
import io.lrsystem.capcomerce.service.ProductServeci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServeci productServeci;

    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable) {
        return productServeci.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ProductDTO listId(@PathVariable Long id) {
        ProductDTO dto = productServeci.findById(id);
        return dto;
    }

}
