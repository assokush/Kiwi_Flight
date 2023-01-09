package com.net.coccus.client.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@ToString
public class SearchDto {
    @NotBlank(message = "flightFrom is mandatory")
    private String flightFrom;
    @NotBlank(message = "flightTo is mandatory")
    private String flightTo;
    @NotBlank(message = "AverageFlightPrice is mandatory")
    private String averageFlightPrice;
    @NotBlank(message = "AverageBagAPrice is mandatory")
    private String averageBagAPrice;
    @NotBlank(message = "AverageBagBPrice is mandatory")
    private String averageBagBPrice;
    @NotBlank(message = "Currency is mandatory")
    private String currency;
    @NotBlank(message = "DateFrom is mandatory")
    private String dateFrom;
    @NotBlank(message = "DateTo is mandatory")
    private String dateTo;
    private String airpotName;
}
