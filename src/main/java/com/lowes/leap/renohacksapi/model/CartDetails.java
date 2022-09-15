package com.lowes.leap.renohacksapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class CartDetails {

    @JsonProperty
    private int cartId;

    @JsonProperty("products_in_cart")
    private List<ProductCartDetails> productCartDetailsList;
}
