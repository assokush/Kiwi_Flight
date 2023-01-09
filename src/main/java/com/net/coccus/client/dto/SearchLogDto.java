package com.net.coccus.client.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchLogDto {
    private  String id;
    private String flightFrom;
    private String flightTo;
    private String payload;
}
