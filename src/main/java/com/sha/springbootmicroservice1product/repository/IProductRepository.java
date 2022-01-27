package com.sha.springbootmicroservice1product.repository;

import com.sha.springbootmicroservice1product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository<Product, Long> {

    Product findProductById(Long id);

    boolean existsProductByName(String name);

    @Query("select case when count(p)> 0 then true else false end from Product p where lower(p.name) like lower(:name)")
    boolean existsProductLikeCustomQuery(@Param("name") String name);
}