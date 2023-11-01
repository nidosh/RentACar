package com.tobeto.a.spring.intro;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    private List<Product> productList = new ArrayList<>();

    @GetMapping
    public List<Product> getAll()
    {
        System.out.println("alındı. ");
        return productList;
    }

    @PostMapping
    public String add(@RequestBody Product product){
        productList.add(product);
        return "Eklendi";
    }

}
