package com.challenge.leapYear.resource;

import com.challenge.leapYear.config.MessagesHandler;
import com.challenge.leapYear.service.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LeapYearController {

    @Autowired
    private YearService yearService;

    @Autowired
    private MessagesHandler messagesHandler;

    @GetMapping(value="/leap-year/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> leapYear(@PathVariable long year){
        boolean leapYear = yearService.calculateLeapYear(year);
        DataReturn dataReturn = new DataReturn();

        if(leapYear)
            dataReturn.message = messagesHandler.get("message.leap-year-yes");
        else
            dataReturn.message = messagesHandler.get("message.leap-year-no");

        return new ResponseEntity(dataReturn, HttpStatus.OK);
    }

}
