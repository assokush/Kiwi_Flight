package com.net.coccus.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Baglimit {
    private int hand_height;
    private int hand_length;
    private int and_weight;
    private int  hand_width;
    private int  hold_dimensions_sum;
    private int  hold_height;
    private int  hold_length;
    private int   hold_weight;
    private int   hold_width;
    private int   personal_item_height;
    private int   personal_item_length;
    private int   personal_item_weight;
    private int   personal_item_width;
}
