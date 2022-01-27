package com.sha.springbootmicroservice1product.service;

import com.sha.springbootmicroservice1product.dto.ProductDTO;
import com.sha.springbootmicroservice1product.model.Mode;
import com.sha.springbootmicroservice1product.model.Product;

import java.util.List;

public interface IProductService {
    Product saveproduct (Product product);

    ProductDTO saveproductCustom(ProductDTO productDTO);

    ProductDTO updateProductCustom(ProductDTO productDTO);

    void deleteProductCustom(Long id);

    ProductDTO getproductDTO(Long id);

    List<Product> findAllProduct ();

    void deleteproduct (Long idProduct);

    List<Mode> getListTypeOf();

    boolean checkNameExist(String name);
}
