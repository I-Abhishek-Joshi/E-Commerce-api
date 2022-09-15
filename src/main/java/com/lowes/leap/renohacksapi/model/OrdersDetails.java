package com.lowes.leap.renohacksapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDetails {
    @JsonProperty
    private int OrdersId;

    @JsonProperty("products_in_orders")
    private List<ProductOrdersDetails> productOrdersDetailsList;
}
