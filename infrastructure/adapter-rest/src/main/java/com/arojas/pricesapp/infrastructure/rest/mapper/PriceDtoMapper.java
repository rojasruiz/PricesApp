package com.arojas.pricesapp.infrastructure.rest.mapper;

import com.arojas.pricesapp.domain.model.Price;
import com.arojas.pricesapp.infrastructure.rest.dto.PriceResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring") 
public interface PriceDtoMapper {
    
    @Mapping(source = "productId.id", target = "productId")
    @Mapping(source = "brandId.id", target = "brandId")
    @Mapping(source = "priceList.id", target = "priceList")
    PriceResponseDto toDto(Price prop);
}
