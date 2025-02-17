package com.arojas.pricesapp.application.ports.spi;

import com.arojas.pricesapp.domain.model.Price;
import java.time.LocalDateTime;

public interface PricesPersistence {

    Price findPrice(LocalDateTime appDate, Integer productId, Integer brandId);
}
