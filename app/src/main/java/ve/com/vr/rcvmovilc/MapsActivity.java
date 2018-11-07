package ve.com.vr.rcvmovilc;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.DirectionsStep;
import com.google.maps.model.EncodedPolyline;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker marcador;
    double lat = 0.0;
    double lng = 0.0;
    String mensaje="";
    String direccion="";
    private static String TAG="MapaVr";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        miUbicacion();

        //miLineaTrayectoria();
        // Add a marker in Sydney and move the camera
      /*  LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        */
    }

    private void miLineaTrayectoria()
    {
        LatLng barcelona = new LatLng(41.385064,2.173403);
        mMap.addMarker(new MarkerOptions().position(barcelona).title("Marker in Barcelona"));

        LatLng madrid = new LatLng(40.416775,-3.70379);
        mMap.addMarker(new MarkerOptions().position(madrid).title("Marker in Madrid"));

        LatLng zaragoza = new LatLng(41.648823,-0.889085);

        //Define list to get all latlng for the route
        List<LatLng> path = new ArrayList<LatLng>();

//AIzaSyBrPt88vvoPDDn_imh-RzCXl5Ha2F2LYig")
        //Execute Directions API request
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyAIMNg1Aa9PvfQSdoxeBgAKEbEzy9uS8E4")
                .build();
        DirectionsApiRequest req = DirectionsApi.getDirections(context, "41.385064,2.173403", "40.416775,-3.70379");
        try {
            DirectionsResult res = req.await();

            //Loop through legs and steps to get encoded polylines of each step
            if (res.routes != null && res.routes.length > 0) {
                DirectionsRoute route = res.routes[0];

                if (route.legs !=null) {
                    for(int i=0; i<route.legs.length; i++) {
                        DirectionsLeg leg = route.legs[i];
                        if (leg.steps != null) {
                            for (int j=0; j<leg.steps.length;j++){
                                DirectionsStep step = leg.steps[j];
                                if (step.steps != null && step.steps.length >0) {
                                    for (int k=0; k<step.steps.length;k++){
                                        DirectionsStep step1 = step.steps[k];
                                        EncodedPolyline points1 = step1.polyline;
                                        if (points1 != null) {
                                            //Decode polyline and add points to list of route coordinates
                                            List<com.google.maps.model.LatLng> coords1 = points1.decodePath();
                                            for (com.google.maps.model.LatLng coord1 : coords1) {
                                                path.add(new LatLng(coord1.lat, coord1.lng));
                                            }
                                        }
                                    }
                                } else {
                                    EncodedPolyline points = step.polyline;
                                    if (points != null) {
                                        //Decode polyline and add points to list of route coordinates
                                        List<com.google.maps.model.LatLng> coords = points.decodePath();
                                        for (com.google.maps.model.LatLng coord : coords) {
                                            path.add(new LatLng(coord.lat, coord.lng));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch(Exception ex) {
            Log.e(TAG, ex.getLocalizedMessage());
        }

        //Draw the polyline
        if (path.size() > 0) {
            PolylineOptions opts = new PolylineOptions().addAll( path).color(Color.BLUE).width(5);
            mMap.addPolyline(opts);
        }

        mMap.getUiSettings().setZoomControlsEnabled(true);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(zaragoza, 6));


    }

    private void locationStart(){
        LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        final boolean gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!gpsEnabled){
            Intent intentSetting = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intentSetting);
        }
        /*if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,},1000);
            return;
        }*/

    }
    private void setLocation(Location loc){
        if (loc.getLatitude() != 0.0 && loc.getLongitude() != 0.0){
            try{
                Geocoder geocoder =new Geocoder(this, Locale.getDefault());
                List<Address> list = geocoder.getFromLocation(loc.getLatitude(), loc.getLongitude(),1);
                if(!list.isEmpty())
                {
                    Address DirCalle = list.get(0);
                    direccion =  DirCalle.getSubLocality() + ' ' + DirCalle.getAddressLine(0)   ;
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void AgregarMarcador(double lat, double lng){
        LatLng coordenadas = new LatLng(lat,lng);
        CameraUpdate MiUbicacion = CameraUpdateFactory.newLatLngZoom(coordenadas,16);
        if (marcador!=null){
            marcador.remove();
        }
       /* CircleOptions circleOptions = new CircleOptions();
        circleOptions.radius(100);
        circleOptions.center(coordenadas);
        mMap.addCircle(circleOptions );
*/
        Circle circle = mMap.addCircle(new CircleOptions()
                .center(coordenadas)
                .radius(100)
                .strokeColor(Color.RED)
                .fillColor(0x220000FF)
                .strokeWidth(5));

        //https://stackoverflow.com/questions/47492459/android-google-maps-draw-a-route-between-two-points-along-the-road
        /*Circle circle2 = mMap.addCircle(new CircleOptions()
                .center(coordenadas)
                .radius(1)
                .strokeColor(Color.BLUE)
                .fillColor(0x220000FF))
                ;*/
        marcador = mMap.addMarker(new MarkerOptions()
        .position(coordenadas)
        .title("Direccion: " + direccion)
        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher))

        );
        mMap.animateCamera(MiUbicacion);
    }

    private void ActualizarUbicacion(Location location){
        if(location!= null){
            lat = location.getLatitude();
            lng = location.getLongitude();
            AgregarMarcador(lat,lng);
        }
    }

    LocationListener locListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
          //  ActualizarUbicacion(location);
          //  setLocation(location);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {
            mensaje="GPS Activado";
            Mensaje();
        }

        @Override
        public void onProviderDisabled(String provider) {
            mensaje="GPS Desactivado";
            locationStart();
            Mensaje();
        }
    };


private static int PETICION_PERMISO_LOCALIZACION = 101;
    private void miUbicacion(){
            if (ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},PETICION_PERMISO_LOCALIZACION);
                return;
            }else
            {
                LocationManager locationManager =  (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                //Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                ActualizarUbicacion(location);
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,0,locListener);
                //locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,1000,0,locListener);
            }

    }

    private void Mensaje() {
        Toast toast = Toast.makeText(this,mensaje,Toast.LENGTH_LONG);
        toast.show();
    }
}
