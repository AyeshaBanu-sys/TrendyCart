package com.TrendyCart.Service;

import com.TrendyCart.model.JwelleryItem;
import com.TrendyCart.repository.JwelleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class JwelleryService {

    @Autowired
    private JwelleryRepository repository;

    public List<JwelleryItem> getAllItems() {
        return repository.findAll();
    }

    public JwelleryItem getItemById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Item not found"));
    }

    public JwelleryItem saveItem(JwelleryItem item) {
        return repository.save(item);
    }

    public JwelleryItem updateItem(Long id, JwelleryItem updatedItem) {
        return repository.findById(id).map(existing -> {
            existing.setName(updatedItem.getName());
            existing.setType(updatedItem.getType());
            existing.setPrice(updatedItem.getPrice());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Item not found with ID: " + id));
    }

    public JwelleryItem patchItem(Long id, Map<String, Object> updates) {
        JwelleryItem item = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Item not found"));

        updates.forEach((key, value) -> {
            try {
                Field field = JwelleryItem.class.getDeclaredField(key);
                field.setAccessible(true);
                field.set(item, value);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Failed to patch field: " + key, e);
            }
        });

        return repository.save(item);
    }

    public boolean deleteJewellery(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<JwelleryItem> getItemsByType(String type) {
        return repository.findByTypeIgnoreCase(type);
    }
}
