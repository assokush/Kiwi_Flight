package com.net.coccus.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.ToString;

import java.util.List;

@lombok.Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDto {
    private String search_id;
    private String currency;
    private String fx_rate;
    private List<Data> data;

}
