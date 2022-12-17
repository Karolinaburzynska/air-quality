package airQuality;
import jakarta.persistence.*;

@Entity
public class Parameters {

    @Id
    @Column(name = "id")
    private int id;


    @PrimaryKeyJoinColumn(name = "id")
    @Column(name = "station_id")
    private int stationId;

    @Column(name = "parameter_name")
    private String parameterName;

    @Column(name = "parameter_formula")
    private String parameterFormula;

    @Column(name = "parameter_code")
    private String parameterCode;

    @Column(name = "id_parameter")
    private int idParameter;

    public Parameters(String parameterFormula, String parameterCode, int idParameter, String parameterName, int id, int stationId) {
        this.id = id;
        this.stationId = stationId;
        this.parameterName = parameterName;
        this.parameterFormula = parameterFormula;
        this.parameterCode = parameterCode;
        this.idParameter = idParameter;
    }

    public Parameters() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterFormula() {
        return parameterFormula;
    }

    public void setParameterFormula(String parameterFormula) {
        this.parameterFormula = parameterFormula;
    }

    public String getParameterCode() {
        return parameterCode;
    }

    public void setParameterCode(String parameterCode) {
        this.parameterCode = parameterCode;
    }

    public int getIdParameter() {
        return idParameter;
    }

    public void setIdParameter(int idParameter) {
        this.idParameter = idParameter;
    }


    @Override
    public String toString() {
        return "Parameter{" +
                "id=" + id +
                ", stationId=" + stationId +
                ", parameterName='" + parameterName + '\'' +
                ", parameterFormula='" + parameterFormula + '\'' +
                ", parameterCode='" + parameterCode + '\'' +
                ", idParameter=" + idParameter +
                '}';
    }
}



