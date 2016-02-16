package com.example.oscar.myambu.Servicios;

import android.Manifest;
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.TextView;

import com.example.oscar.myambu.Mi_ubicacion;

/**
 * Created by oscar on 27/01/16.
 */
public class ServicioGPS extends Service implements LocationListener {

    private Context ctx;
    double miLatirtud;
    double miLongitud;
    Location location;
    boolean gpsActivo;
    LocationManager locationManager;
    TextView texto;

    public ServicioGPS() {
        super();
        this.ctx = this.getApplicationContext();
    }

    public ServicioGPS(Context c) {
        super();
        this.ctx = c;
    }

    public void setView(View v){
        texto = (TextView)v;
        texto.setText("Coordenadas" + miLatirtud + "," + miLongitud);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
