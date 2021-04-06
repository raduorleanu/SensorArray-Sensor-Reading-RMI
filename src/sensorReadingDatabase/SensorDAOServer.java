package sensorReadingDatabase;

import sensorReadingShared.ISensorDAO;
import sensorReadingShared.Reading;
import sensorReadingShared.SensorDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Random;

public class SensorDAOServer extends UnicastRemoteObject implements ISensorDAO {
    private static long serialVersionUID = 1;
    private DatabaseHelper<SensorDTO> helper;
    private Random rand;
    private int sensorIdSeed;

    public SensorDAOServer() throws RemoteException {
        this.helper = new DatabaseHelper<>("jdbc:postgresql://localhost:5432/postgres?currentSchema=public", "postgres", "postgres");
        this.rand = new Random();
        this.sensorIdSeed = 100;
    }

    public SensorDTO createSensor(ResultSet rs) throws RemoteException, SQLException {
        String readingValue = rs.getString("readingValue");
        String measurementUnit = rs.getString("currency");
        int sensorId = sensorIdSeed++;
        SensorDTO result = new SensorDTO(String.valueOf(sensorId), readingValue, readingValue);
        helper.executeUpdate("INSERT INTO sensor VALUES (?, ?)", sensorId, measurementUnit);
        return new SensorDTO(String.valueOf(sensorId), readingValue, measurementUnit);
    }

    public SensorDTO readSensor(String sensorId) throws RemoteException {
        return helper.mapSingle(this::createSensor, "SELECT * FROM sensor WHERE sensor_id = ?", sensorId);
    }

    @Override
    public SensorDTO create(String sensorId, Reading reading) throws RemoteException {
        return null;
    }

    @Override
    public Collection<SensorDTO> readAllSensors() throws RemoteException {
        return null;
    }

    @Override
    public void update(SensorDTO sensor) throws RemoteException {

    }

    @Override
    public void updateSensor(long sensorId) throws RemoteException {

    }

    @Override
    public void deleteSensor(long sensorId) throws RemoteException {

    }

    @Override
    public void deleteSensor(SensorDTO sensor) throws RemoteException {

    }
}
