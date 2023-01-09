package com.net.coccus.client.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchResponseDto {
    private String flightTo;
    private String flighFrom;
    private String flightNo;
    private String routId;
    private String name;
    private String currency;
    private double priceAverage;
    private BagPrice bagPrice;

}
