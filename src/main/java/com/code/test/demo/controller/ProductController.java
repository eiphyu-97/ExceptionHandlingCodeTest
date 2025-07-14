package com.code.test.demo.controller;

import com.code.test.demo.domain.Product;
import com.code.test.demo.exception.product.InvalidProductException;
import com.code.test.demo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public String createProduct(@RequestBody  @Valid Product product , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String message = getErrorMessageDetails(bindingResult);
            throw new InvalidProductException(message);
        }
        productService.create(product);
        return "Created successfully";
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") int productId){
        System.out.println("Product id => "+productId);
        return productService.getProductById(productId);
    }

    @PutMapping("/{id}")
    public Product update(@RequestBody @Valid Product product, @PathVariable("id") int productId,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String message = getErrorMessageDetails(bindingResult);
            throw new InvalidProductException(message);
        }
       return productService.update(product,productId);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int productId){
        productService.deleteById(productId);
        return "Deleted Successfully";
    }

    private String getErrorMessageDetails(BindingResult bindingResult){
        return bindingResult.getFieldErrors().stream().map(result -> result.getDefaultMessage())
                .collect(Collectors.joining(" , "));
    }

}
