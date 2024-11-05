package org.geoCoding.controller;

import org.geoCoding.model.Places;
import org.geoCoding.service.PlacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/places")
public class PlaceController {

    private final PlacesService placesService;

    @Autowired
    public PlaceController(PlacesService placesService) {
        this.placesService = placesService;
    }

    @PostMapping("/addPlaces")
    public Places addPlace(@RequestParam String name, @RequestParam String city,
                           @RequestParam String state) {
        return placesService.savePlace(name, city, state);
    }
}
