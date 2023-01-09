package com.net.coccus.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Route {
    private String id;
    private String  combination_id;
    private String  flyFrom;
    private String  flyTo;
    private String  cityFrom;
    private String  cityCodeFrom;
    private String  cityTo;
    private String  cityCodeTo;
    private String   dTime;
    private String   dTimeUTC;
    private String   aTime;
    private String   aTimeUTC;
    private String   airline;
    private String   flight_no;
    private String   operating_carrier;
    private String   operating_flight_no;
    private String  fare_basis;
    private String  fare_category;
    private String  fare_classes;
    private String  fare_family;
    @JsonProperty("return")
    private String  returned;
    private String   latFrom;
    private String   lngFrom;
    private String   latTo;
    private String  lngTo;
    private String  mapIdfrom;
    private String  mapIdto;
    private String  bags_recheck_required;
    private String  vi_connection;
    private String  guarantee;
    private String  equipment;
    private String  vehicle_type;
    private String  original_return;
}
