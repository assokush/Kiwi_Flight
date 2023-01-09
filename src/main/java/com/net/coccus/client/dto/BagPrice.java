package com.net.coccus.client.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BagPrice {
    private Double bag1_average;
    private Double bag2_average;
}
