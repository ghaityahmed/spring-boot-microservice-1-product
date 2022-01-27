package com.sha.springbootmicroservice1product.dto;

import com.sha.springbootmicroservice1product.model.Mode;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ProductDTO  implements Serializable
{

    private Long id;
    private String name;

    private Double price;

    private String typeOf;

}
