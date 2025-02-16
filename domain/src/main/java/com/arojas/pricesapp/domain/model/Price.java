package com.arojas.pricesapp.domain.model;

import com.arojas.pricesapp.domain.shared.Entity;
import com.arojas.pricesapp.domain.shared.RootAggregate;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Price extends RootAggregate implements Entity<Price>  {
    private PriceId priceId;
    private BrandId brandId;
    private LocalDateTime startDate;    
    private LocalDateTime endDate;
    private PriceList priceList;
    private ProductId productId;
    private Priority priority;
    private BigDecimal price;
    private Currency cur;

    @Override
    public boolean sameIdentityAs(Price other) {
        return other != null && this.priceId.sameValueAs(other.priceId);
    }
}
