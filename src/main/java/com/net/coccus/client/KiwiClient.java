package com.net.coccus.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.net.coccus.client.dto.ResponseDto;
import com.net.coccus.client.dto.SearchDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.net.coccus.mapper.Mapper.mapResponseToEntity;

@Slf4j
@Component
public class KiwiClient {
    private final RestTemplate restTemplate;
    private final String kiwiUrl;
    private final com.net.coccus.repo.flightLogRepository flightLogRepository;

    @Autowired
    public KiwiClient(RestTemplate restTemplate, @Value("${kiwi.url}") final String kiwiUrl, com.net.coccus.repo.flightLogRepository flightLogRepository) {
        this.restTemplate = restTemplate;
        this.kiwiUrl = kiwiUrl;
        this.flightLogRepository = flightLogRepository;
    }

    public ResponseDto invokeKiwiEndpoint(final SearchDto searchDto) {
        ResponseDto message = null;
        URI restURI = null;
        ResponseEntity<String> response = null;
        try {
            restURI = getFlightURI(searchDto);
            response = restTemplate.getForEntity(restURI, String.class);
            flightLogRepository.save(mapResponseToEntity(response.getBody(), searchDto));
            message = new ObjectMapper().readValue(response.getBody(), ResponseDto.class);
           //log.info("MAPPED {} ", message.toString());
        } catch (Exception ex) {
            String errMsg = String.format("Failed to retrieve flight schedule");
          //  throw new RestClientException(errMsg, ex, restURI, response);
        }
        return message;
    }


    private URI getFlightURI(SearchDto searchDto) throws RestClientException {
        String dateFrom = validateDate(searchDto.getDateFrom());

        String dateTo = validateDate(searchDto.getDateTo());
        String urlString = String.format("?flyFrom=%s&to=%s&partner=kiwicocuskiwicocus&dateFrom=%s&dateTo=%s&curr=%s", searchDto.getFlightFrom(), searchDto.getFlightTo()
        ,dateFrom , dateTo, searchDto.getCurrency());
        URI uri = null;
        String urlWithAirpotCode = null;

        try {
            String urlText = String.format("%s/flights%s", kiwiUrl, urlString);
            if(searchDto.getAirpotName() != null ) {
                urlWithAirpotCode = String.format(urlText.concat("&v=%s"), searchDto.getAirpotName());
                uri = new URI(urlWithAirpotCode);
                return  uri;
            }
            uri = new URI(urlText);
        } catch ( URISyntaxException ex) {
            throw new RestClientException(String.format("Failed to generate URI for endpoint"));
        }
        return uri;
    }

    private String validateDate(String dateTo) {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        try {
            date = df.parse(dateTo);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
        return  df1.format(date);
    }


}
