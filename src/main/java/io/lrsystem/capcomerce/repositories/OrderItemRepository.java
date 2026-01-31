package io.lrsystem.capcomerce.repositories;

import io.lrsystem.capcomerce.entites.OrderItem;
import io.lrsystem.capcomerce.entites.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
