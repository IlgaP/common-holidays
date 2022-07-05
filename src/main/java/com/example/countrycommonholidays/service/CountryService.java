package com.example.countrycommonholidays.service;

import com.example.countrycommonholidays.model.HolidayResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class CountryService {
    private final RestTemplate restTemplate;

    public List<HolidayResponse> getCommonHolidays(String country1, String country2, Integer year) {

       HolidayResponse[] country1Holidays = getHolidays(country1, year);
       HolidayResponse[] country2Holidays = getHolidays(country2, year);
       return commonHolidays(country1Holidays, country2Holidays);
    }

    private HolidayResponse[] getHolidays(String country, Integer year) {

        return restTemplate.getForObject("https://date.nager.at/api/v3/PublicHolidays/"+ year +"/" + country, HolidayResponse[].class);
    }

    private List<HolidayResponse> commonHolidays(HolidayResponse[] country1Holidays, HolidayResponse[] country2Holidays) {

        List<HolidayResponse> holidaysList = new ArrayList<>();
        for (HolidayResponse holiday : country1Holidays ) {
            for (HolidayResponse holiday2 : country2Holidays) {
                if (holiday.getName().equals(holiday2.getName())) {
                    holidaysList.add(holiday);
                }
            }
        }
        return holidaysList;
    }
}
