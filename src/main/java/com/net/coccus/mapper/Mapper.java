package com.net.coccus.mapper;

import com.net.coccus.FlightEntity;
import com.net.coccus.client.dto.*;




import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public interface Mapper {

   static SearchResponseDto mapRoutToDTO(Route responseDto){

        return  SearchResponseDto.builder()
                .flightTo(responseDto.getCityTo())
                .flighFrom(responseDto.getCityFrom())
                .routId(responseDto.getId())
                .flightNo(responseDto.getFlight_no())
                .name(responseDto.getAirline())
                .build();
    }

    static BagPrice mapbagPrice(ResponseDto response ){
        OptionalDouble aveRagePriceForBagOne = response.getData().stream().filter(data -> data.getBags_price().getOne() != 0).mapToInt(o -> (int) o.getBags_price().getOne() ).average();
        OptionalDouble aveRagePriceForBagTwo = response.getData().stream().filter(data -> data.getBags_price().getTwo() != 0).mapToInt(o -> (int) o.getBags_price().getTwo() ).average();
        return BagPrice.builder()
                .bag1_average(aveRagePriceForBagOne.getAsDouble())
                .bag2_average(aveRagePriceForBagTwo.getAsDouble())
                .build();
    }

     static FlightEntity mapResponseToEntity(String response, SearchDto searchDto){
      /*   byte [] data  =   convertResponseToByte(response);
         JSONParser parser = new JSONParser();
         JSONObject json =null;
         try {
              json = (JSONObject) parser.parse(response.toString());
         } catch (ParseException e) {
             e.printStackTrace();
         }
*/
         return  FlightEntity.builder()
               .flightFrom(searchDto.getFlightFrom())
               .flightTo(searchDto.getFlightTo())
               .response(response)
               .build();
     }

    static byte[] convertResponseToByte(ResponseDto response) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(response);
            oos.flush();
        }catch (Exception e){
            //  e.printStackTrace();
        }
        return bos.toByteArray();
    }

    static List<SearchLogDto>  mapFlightEntityToDto(List<FlightEntity> list){
        List<SearchLogDto> dtoList = new ArrayList<>();
      for(FlightEntity entity : list){
          SearchLogDto searchLogDto = SearchLogDto.builder()
                  .id(String.valueOf(entity.getId()))
                  .flightFrom(entity.getFlightFrom())
                  .flightTo(entity.getFlightTo())
                  .payload(entity.getResponse().toString())
                  .build();
          dtoList.add(searchLogDto);
      }
      return dtoList;
     }
}
