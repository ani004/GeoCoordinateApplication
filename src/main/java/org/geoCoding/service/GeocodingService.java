package org.geoCoding.service;

import org.geoCoding.config.GeoCodeAPIConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GeocodingService {

    private final GeoCodeAPIConfig geoCodeAPIConfig;

    @Autowired
    public GeocodingService(GeoCodeAPIConfig geoCodeAPIConfig) {
        this.geoCodeAPIConfig = geoCodeAPIConfig;
    }

    public double[] getCoordinates(String placeName, String city, String state) {

        if (geoCodeAPIConfig.getBaseUrl() == null) {
            throw new IllegalArgumentException("Nominatim base URL must not be null");
        }

        String url = UriComponentsBuilder.fromHttpUrl(geoCodeAPIConfig.getBaseUrl())
                .queryParam("q", placeName + ", " + city + ","+state)
                .queryParam("format", "json")
                .toUriString();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", geoCodeAPIConfig.getUserAgent());
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<GeoCodeAPIConfigResponse[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, GeoCodeAPIConfigResponse[].class);

        if (response.getBody() != null && response.getBody().length > 0) {
            double lat = Double.parseDouble(response.getBody()[0].getLat());
            double lon = Double.parseDouble(response.getBody()[0].getLon());
            return new double[]{lat, lon};
        } else {
            throw new RuntimeException("Coordinates not found for " + placeName + ", " + city);
        }
    }

    private static class GeoCodeAPIConfigResponse {
        private String lat;
        private String lon;

        public String getLat() { return lat; }
        public void setLat(String lat) { this.lat = lat; }

        public String getLon() { return lon; }
        public void setLon(String lon) { this.lon = lon; }
    }
}
