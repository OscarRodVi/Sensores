package com.example.rv_od.sensores;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements SensorEventListener {
    TextView txt_encabezado;
    RelativeLayout h_fondo;
    int x,y,z;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        h_fondo = (RelativeLayout) findViewById(R.id.h_fondo);
        txt_encabezado = (TextView) findViewById(R.id.txt_encabezado);
        SensorManager sensorOscar = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorOscar.registerListener(this,sensorOscar.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),//sensor. -> salen todos los tipos de sensores
                SensorManager.SENSOR_DELAY_NORMAL);//SensorManager. ->es para la velocidad con la que refresca el sensor (SENSOR_DALY_ FASTER* el mas rapido GAME* para un juego NORMAL*
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        //Toast.makeText(getBaseContext(), "Proximidad"+ sensorEvent.values[0], Toast.LENGTH_LONG).show(); //Toast son los mensajitos inseprados que salen

        x = (int) sensorEvent.values[0];
        y = (int) sensorEvent.values[1];
        z = (int) sensorEvent.values[2];

        txt_encabezado.setText("Valor: "+ x +", "+ y + ", "+ z);
        //if (sensorEvent.values[0]==0)
            h_fondo.setBackgroundColor(Color.rgb(x*20,y*20,z*20));
        //else
        //    h_fondo.setBackgroundColor(Color.CYAN);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
