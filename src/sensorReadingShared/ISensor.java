package sensorReadingShared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISensor extends Remote {
    public String getSensorId() throws RemoteException;
    public Reading getReading() throws RemoteException;
}
