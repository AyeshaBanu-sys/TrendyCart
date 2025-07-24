package com.TrendyCart.repository;

import com.TrendyCart.model.JwelleryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JwelleryRepository extends JpaRepository<JwelleryItem, Long> {

    // ✅ Add this method to filter by type/category (e.g., "Necklace")
	List<JwelleryItem> findByTypeIgnoreCase(String type);
}