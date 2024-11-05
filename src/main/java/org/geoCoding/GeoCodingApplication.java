package org.geoCoding;

import org.geoCoding.config.GeoCodeAPIConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(GeoCodeAPIConfig.class)

public class GeoCodingApplication {
    public static void main(String[] args) {
        SpringApplication.run(GeoCodingApplication.class, args);
    }
}
