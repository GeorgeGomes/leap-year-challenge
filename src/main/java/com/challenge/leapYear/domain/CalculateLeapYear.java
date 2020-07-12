package com.challenge.leapYear.domain;

import org.springframework.stereotype.Component;

@Component
public class CalculateLeapYear implements CalculateYear {

    @Override
    public boolean calc(long year) {

        if(year % 400 == 0){
            return true;
        } else if((year % 4 == 0) && (year % 100 != 0)){
            return true;
        }

        return false;
    }
}
