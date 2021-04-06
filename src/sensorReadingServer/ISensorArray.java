package sensorReadingServer;

import sensorReadingShared.ISensor;
import sensorReadingShared.Reading;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ISensorArray extends Remote {
    ISensor registerSensor(String sensorId, Reading reading) throws RemoteException;

    ISensor getSensorReading(String sensorId) throws RemoteException;

    List<ISensor> getAllSensors(String sensorArrayId) throws RemoteException;

    void removeSensor(ISensor sensor) throws RemoteException;
}
