package sensorReadingServer;

import sun.management.Sensor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) throws RemoteException {
        SensorArray sensorArray = new SensorArray("123");
        Remote skeleton = UnicastRemoteObject.exportObject(sensorArray, 8080);
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("SensorArray", skeleton);
    }
}
