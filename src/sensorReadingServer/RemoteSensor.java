package sensorReadingServer;

import sensorReadingShared.ISensor;
import sensorReadingShared.Reading;
import sensorReadingShared.SensorDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteSensor extends UnicastRemoteObject implements ISensor {
    private static final long serialVersionUID = 1L;
    private String sensorId;
    private Reading reading;
    
    public RemoteSensor(SensorDTO sensorDTO) throws RemoteException {
        this(sensorDTO.getSensorId(), sensorDTO.getReading());
    }

    public RemoteSensor(String sensorId, Reading reading) throws RemoteException {
        this.sensorId = sensorId;
        this.reading = reading;
    }

    @Override
    public String getSensorId() throws RemoteException {
        return sensorId;
    }

    @Override
    public Reading getReading() throws RemoteException {
        return reading;
    }

    @Override
    public String toString() {
        return "RemoteSensor{" +
                "sensorId='" + sensorId + '\'' +
                ", reading=" + reading +
                '}';
    }
}
