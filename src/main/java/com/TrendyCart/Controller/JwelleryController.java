package com.TrendyCart.Controller;

import com.TrendyCart.Service.JwelleryService;
import com.TrendyCart.model.JwelleryItem;
import com.TrendyCart.repository.JwelleryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/jewellery")
@CrossOrigin(origins = "http://localhost:8080")
public class JwelleryController {

    @Autowired
    private JwelleryService service;

    @Autowired
    private JwelleryRepository repository;

    // ✅ Create
    @PostMapping
    public ResponseEntity<JwelleryItem> createItem(@RequestBody JwelleryItem item) {
        JwelleryItem saved = repository.save(item);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // ✅ Get all items
    @GetMapping
    public ResponseEntity<List<JwelleryItem>> getAll() {
        return ResponseEntity.ok(service.getAllItems());
    }

    // ✅ Get by ID
    @GetMapping("/{id}")
    public ResponseEntity<JwelleryItem> getItemById(@PathVariable("id") Long id) {
        JwelleryItem item = service.getItemById(id);
        return item != null ? ResponseEntity.ok(item) : ResponseEntity.notFound().build();
    }

    // ✅ Update
    @PutMapping("/{id}")
    public ResponseEntity<JwelleryItem> updateItem(@PathVariable("id") Long id, @RequestBody JwelleryItem item) {
        JwelleryItem updated = service.updateItem(id, item);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // ✅ Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable("id") Long id) {
        boolean deleted = service.deleteJewellery(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // ✅ Patch
    @PatchMapping("/{id}")
    public ResponseEntity<JwelleryItem> patchItem(@PathVariable("id") Long id, @RequestBody Map<String, Object> updates) {
        JwelleryItem patched = service.patchItem(id, updates);
        return patched != null ? ResponseEntity.ok(patched) : ResponseEntity.notFound().build();
    }

    // ✅ Filter by type (Fixed parameter issue)
    @GetMapping("/type/{type}")
    public ResponseEntity<List<JwelleryItem>> getByType(@PathVariable("type") String type) {
        List<JwelleryItem> items = service.getItemsByType(type);
        return ResponseEntity.ok(items);
    }
}
