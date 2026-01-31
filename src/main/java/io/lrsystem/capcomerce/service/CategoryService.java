package io.lrsystem.capcomerce.service;

import io.lrsystem.capcomerce.dto.CategoryDTO;
import io.lrsystem.capcomerce.dto.ProductDTO;
import io.lrsystem.capcomerce.dto.ProductMinDTO;
import io.lrsystem.capcomerce.entites.Category;
import io.lrsystem.capcomerce.entites.Product;
import io.lrsystem.capcomerce.repositories.CategoryRepository;
import io.lrsystem.capcomerce.repositories.ProductRepository;
import io.lrsystem.capcomerce.service.exceptions.DatabaseException;
import io.lrsystem.capcomerce.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(x -> new CategoryDTO(x)).toList();
    }
}
