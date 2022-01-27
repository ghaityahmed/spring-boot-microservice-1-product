package com.sha.springbootmicroservice1product.converter;

import com.sha.springbootmicroservice1product.model.Mode;
import org.springframework.core.convert.converter.Converter;


public class StringToEnumConverter implements Converter<String, Mode> {

    @Override
    public Mode convert(String from) {
        return Mode.valueOf(from.toUpperCase());
    }
}
