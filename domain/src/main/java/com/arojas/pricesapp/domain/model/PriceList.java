package com.arojas.pricesapp.domain.model;

import com.arojas.pricesapp.domain.shared.ValueObject;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PriceList implements ValueObject<PriceList> {

    private Integer id;

    @Override
    public boolean sameValueAs(PriceList other) {
        return other != null && this.id.equals(other.id);
    }

}
