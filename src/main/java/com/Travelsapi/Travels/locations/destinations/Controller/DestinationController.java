package com.Travelsapi.Travels.locations.destinations.Controller;


import com.Travelsapi.Travels.locations.destinations.Service.DestinationService;
import com.Travelsapi.Travels.locations.destinations.models.Destination;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/destinations")
@RequiredArgsConstructor
public class DestinationController {
    @Autowired
    private DestinationService destinationService;

    @PostMapping("/post")
    public Destination postDetails(@RequestBody Destination destination) {
        return destinationService.saveDetails(destination);
    }

    @GetMapping("/{name}")
    public Destination getByName(@PathVariable String name) {
       return destinationService.getDestinationDetailsByName(name);
    }

    //ToDo: getById

    @PutMapping("/{name}")
    public Destination updateDestinationDetails(@RequestBody Destination destination) {
        return destinationService.updateDetails(destination);
    }

    @PostMapping(value = "/upload", consumes = {"multipart/form-data"})
    public ResponseEntity<Integer> uploadDestinations(@RequestPart("file")MultipartFile file) throws IOException {
        return ResponseEntity.ok(destinationService.uploadDestinations(file));
    }

    // ToDo: Do not allow null values in Destinations table
}
