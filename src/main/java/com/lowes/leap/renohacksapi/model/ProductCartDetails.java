package com.lowes.leap.renohacksapi.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@NoArgsConstructor
public class ProductCartDetails {


    @JsonProperty
    private int productId;
    @JsonProperty
    private int cartProductId;
    @JsonProperty
    private String productName;
    @JsonProperty
    private String productDescription;
    @JsonProperty
    private String productFeature;
    @JsonProperty
    private Float productPrice;
    @JsonProperty
    private String productModelNo;
    @JsonProperty
    private int productCartQuantity;
}
