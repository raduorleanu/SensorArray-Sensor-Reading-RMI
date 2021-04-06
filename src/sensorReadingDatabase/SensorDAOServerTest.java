package sensorReadingDatabase;

import sensorReadingShared.SensorDTO;
import sun.management.Sensor;

import java.rmi.RemoteException;

public class SensorDAOServerTest {
    public static SensorDAOServer sds;

    static {
        try {
            sds = new SensorDAOServer();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static SensorDTO readSensor(String sensorId) {
        SensorDTO x = null;
        try {
            x = sds.readSensor(sensorId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return x;
    }

    public static void main(String[] args) {
        SensorDTO x = readSensor("1");
    }
}
