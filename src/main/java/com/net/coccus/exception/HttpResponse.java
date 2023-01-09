package com.net.coccus.exception;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
public class HttpResponse {


    private int httpStatusCode;
    private HttpStatus httpStatus;
    private String reason;
    private String message;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="MM-dd-yy hh:mm:ss" ,timezone = "Africa/Lagos")
    private Date timeStamp;


}
