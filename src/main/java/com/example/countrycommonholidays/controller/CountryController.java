package com.example.countrycommonholidays.controller;

import com.example.countrycommonholidays.model.HolidayResponse;
import com.example.countrycommonholidays.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/myperfectapp/{country1}/{country2}/{year}")
    public List<HolidayResponse> getCommonHolidays(@PathVariable String country1, @PathVariable String country2, @PathVariable Integer year) {
        return countryService.getCommonHolidays(country1, country2, year);
    }
}
