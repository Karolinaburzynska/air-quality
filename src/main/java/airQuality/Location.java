package airQuality;

import jakarta.persistence.*;

@Entity
public class Location {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "station_name")
    private String stationName;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;

    @Column(name = "city_id")
    private int cityId;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "province_name")
    private String provinceName;

    public Location(int id,  String stationName, double latitude, double longitude,int cityId, String cityName, String provinceName) {
        this.id = id;
        this.stationName = stationName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cityId = cityId;
        this.cityName = cityName;
        this.provinceName = provinceName;
    }

    public Location() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", stationName='" + stationName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", provinceName='" + provinceName + '\'' +
                '}';
    }
}
