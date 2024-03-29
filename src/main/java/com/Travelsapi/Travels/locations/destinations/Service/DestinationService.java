package com.Travelsapi.Travels.locations.destinations.Service;


import com.Travelsapi.Travels.locations.destinations.Repositories.DestinationRepository;
import com.Travelsapi.Travels.locations.destinations.models.Destination;
import com.Travelsapi.Travels.locations.destinations.models.DestinationCsvRepresentation;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DestinationService {

    @Autowired
    private DestinationRepository repository;

    public Destination saveDetails(Destination destination){

        return repository.save(destination);
    }

    public Destination getDestinationDetailsByName(int id){

        return repository.findAllById(int id);
    }

    public Destination updateDetails(Destination destination){

        Destination updateDestination=repository.findByName(destination.getName());
        if(updateDestination!=null){

            updateDestination.setCountry(destination.getCountry());
            updateDestination.setDestinationType(destination.getDestinationType());
            repository.save(updateDestination);

            return updateDestination;
        }
        return null;
    }


    public Integer uploadDestinations(MultipartFile file) throws IOException {

        Set<Destination> destinations = parseCsv(file);
        repository.saveAll(destinations);
        return destinations.size();
    }

    private Set<Destination> parseCsv(MultipartFile file) throws IOException{

        try(Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){
            HeaderColumnNameMappingStrategy<DestinationCsvRepresentation> Strategy = new HeaderColumnNameMappingStrategy<>();
            Strategy.setType(DestinationCsvRepresentation.class);
            CsvToBean<DestinationCsvRepresentation> csvToBean = new CsvToBeanBuilder<DestinationCsvRepresentation>(reader)
                    .withMappingStrategy(Strategy)
                    .withIgnoreEmptyLine(true)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse().stream().map(csvLine -> Destination.builder()
                    .name(csvLine.getName())
                    .destinationType(csvLine.getDestinationType())
                            .country(csvLine.getCountry())
                            .country_id(csvLine.getCountry_id())
                            .parentDestinationName(csvLine.getParentDestinationName())
                            .parentDestinationId(csvLine.getParentDestinationId())
                            .latitude(csvLine.getLatitude())
                            .longitude(csvLine.getLongitude())
                            .createdAt(csvLine.getCreatedAt())
                            .updatedAt(csvLine.getUpdatedAt())
                            .build()
                    ).collect(Collectors.toSet());


        }
    }
}
