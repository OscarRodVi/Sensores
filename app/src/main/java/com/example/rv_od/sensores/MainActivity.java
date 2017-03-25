package com.example.rv_od.sensores;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements SensorEventListener {
    TextView txt_encabezado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_encabezado = (TextView) findViewById(R.id.txt_encabezado);

        SensorManager sensorOscar = (SensorManager) getSystemService(SENSOR_SERVICE);

        sensorOscar.registerListener(this,sensorOscar.getDefaultSensor(Sensor.TYPE_PROXIMITY),//sensor. -> salen todos los tipos de sensores
                SensorManager.SENSOR_DELAY_GAME);//SensorManager. ->es para la velocidad con la que refresca el sensor (SENSOR_DALY_ FASTER* el mas rapido GAME* para un juego NORMAL*
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        //Toast.makeText(getBaseContext(), "Proximidad"+ sensorEvent.values[0], Toast.LENGTH_LONG).show(); //Toast son los mensajitos inseprados que salen

        txt_encabezado.setText("Valor: "+ sensorEvent.values[0]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
