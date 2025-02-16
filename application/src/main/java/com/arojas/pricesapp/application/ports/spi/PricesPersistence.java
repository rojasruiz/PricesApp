package com.arojas.pricesapp.application.ports.spi;

import com.arojas.pricesapp.domain.model.Price;
import java.time.LocalDateTime;
import java.util.List;

public interface PricesPersistence {

    List<Price> findPrices(LocalDateTime appDate, Integer productId, Integer brandId);
}
