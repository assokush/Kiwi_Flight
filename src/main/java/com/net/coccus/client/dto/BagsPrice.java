package com.net.coccus.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BagsPrice {
    @JsonProperty("1")
    private double one;
    @JsonProperty("2")
    private double two;
}
