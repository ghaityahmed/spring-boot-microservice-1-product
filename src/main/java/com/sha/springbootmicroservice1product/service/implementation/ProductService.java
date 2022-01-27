package com.sha.springbootmicroservice1product.service.implementation;

import com.sha.springbootmicroservice1product.converter.StringToEnumConverter;
import com.sha.springbootmicroservice1product.dto.ProductDTO;
import com.sha.springbootmicroservice1product.model.Mode;
import com.sha.springbootmicroservice1product.model.Product;
import com.sha.springbootmicroservice1product.repository.IProductRepository;
import com.sha.springbootmicroservice1product.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepository;
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public ProductService (IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveproduct (Product product){
        //product.setCreateTime (LocalDateTime.now ());
        return productRepository.save(product);
    }

    @Override
    public ProductDTO saveproductCustom (ProductDTO productDTO) {
        StringToEnumConverter stringToEnumConverter = new StringToEnumConverter();

        Product product = new Product ();
        product.setName (productDTO.getName ());
        product.setPrice (productDTO.getPrice ());
        product.setTypeOf (stringToEnumConverter.convert (productDTO.getTypeOf ()));
        product.setIsActive (true);
        product.setCreateTime (LocalDateTime.now ());
        product.setUpdateTime (LocalDateTime.now ());
        saveproduct (product);

        /*try {
            boolean  nameUnique = productRepository.existsProductByName (product.getName());
            logger.info ("Query result"+ nameUnique );
             if(nameUnique) {
                throw new Exception ("The name of object pricingCondition must be unique");
             }
            saveproduct (product);
        }catch (Exception e){
           logger.error("System Error:", e.getMessage ());
        }*/

        return productDTO;
    }

    @Override
    public ProductDTO updateProductCustom (ProductDTO productDTO) {
        StringToEnumConverter stringToEnumConverter = new StringToEnumConverter();


        Product productData= productRepository.getById (productDTO.getId ());

        Product product = new Product ();
        product.setId (productDTO.getId ());
        product.setName (productDTO.getName ());
        product.setPrice (productDTO.getPrice ());
        product.setUpdateTime (LocalDateTime.now ());
        product.setCreateTime (productData.getCreateTime ());
        product.setIsActive (productData.getIsActive ());
        product.setTypeOf (stringToEnumConverter.convert (productDTO.getTypeOf ()));
        saveproduct (product);
        return productDTO;
    }

    @Override
    public void deleteProductCustom (Long id) {
        Product productData = productRepository.getById (id);
        Product product = new Product ();
        product.setId (productData.getId ());
        product.setName (productData.getName ());
        product.setPrice (productData.getPrice ());
        product.setUpdateTime (LocalDateTime.now ());
        product.setCreateTime (productData.getCreateTime ());
        product.setIsActive (false);
        product.setTypeOf (productData.getTypeOf ());
        saveproduct (product);
    }

    @Override
    public ProductDTO getproductDTO (Long id) {
        Product productData = productRepository.findProductById (id);
        ProductDTO product = new ProductDTO ();
        product.setId (productData.getId ());
        product.setName (productData.getName ());
        product.setPrice (productData.getPrice ());
        product.setTypeOf (String.valueOf (productData.getTypeOf ()));
        return product;
    }


    @Override
    public List<Product> findAllProduct(){
        return productRepository.findAll ();
    }

    @Override
    public void deleteproduct(Long idProduct){
        productRepository.deleteById (idProduct);
    }

    @Override
    public List<Mode> getListTypeOf () {
        return List.of (Mode.values ());
    }

    @Override
    public boolean checkNameExist (String name) {
        return productRepository.existsProductByName (name);
    }

}
