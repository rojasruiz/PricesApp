package com.arojas.pricesapp.infrastructure.h2.repository;

import com.arojas.pricesapp.infrastructure.h2.entity.PriceEntity;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesRepository extends JpaRepository<PriceEntity, Integer> {

    @Query(value = "SELECT * FROM prices p where ?1 >= p.start_date AND ?1 <= p.end_date AND p.product_id = ?2 AND p.brand_id = ?3 order by p.priority DESC LIMIT 1", nativeQuery = true)
    PriceEntity findPrice(LocalDateTime data, Integer productId, Integer brandId);
}