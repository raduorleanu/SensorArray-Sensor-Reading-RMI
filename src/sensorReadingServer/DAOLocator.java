package sensorReadingServer;

import sensorReadingShared.SensorDAO;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DAOLocator {
    public static SensorDAO getDAO() throws RemoteException {
        Registry registry = LocateRegistry.getRegistry(1099);
        try {
            return (SensorDAO) registry.lookup("senorDAO");
        } catch (NotBoundException e) {
            throw new RemoteException(e.getMessage(), e);
        }
    }
}
