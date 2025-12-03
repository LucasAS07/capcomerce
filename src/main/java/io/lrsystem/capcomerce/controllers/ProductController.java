package io.lrsystem.capcomerce.controllers;

import io.lrsystem.capcomerce.dto.ProductDTO;
import io.lrsystem.capcomerce.service.ProductService;
import io.lrsystem.capcomerce.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable) {
        Page<ProductDTO> dto = productService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> listId(@PathVariable Long id) {
        ProductDTO dto = productService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO productDTO) {
        productDTO = productService.insert(productDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}")
                .buildAndExpand(productDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(productDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO product) {
            product = productService.update(id,product);

            return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
