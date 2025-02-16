package com.arojas.pricesapp.infrastructure.rest.controller;

import com.arojas.pricesapp.application.ports.api.PricesAPIService;
import com.arojas.pricesapp.domain.model.Price;
import com.arojas.pricesapp.infrastructure.rest.dto.PriceResponseDto;
import com.arojas.pricesapp.infrastructure.rest.mapper.PriceDtoMapper;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@CrossOrigin()
@RequestMapping("/api/v1/prices")
@Tag(name = "Prices", description = "Prices main controller")
@Slf4j
public class PricesController {

        PricesAPIService apiService;

        PriceDtoMapper propMapper;

        @GetMapping("/")
        @ApiResponse(responseCode = "200", description = "Price found", content = @Content(mediaType = "application/json", schema = @Schema(type = "object", implementation = PriceResponseDto.class)))
        @ApiResponse(responseCode = "204", description = "No price found for this input", content = @Content(mediaType = "application/json"))
        public ResponseEntity<PriceResponseDto> getPrices(@RequestParam @DateTimeFormat(iso = ISO.DATE_TIME) final LocalDateTime appDate, @RequestParam Integer productId,
                        @RequestParam Integer brandId) {
                
                Optional<Price> price = apiService.getPrice(appDate, productId, brandId);

                return price.map(c -> ResponseEntity.ok().body(propMapper.toDto(c)))
                            .orElse(ResponseEntity.noContent().build());                
        }
}