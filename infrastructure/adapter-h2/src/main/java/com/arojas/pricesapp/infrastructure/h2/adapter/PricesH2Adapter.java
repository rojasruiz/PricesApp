package com.arojas.pricesapp.infrastructure.h2.adapter;

import com.arojas.pricesapp.application.ports.spi.PricesPersistence;
import com.arojas.pricesapp.domain.model.Price;
import com.arojas.pricesapp.infrastructure.h2.mapper.PriceDboMapper;
import com.arojas.pricesapp.infrastructure.h2.repository.PricesRepository;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class PricesH2Adapter implements PricesPersistence {
    
    PricesRepository pricesRepository;
    PriceDboMapper priceMapper;

    @Override
    public Price findPrice(LocalDateTime appDate, Integer productId, Integer brandId) {
        return priceMapper.toDomain(pricesRepository.findPrice(appDate, productId, brandId));
    }
}
