package com.example.countrycommonholidays.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HolidayResponse {

    private String date;
    private String name;

    public HolidayResponse() {
    }
}
