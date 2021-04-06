package sensorReadingShared;

import java.io.Serializable;
import java.util.Objects;

// ToDo: decide between VoltageReading and Reading
public final class VoltageReading implements Serializable {
    private static final long serialVersionUID = 1;
    private Double value;
    private String unitOfMeasurement;

    public VoltageReading(Double value, String unitOfMeasurement) {
        this.value = value;
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public double getValue() {
        return value;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoltageReading that = (VoltageReading) o;
        return Objects.equals(value, that.value) &&
                Objects.equals(unitOfMeasurement, that.unitOfMeasurement);
    }

    @Override
    public int hashCode() {
        return value.hashCode() ^ unitOfMeasurement.hashCode();
    }
}