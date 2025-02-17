package com.arojas.pricesapp.infrastructure.h2.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PricesRepositoryIT {

  @Autowired
  PricesRepository pricesRepository;

  @Test
  public void testFindPrices() {
    var prices = pricesRepository.findPrices(
        LocalDateTime.of(2020,6, 14, 0, 1, 0),
        35455,
        1);
    
    assertThat(prices).isNotEmpty();
  }
}
