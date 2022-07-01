/*
Nama    : Agi Sutrisna
Nim     : 10119015
Kelas   : IF1
 */


package com.example.tugas_sensor_genap_2022_akb_if1_10119015;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.tugas_sensor_genap_2022_akb_if1_10119015.databinding.ActivityMapsBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MapsActivity extends FragmentActivity{

    private ActivityMapsBinding binding;
    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        client = LocationServices.getFusedLocationProviderClient(this);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        getCurrentLocation();
    }

    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }

        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null ) {
                    mapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(@NonNull GoogleMap googleMap) {
                            LatLng lokasiSaatIni = new LatLng(location.getLatitude(), location.getLongitude());
                            LatLng lokasi1 = new LatLng(-6.836405391456274, 107.9170831542866);
                            LatLng lokasi2 = new LatLng(-6.85104149385858, 107.92420072545134);
                            LatLng lokasi3 = new LatLng(-6.844089569059163, 107.92486120355515);
                            LatLng lokasi4 = new LatLng(-6.833918953322659, 107.93358906962804);
                            LatLng lokasi5 = new LatLng(-6.844228542739718, 107.92459925243912);

                            googleMap.addMarker(new MarkerOptions().position(lokasiSaatIni).title("Lokasi Saat Ini"));
                            googleMap.addMarker(new MarkerOptions().position(lokasi1).title("Rumah Makan Tahu Bungkeng"));
                            googleMap.addMarker(new MarkerOptions().position(lokasi2).title("RM Sederhana Hj Erat"));
                            googleMap.addMarker(new MarkerOptions().position(lokasi3).title("Rumah Makan Dan Baso Mirasa "));
                            googleMap.addMarker(new MarkerOptions().position(lokasi4).title("RM Cahaya Sari"));
                            googleMap.addMarker(new MarkerOptions().position(lokasi5).title("Yoe fo Tahu Sumedang"));

                            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasiSaatIni, 15));
                        }
                    });
                }
            }
        });
    }
}