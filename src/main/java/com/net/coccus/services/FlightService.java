package com.net.coccus.services;

import com.net.coccus.FlightEntity;
import com.net.coccus.client.KiwiClient;
import com.net.coccus.client.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import static com.net.coccus.mapper.Mapper.*;

@Service
@Slf4j
public class FlightService {
    private final KiwiClient kiwiClient;
    private final com.net.coccus.repo.flightLogRepository flightLogRepository;
    @Autowired
    public FlightService(KiwiClient kiwiClient, com.net.coccus.repo.flightLogRepository flightLogRepository){
        this.kiwiClient = kiwiClient;
        this.flightLogRepository = flightLogRepository;
    }


    public List<SearchLogDto>  listAll(){
        List<FlightEntity>  all = (List<FlightEntity>) flightLogRepository.findAll();
       return  mapFlightEntityToDto(all);

    }

    public void  deleteAll(){
        flightLogRepository.deleteAll();
    }


    public List<SearchResponseDto> searchFlight(SearchDto searchDto){
        ResponseDto response =  kiwiClient.invokeKiwiEndpoint(searchDto);

        BagPrice bagPrice = mapbagPrice(response);
        return mapSearchDto(response, bagPrice, searchDto);
    }

    private List<SearchResponseDto> mapSearchDto(ResponseDto response  , BagPrice bagPrice ,  SearchDto searchDto) {
        List<SearchResponseDto> responseList = new ArrayList<>();
        OptionalDouble averageFlightPrice = response.getData().stream().filter(data -> data.getPrice() != 0).mapToInt(o -> (int) o.getPrice()).average();
        List< List<Route>> dataList = response.getData().stream().filter(data -> data.getRoute().size() > 0).map(Data::getRoute).collect(Collectors.toList());

        for(List<Route> list : dataList){
            for(Route rout : list){
                SearchResponseDto resp =  mapRoutToDTO(rout);
                resp.setPriceAverage(averageFlightPrice.getAsDouble());
                resp.setCurrency(searchDto.getCurrency());
                resp.setBagPrice(bagPrice);
                responseList.add(resp);
            }
        }
       return responseList;
    }


}
