package com.net.coccus.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class Durations {

   private String  departure;
   @JsonProperty("return")
   private int returntype;
   private long total;
}
