package org.geoCoding.service;

import org.geoCoding.model.Places;
import org.geoCoding.repository.PlacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlacesService {

    private final PlacesRepository placeRepository;
    private final GeocodingService geocodingService;

    @Autowired
    public PlacesService(PlacesRepository placeRepository, GeocodingService geocodingService) {
        this.placeRepository = placeRepository;
        this.geocodingService = geocodingService;
    }

    public Places savePlace(String name, String city, String state) {
        double[] coordinates = geocodingService.getCoordinates(name, city, state);
        Places place = new Places(name, city, state, coordinates[0], coordinates[1]);
        return placeRepository.save(place);
    }
}
