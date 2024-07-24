package com.highlander.dscommerce.repositories;

import com.highlander.dscommerce.entities.OrderItem;
import com.highlander.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
