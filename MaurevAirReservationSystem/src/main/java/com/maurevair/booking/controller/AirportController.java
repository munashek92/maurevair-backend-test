package com.maurevair.booking.controller;

import com.maurevair.booking.entity.Flights;
import com.maurevair.booking.helper.Helper;
import com.maurevair.booking.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @PostMapping("/airport/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        if (Helper.checkExcelFormat(file)) {
            //true

            this.airportService.save(file);

            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));


        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
    }


    @GetMapping("/airport")
    public List<Flights> getAllAirports() {
        return this.airportService.getAllAirports();
    }

}
