package io.lrsystem.capcomerce.controllers;

import io.lrsystem.capcomerce.dto.ProductDTO;
import io.lrsystem.capcomerce.service.ProductServeci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO productDTO) {
        productDTO = productServeci.insert(productDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}")
                .buildAndExpand(productDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(productDTO);
    }

}
