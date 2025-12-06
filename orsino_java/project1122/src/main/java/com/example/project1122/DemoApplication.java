package com.example.project1122;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/users")
public class DemoApplication {

    private final UserRepository repo;

    // ✅ 建構子注入（最乾淨、最安全）
    public DemoApplication(UserRepository repo) {
        this.repo = repo;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // ✅ C：新增
    @PostMapping
    public User add(@RequestBody User user) {
        return repo.save(user);
    }

    // ✅ R：查全部
    @GetMapping
    public List<User> getAll() {
        return repo.findAll();
    }

    // ✅ R：查單筆
    @GetMapping("/{id}")
    public User getOne(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // ✅ U：更新
    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        user.id = id;
        return repo.save(user);
    }

    // ✅ D：刪除
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}

