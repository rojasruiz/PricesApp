package com.arojas.pricesapp.application.ports.api;

import com.arojas.pricesapp.domain.model.Price;
import java.time.LocalDateTime;
import java.util.Optional;

public interface PricesAPIService {

    Optional<Price> getPrice(LocalDateTime appDate, Integer productId, Integer brandId);
}
