package com.sarm.swaggerapp.domain.repository;

import com.sarm.swaggerapp.domain.Product;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "product", path = "product")
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}