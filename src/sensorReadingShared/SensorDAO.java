package sensorReadingShared;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

public interface SensorDAO extends Remote {
    public SensorDTO create(String sensorId, Reading reading) throws RemoteException;

    public SensorDTO readSensor(String sensorId) throws RemoteException;

    public Collection<SensorDTO> readAllSensors() throws RemoteException;

    // Overwrite (updates) the SensorDTO on the server with the RemoteSensor (changes) from the client
    public void update(SensorDTO sensor) throws RemoteException;

    public void updateSensor(String sensorId, Reading reading) throws RemoteException;

    public void deleteSensor(String sensorId) throws RemoteException;


}
