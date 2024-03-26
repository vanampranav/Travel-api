package com.Travelsapi.Travels.Destination.Controller;


import com.Travelsapi.Travels.Destination.Service.DestinationService;
import com.Travelsapi.Travels.Destination.models.Destination;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/destinations")
@RequiredArgsConstructor
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @PostMapping
    public Destination postDetails(@RequestBody Destination destination){

        return destinationService.saveDetails(destination);
    }

    @GetMapping
    public Destination getDetailsByName(@PathVariable String name){

        return destinationService.getDestinationDetailsByName(name);
    }

    @PatchMapping
    public Destination updateDestinationDetails(@RequestBody Destination destination){

        return destinationService.updateDetails(destination);
    }

    @PostMapping(value = "/upload", consumes = {"multipart/form-data"})
    public ResponseEntity<Integer> uploadDestinations(@RequestPart("file")MultipartFile file) throws IOException{
        return ResponseEntity.ok(destinationService.uploadDestinations(file));
    }


}
