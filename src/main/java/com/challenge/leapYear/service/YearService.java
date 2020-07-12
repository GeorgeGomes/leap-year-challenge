package com.challenge.leapYear.service;

import com.challenge.leapYear.domain.CalculateLeapYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YearService {

    @Autowired
    private CalculateLeapYear calculateLeapYear;

    public boolean calculateLeapYear(long year){
        return calculateLeapYear.calc(year);
    }

}
