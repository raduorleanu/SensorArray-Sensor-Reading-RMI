package sensorReadingServer;

import sensorReadingShared.ISensor;
import sensorReadingShared.Reading;
import sensorReadingShared.SensorDTO;

import java.rmi.RemoteException;
import java.util.*;

public class SensorArray implements ISensorArray {
    private Map<String, RemoteSensor> sensorList = new HashMap<>();
    private String sensorArrayId;

    public SensorArray(String sensorArrayId) {
        this.sensorArrayId = sensorArrayId;
    }

    @Override
    public ISensor registerSensor(String sensorId, Reading reading) throws RemoteException {
        SensorDTO sensorDTO = DAOLocator.getDAO().create(sensorId, reading);
        RemoteSensor sensor = new RemoteSensor(sensorDTO);
        return sensor;
    }

    @Override
    public ISensor getSensorReading(String sensorId) throws RemoteException {
        if (!sensorList.containsKey(sensorId)) {

            sensorList.put(sensorId, new RemoteSensor(DAOLocator.getDAO().readSensor(sensorId)));
        }
        return sensorList.get(sensorId);
    }

    @Override
    public List<ISensor> getAllSensors(String sensorArrayId) throws RemoteException {
        Collection<SensorDTO> allSensors = DAOLocator.getDAO().readAllSensors();
        LinkedList<ISensor> list = new LinkedList<>();
        for (SensorDTO sensor : allSensors) {
            if (!sensorList.containsKey(sensor.getSensorId())) {
                sensorList.put(sensor.getSensorId(), new RemoteSensor(sensor));
            }
            list.add(sensorList.get(sensor.getSensorId()));
        }
        return list;
    }

    @Override
    public void removeSensor(ISensor sensor) throws RemoteException {

    }
}
