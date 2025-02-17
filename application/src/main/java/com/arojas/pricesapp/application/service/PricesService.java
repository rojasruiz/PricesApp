package com.arojas.pricesapp.application.service;

import com.arojas.pricesapp.application.ports.api.PricesAPIService;
import com.arojas.pricesapp.application.ports.spi.PricesPersistence;
import com.arojas.pricesapp.domain.model.Price;
import java.time.LocalDateTime;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@Transactional
public class PricesService implements PricesAPIService {

  PricesPersistence pricesRepository;

  @Override
  public Optional<Price> getPrice(LocalDateTime appDate, Integer productId, Integer brandId) {
    return Optional.ofNullable(pricesRepository.findPrice(appDate, productId, brandId));
  }
}
