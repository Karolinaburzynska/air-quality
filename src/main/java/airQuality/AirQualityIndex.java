package airQuality;

import jakarta.persistence.*;

@Entity
public class AirQualityIndex {
    @Id
    private int id;
    private String stIndexLevelName;
    private String so2IndexLevelName;
    private String no2IndexLevelName;
    private String pm10IndexLevelName;
    private String pm25IndexLevelName;
    private String o3IndexLevelName;

    public AirQualityIndex(int id, String stIndexLevelName, String so2IndexLevelName, String no2IndexLevelName, String pm10IndexLevelName, String pm25IndexLevelName, String o3IndexLevelName) {
        this.id = id;
        this.stIndexLevelName = stIndexLevelName;
        this.so2IndexLevelName = so2IndexLevelName;
        this.no2IndexLevelName = no2IndexLevelName;
        this.pm10IndexLevelName = pm10IndexLevelName;
        this.pm25IndexLevelName = pm25IndexLevelName;
        this.o3IndexLevelName = o3IndexLevelName;
    }

    public AirQualityIndex() {
    }

    @Override
    public String toString() {
        return "AirQualityIndex{" +
                "id=" + id +
                ", stIndexLevelName='" + stIndexLevelName + '\'' +
                ", so2IndexLevelName='" + so2IndexLevelName + '\'' +
                ", no2IndexLevelName='" + no2IndexLevelName + '\'' +
                ", pm10IndexLevelName='" + pm10IndexLevelName + '\'' +
                ", pm25IndexLevelName='" + pm25IndexLevelName + '\'' +
                ", o3IndexLevelName='" + o3IndexLevelName + '\'' +
                '}';
    }
}
