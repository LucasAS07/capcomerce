package io.lrsystem.capcomerce.repositorys;

import io.lrsystem.capcomerce.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
