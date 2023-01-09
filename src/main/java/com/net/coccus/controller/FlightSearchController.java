package com.net.coccus.controller;

import com.net.coccus.client.dto.SearchDto;
import com.net.coccus.client.dto.SearchLogDto;
import com.net.coccus.client.dto.SearchResponseDto;
import com.net.coccus.services.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class FlightSearchController {

@Autowired
FlightService flightService;


    @PostMapping("/flight/avg")
    public ResponseEntity<?> searchFlight(@Valid  @RequestBody SearchDto searchDto) {
      return new ResponseEntity<List<SearchResponseDto>>(flightService.searchFlight(searchDto), HttpStatus.OK);

    }

    @PostMapping("/flight/list")
    public ResponseEntity<?> listUserResponse() {
        return new ResponseEntity<List<SearchLogDto>>(flightService.listAll(), HttpStatus.OK);
    }

    @PostMapping("/flight/delete")
    public ResponseEntity<?> deleteAllLogs() {
        flightService.deleteAll();
        return new ResponseEntity<String>("Data Sucessfully deleted", HttpStatus.OK);
    }

}
