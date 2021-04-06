package sensorReadingShared;

import java.io.Serializable;

public class Reading implements Serializable {
    private String readingValue;
    private String measurementUnit;
    private String timestamp;

    public Reading(String readingValue, String measurementUnit) {
        this.readingValue = readingValue;
        this.measurementUnit = measurementUnit;
    }

    public String getReading() {
        return readingValue;
    }

    public String getMeasurementUnit()
    {
        return getMeasurementUnit();
    }
}
