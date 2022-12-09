package airQuality;

import jakarta.persistence.*;

@Entity
public class Measurement {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn(name = "id")
    private Integer id;

    @Column(name = "date")
    private String date;

    private double value;

    public Measurement(String date, double value) {
        this.date = date;
        this.value = value;
    }

    public Measurement(Integer id, String date, double value) {
        this.id = id;
        this.date = date;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", value=" + value +
                '}';
    }
}
