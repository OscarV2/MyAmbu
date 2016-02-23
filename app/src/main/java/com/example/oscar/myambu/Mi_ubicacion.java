package com.example.oscar.myambu;

import android.Manifest;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.view.Menu;


public class Mi_ubicacion extends AppCompatActivity implements LocationListener {

    //    LatLng myPosition;
    GoogleMap mMap;
    //private Location location;
    //private int vista = 0;
   // double latitud;
  //  double longitud;
    private LocationManager locationManager;
    private LocationListener locationListener;
Location loc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_ubicacion);
        mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();   // Obtener referencia al fragment map
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);  //
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);        //declarar tipo de mapa
        mMap.setMyLocationEnabled(true);                    //Habilitar mi posicion

        //VERIFICANDO PERMISOS PARA GPS, UBICACION POR RED Y POR IP
        if (locationManager.isProviderEnabled(LocationManager.PASSIVE_PROVIDER)) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            loc = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER); // Obtener ultima ubicacion del Provider seleccionado
        }

//Obteniendo latitud y longitud de mi ultima posicion
        LatLng miPosicion = new LatLng(loc.getLatitude(),loc.getLongitude());

CameraPosition campos = new CameraPosition.Builder()
        .target(miPosicion)
        .zoom(16)
        .build();

CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(campos);
mMap.animateCamera(cameraUpdate);
        mMap.addMarker(new MarkerOptions()
                .position(miPosicion)
                .title("Mi posicion"));


        //mMap.setOnMapClickListener(this);
//        mMap.addMarker(new MarkerOptions());

/*
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Toast.makeText(Mi_ubicacion.this, "gps desactivado", Toast.LENGTH_SHORT).show();
        }
*/



        locationListener = new LocationListener() {



            @Override
            public void onLocationChanged(Location location) {

       /*   LatLng latLng = new LatLng(location.getLatitude(),location.getLongitude());
                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(
                        latLng, 15);
                mMap.animateCamera(cameraUpdate);
                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("Current Location(You)")
                        .snippet("Current")
                        .draggable(true));
*/
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
        };
    }

//METODOS DE LocationListener
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


/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.menu_vista:
                alternarVista();
                break;
            case R.id.menu_mover:
                //Centramos el mapa en España
                CameraUpdate camUpd1 =
                        CameraUpdateFactory.newLatLng(new LatLng(10.41, -73.69));
                mMap.moveCamera(camUpd1);
                break;
            case R.id.menu_animar:
                //Centramos el mapa en España y con nivel de zoom 5
                CameraUpdate camUpd2 =
                        CameraUpdateFactory.newLatLngZoom(new LatLng(10.41, -73.69), 5F);
                mMap.animateCamera(camUpd2);
                break;
            case R.id.menu_3d:
                LatLng Valle = new LatLng(10.417325, -73.683081);
                CameraPosition camPos = new CameraPosition.Builder()
                        .target(Valle)   //Centramos el mapa en Madrid
                        .zoom(19)         //Establecemos el zoom en 19
                        .bearing(45)      //Establecemos la orientación con el noreste arriba
                        .tilt(70)         //Bajamos el punto de vista de la cámara 70 grados
                        .build();
                CameraUpdate camUpd3 =
                        CameraUpdateFactory.newCameraPosition(camPos);

                mMap.animateCamera(camUpd3);
                break;
            case R.id.menu_posicion:
                CameraPosition camPos2 = mMap.getCameraPosition();
                LatLng pos = camPos2.target;
                Toast.makeText(Mi_ubicacion.this,
                        "Lat: " + pos.latitude + " - Lng: " + pos.longitude,
                        Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }



    private void alternarVista()
    {
        vista = (vista + 1) % 4;

        switch(vista)
        {
            case 0:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                Toast.makeText(Mi_ubicacion.this,   "Normal",  Toast.LENGTH_LONG).show();
                break;
            case 1:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                Toast.makeText(Mi_ubicacion.this,   "Hibrido",  Toast.LENGTH_LONG).show();
                break;
            case 2:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                Toast.makeText(Mi_ubicacion.this,   "Satelite",  Toast.LENGTH_LONG).show();
                break;
            case 3:
                Toast.makeText(Mi_ubicacion.this,   "Terrain",  Toast.LENGTH_LONG).show();
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
        }
    }

*/
    // Obtain the SupportMapFragment and get notified when the map is ready to be used.
     //   SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
      //          .findFragmentById(R.id.map);
      //  mapFragment.getMapAsync(this);

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    //  @Override
  //  public void onMapReady(GoogleMap mMap) {
   //     mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    //    // Add a marker in Sydney and move the camera
     //     LatLng sydney = new LatLng(-34, 151);
      //      mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //    mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

//    }




