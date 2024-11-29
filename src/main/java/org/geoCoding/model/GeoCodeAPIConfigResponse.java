package org.geoCoding.model;

import java.util.List;
public class GeoCodeAPIConfigResponse {

        private long placeId;
        private String licence;
        private String osmType;
        private long osmId;
        private String lat;
        private String lon;
        private String locationClass;
        private String type;
        private int placeRank;
        private double importance;
        private String addresstype;
        private String name;
        private String displayName;
        private List<String> boundingbox;

        // Getters and Setters
        public long getPlaceId() {
            return placeId;
        }

        public void setPlaceId(long placeId) {
            this.placeId = placeId;
        }

        public String getLicence() {
            return licence;
        }

        public void setLicence(String licence) {
            this.licence = licence;
        }

        public String getOsmType() {
            return osmType;
        }

        public void setOsmType(String osmType) {
            this.osmType = osmType;
        }

        public long getOsmId() {
            return osmId;
        }

        public void setOsmId(long osmId) {
            this.osmId = osmId;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public String getLocationClass() {
            return locationClass;
        }

        public void setLocationClass(String locationClass) {
            this.locationClass = locationClass;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getPlaceRank() {
            return placeRank;
        }

        public void setPlaceRank(int placeRank) {
            this.placeRank = placeRank;
        }

        public double getImportance() {
            return importance;
        }

        public void setImportance(double importance) {
            this.importance = importance;
        }

        public String getAddresstype() {
            return addresstype;
        }

        public void setAddresstype(String addresstype) {
            this.addresstype = addresstype;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public List<String> getBoundingbox() {
            return boundingbox;
        }

        public void setBoundingbox(List<String> boundingbox) {
            this.boundingbox = boundingbox;
        }

    @Override
    public String toString() {
        return "GeoCodeAPIConfigResponse{" +
                "lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                '}';
    }

}
