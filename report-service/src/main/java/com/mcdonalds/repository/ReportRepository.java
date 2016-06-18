package com.mcdonalds.repository;

import com.mcdonalds.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by abondar on 6/18/16.
 */

@RepositoryRestResource(collectionResourceRel = "orderItem", path = "orderItem")

public interface ReportRepository extends JpaRepository<OrderItem,Long> {
}
