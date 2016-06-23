package com.mcdonalds.repository;

import com.mcdonalds.model.OrderItem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by abondar on 6/18/16.
 */

@RepositoryRestResource(collectionResourceRel = "orderItem", path = "orderItem")
public interface ReportRepository extends PagingAndSortingRepository<OrderItem,Long> {

    @RestResource(path = "byName", rel = "byName")
    List<OrderItem> findByProductName(@Param("productName") String productName);

    @RestResource(path = "countByName", rel = "countByName")
    long countByProductName(@Param("productName") String productName);
}
