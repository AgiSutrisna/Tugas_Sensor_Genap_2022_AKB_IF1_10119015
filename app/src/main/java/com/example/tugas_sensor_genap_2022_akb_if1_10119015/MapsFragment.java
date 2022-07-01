/*
Nama    : Agi Sutrisna
Nim     : 10119015
Kelas   : IF1
 */


package com.example.tugas_sensor_genap_2022_akb_if1_10119015;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.example.tugas_sensor_genap_2022_akb_if1_10119015.databinding.ActivityMapsBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.tugas_sensor_genap_2022_akb_if1_10119015.databinding.ActivityMapsBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MapsFragment extends Fragment {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient client;


    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng sydney = new LatLng(-34, 151);
            googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15));

            LatLng lokasiSaatIni = new LatLng(-6.857613431688539, 107.92245019209686);
            LatLng lokasi1 = new LatLng(-6.836405391456274, 107.9170831542866);
            LatLng lokasi2 = new LatLng(-6.85104149385858, 107.92420072545134);
            LatLng lokasi3 = new LatLng(-6.852637012180381, 107.92205795243918);
            LatLng lokasi4 = new LatLng(-6.833918953322659, 107.93358906962804);
            LatLng lokasi5 = new LatLng(-6.844228542739718, 107.92459925243912);

            googleMap.addMarker(new MarkerOptions().position(lokasiSaatIni).title("Lokasi Saat Ini"));
            googleMap.addMarker(new MarkerOptions().position(lokasi1).title("Rumah Makan Tahu Bungkeng"));
            googleMap.addMarker(new MarkerOptions().position(lokasi2).title("RM Sederhana Hj Erat"));
            googleMap.addMarker(new MarkerOptions().position(lokasi3).title("Warteg Berkah Jaya"));
            googleMap.addMarker(new MarkerOptions().position(lokasi4).title("RM Cahaya Sari"));
            googleMap.addMarker(new MarkerOptions().position(lokasi5).title("Yoe fo Tahu Sumedang"));

            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasiSaatIni, 15));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(callback);
    }
}