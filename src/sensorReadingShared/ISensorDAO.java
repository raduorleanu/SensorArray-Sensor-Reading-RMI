package sensorReadingShared;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

public interface ISensorDAO extends Remote {
//    public SensorDTO createSensor(String sensorId, Reading reading) throws RemoteException;
    public SensorDTO create(String sensorId, Reading reading) throws RemoteException;

    public Collection<SensorDTO> readAllSensors() throws RemoteException;

    // Overwrite the SensorDTO on the server with the RemoteSensor from the client
    public void update(SensorDTO sensor) throws RemoteException;

    public void updateSensor(long sensorId) throws RemoteException;

    public void deleteSensor(long sensorId) throws RemoteException;

    public void deleteSensor(SensorDTO sensor) throws RemoteException;
}

