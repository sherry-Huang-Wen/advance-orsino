package com.example.project1122;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repo;

    // ✅ 建構子注入（最乾淨、最安全）
    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    // 啟動功能移至 Project1122Application 主類別

    // ✅ C：新增
    @PostMapping
    public Product add(@RequestBody Product Product) {
        return repo.save(Product);
    }

    // ✅ R：查全部
    @GetMapping
    public List<Product> getAll() {
        return repo.findAll();
    }

    // ✅ R：查單筆
    @GetMapping("/{id}")
    public Product getOne(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // ✅ U：更新
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product Product) {
        Product.id = id;
        return repo.save(Product);
    }

    // ✅ D：刪除
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}

