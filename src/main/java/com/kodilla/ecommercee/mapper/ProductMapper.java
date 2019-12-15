package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ProductMapper {

    public Product mapToProduct(final ProductDto productDto) {

        Product product = new Product(productDto.getName(),
                productDto.getPrice(), productDto.getQuantity());
        product.setId(productDto.getId());
        return product;

    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity()
        );

    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList) {
        return productList.stream()
                .map(this::mapToProductDto)
                .collect(Collectors.toList());
    }
}
