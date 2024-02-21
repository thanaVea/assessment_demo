package com.kbtg.bootcamp.posttest.controller;


import com.kbtg.bootcamp.posttest.dto.ProductResponseDTO;
import com.kbtg.bootcamp.posttest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/lotteries")
    public ProductResponseDTO getProductList() throws Exception {
        return this.productService.getAllProduct();
    }
}
