package com.example.mySpringBoot;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductAPI {
    private List<Product> products = new ArrayList<>();
    private Long id = 0L;

    {
//     초기화 블럭
        products.add(new Product(++id, "프레첼", 7000));
    }

    @PostMapping
    public Product createProduct() {
        Product product = new Product(++id, "상품이름",3000);
        products.add(product);
        return product;
    }

    @GetMapping
    public List<Product> readProducts() {
        return products;
    }

    @GetMapping("/{id}")
    public Product readById(@PathVariable Long id){
        for (Product product : products) {
            if(product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id){
        for (Product product : products) {
            if (product.getId().equals(id)) {
                product.setName("수정된 상품이름");
                product.setPrice(0);
                return product;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        Product removeProduct = null;
        boolean isDelete = false;
        for (Product product : products) {
            if(product.getId().equals(id)){
                removeProduct = product;
                isDelete = true;
                break;
            }
        }
        if(isDelete){
            products.remove(removeProduct);
            return "삭제 되었습니다.";
        }else {
            return "없는 아이디 입니다.";
        }
    }

}
