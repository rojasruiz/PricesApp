package com.arojas.pricesapp.springboot.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class PricesControllerIT {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @DisplayName("Test: Input without result should return 204")
  void givenInputWithoutDataThenReturn204() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/prices/")
            .param("appDate", "2025-02-17T10:00:00")
            .param("productId", "35455")
            .param("brandId", "1"))
        .andExpect(MockMvcResultMatchers.status().isNoContent());
  }

  @Test
  @DisplayName("Test: Input missmatch should return 400")
  void givenInputMissmatchShouldReturn400() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/prices/")
            .param("appDate", "2025-02-17T10:00:00")
            .param("productId", "35455"))
        .andExpect(MockMvcResultMatchers.status().is4xxClientError());
  }

  @Test
  @DisplayName("Test: Price at 10:00 on 2020-06-14 for product 35455 and brand 1 should be 35.5")
  void givenProduct35455AndBrand1AndDate20200614Time10AMShouldReturnPrice35() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/prices/")
            .param("appDate", "2020-06-14T10:00:00")
            .param("productId", "35455")
            .param("brandId", "1"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(6))
        .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
        .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14T00:00:00"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31T23:59:59"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.5));
  }

  @Test
  @DisplayName("Test: Price at 16:00 on 2020-06-14 for product 35455 and brand 1 should be 25.45")
  void givenProduct35455AndBrand1AndDate20200614Time4PMShouldReturnPrice25() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/prices/")
            .param("appDate", "2020-06-14T16:00:00")
            .param("productId", "35455")
            .param("brandId", "1"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(6))
        .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
        .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(2))
        .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14T15:00:00"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-06-14T18:30:00"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(25.45));
  }

  @Test
  @DisplayName("Test: Price at 21:00 on 2020-06-14 for product 35455 and brand 1 should be 35.5")
  void givenProduct35455AndBrand1AndDate20200614Time9PMShouldReturnPrice35() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/prices/")
            .param("appDate", "2020-06-14T21:00:00")
            .param("productId", "35455")
            .param("brandId", "1"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(6))
        .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
        .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14T00:00:00"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31T23:59:59"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.5));
  }

  @Test
  @DisplayName("Test: Price at 10:00 on 2020-06-15 for product 35455 and brand 1 should be 30.5")
  void givenProduct35455AndBrand1AndDate20200615Time10AMShouldReturnPrice30() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/prices/")
            .param("appDate", "2020-06-15T10:00:00")
            .param("productId", "35455")
            .param("brandId", "1"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(6))
        .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
        .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(3))
        .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-15T00:00:00"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-06-15T11:00:00"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(30.5));
  }

  @Test
  @DisplayName("Test: Price at 21:00 on 2020-06-16 for product 35455 and brand 1 should be 38.95")
  void givenProduct35455AndBrand1AndDate20200616Time9PMShouldReturnPrice38() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/prices/")
            .param("appDate", "2020-06-16T21:00:00")
            .param("productId", "35455")
            .param("brandId", "1"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(6))
        .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
        .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(4))
        .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-15T16:00:00"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31T23:59:59"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(38.95));
  }
}
