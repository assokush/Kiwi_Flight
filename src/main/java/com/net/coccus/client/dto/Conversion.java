package com.net.coccus.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Conversion {
    @JsonProperty("EUR")
  private double  euro ;
    @JsonProperty("GBP")
  private double  gbp ;
}
