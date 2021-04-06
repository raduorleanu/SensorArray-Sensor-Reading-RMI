package sensorReadingShared;

import java.io.Serializable;
import java.rmi.RemoteException;

public class SensorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Reading reading;
    private String sensorId;

    public SensorDTO(String sensorId, Reading reading) {
        this.sensorId = sensorId;
        this.reading = reading;
    }

    public SensorDTO(ISensor sensor) throws RemoteException {
        this(sensor.getSensorId(), sensor.getReading());
    }

    public SensorDTO(String sensorId, String readingValue, String measurementUnit) {
        this.sensorId = sensorId;
        this.reading = new Reading(readingValue, measurementUnit);
    }

    public String getSensorId() {
        return sensorId;
    }

    public Reading getReading() {
        return reading;
    }

    @Override
    public String toString() {
        return "SensorDTO{" +
                "reading=" + reading +
                ", sensorId='" + sensorId + '\'' +
                '}';
    }
}
