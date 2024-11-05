package org.geoCoding.repository;

import org.geoCoding.model.Places;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlacesRepository extends MongoRepository<Places, String> {
}
