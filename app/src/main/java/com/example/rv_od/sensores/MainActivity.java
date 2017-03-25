package com.example.rv_od.sensores;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensorOscar = (SensorManager) getSystemService(SENSOR_SERVICE);

        sensorOscar.registerListener(this,sensorOscar.getDefaultSensor(Sensor.TYPE_PROXIMITY),//sensor. -> salen todos los tipos de sensores
                SensorManager.SENSOR_DELAY_GAME);//SensorManager. ->es para la velocidad con la que refresca el sensor (SENSOR_DALY_ FASTER* el mas rapido GAME* para un juego NORMAL*
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Toast.makeText(getBaseContext(), "Proximidad"+ sensorEvent.values[0], Toast.LENGTH_LONG).show();

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
