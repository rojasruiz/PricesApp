package com.arojas.pricesapp.infrastructure.h2.repository;

import com.arojas.pricesapp.infrastructure.h2.entity.PriceEntity;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesRepository extends JpaRepository<PriceEntity, Integer> {

    @Query("SELECT p FROM PriceEntity p where ?1 >= p.startDate AND ?1 <= p.endDate AND p.productId = ?2 AND p.brandId = ?3 order by p.priority DESC")
    List<PriceEntity> findPrices(LocalDateTime data, Integer productId, Integer brandId);
}