package com.maurevair.booking.service;

import com.maurevair.booking.entity.Flights;
import com.maurevair.booking.helper.Helper;
import com.maurevair.booking.repo.AirportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class AirportService {

    @Autowired
    private AirportRepo airportRepo;

    public void save(MultipartFile file) {

        try {
            List<Flights> airports = Helper.convertExcelToListOfProduct(file.getInputStream());
            this.airportRepo.saveAll(airports);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Flights> getAllAirports() {
        return this.airportRepo.findAll();
    }


}
