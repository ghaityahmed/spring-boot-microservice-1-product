package com.sha.springbootmicroservice1product.controller;


import com.sha.springbootmicroservice1product.dto.ProductDTO;
import com.sha.springbootmicroservice1product.model.Product;
import com.sha.springbootmicroservice1product.service.implementation.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/product")
public class ProductController {


    @Autowired
    private ProductService productService;

    @PostMapping //  -> api/product
    public ResponseEntity<?> saveProduct (@RequestBody Product product) {
        return new ResponseEntity<> (productService.saveproduct (product), HttpStatus.CREATED);
    }

    @PostMapping("/custom") //  -> api/product
    public ResponseEntity<?> saveProductCustom (@RequestBody ProductDTO productDTO) throws Exception {
         boolean checkName = productService.checkNameExist (productDTO.getName ());
         if(checkName){
             throw new  Exception("The name of object  Product must be unique");
         }
        return new ResponseEntity<> (productService.saveproductCustom (productDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateProductCustom (@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<> (productService.updateProductCustom (productDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}") // -> api/product/id
    public ResponseEntity<?> deleteProduct (@PathVariable Long id) {
        productService.deleteproduct (id);
        return new ResponseEntity<> (HttpStatus.OK);
    }

    @DeleteMapping("/deleteCustom/{id}") // -> api/product/id
    public ResponseEntity<?> deleteProductCustom (@PathVariable Long id) {
        productService.deleteProductCustom (id);
        return new ResponseEntity<> (HttpStatus.OK);
    }

    @GetMapping // -> api/prioduct
    public ResponseEntity<?> getAllproduct () {
        return ResponseEntity.ok (productService.findAllProduct ());
    }


    @GetMapping("/listTypeOf")
    public ResponseEntity<?> getListOfType() {
        return ResponseEntity.ok(productService.getListTypeOf ());
    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id){
        return ResponseEntity.ok(productService.getproductDTO (id));
    }

}

