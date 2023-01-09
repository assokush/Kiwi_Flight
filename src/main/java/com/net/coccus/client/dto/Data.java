package com.net.coccus.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    private String id;
    private String flyFrom;
    private String flyTo;
    private String cityFrom;
    private String cityCodeFrom;
    private String cityTo;
    private String cityCodeTo;
    private  Country countryFrom;
    private  Country countryTo;
    private String dTime;
    private String dTimeUTC;
    private String  aTime;
    private String  aTimeUTC;
    private String nightsInDest;
    private String  quality;
    private String distance;
    private Durations duration;
    private int fx_rate;

    private String fly_duration;
    private double price;
    private Conversion conversion;
   private Fare fare;
   private PriceDropDown price_dropdown;
      private BagsPrice bags_price;
    private Baglimit baglimit;

  private List<Route> route;

}
