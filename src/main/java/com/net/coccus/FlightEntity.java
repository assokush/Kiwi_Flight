package com.net.coccus;
import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "flight_log")
@Builder
@Data
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column (name = "flight_from")
    private String flightFrom ;
    @Column (name = "flight_to")
    private String flightTo ;
    @Column (name = "response")
    private String response ;
}
