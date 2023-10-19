package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mapa extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        Button btnvolver = findViewById(R.id.btnvoplver);
        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mapa.this, MainActivity.class);
                startActivity(intent);
            }
        });
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        String dir1 = getIntent().getStringExtra("direccion1");
        String[] parts1 = dir1.split(",");
        double lat1 = Integer.parseInt(parts1[0]);
        double lng1 = Integer.parseInt(parts1[1]);

        String dir2 = getIntent().getStringExtra("direccion2");
        String[] parts2 = dir2.split(",");
        double lat2 = Integer.parseInt(parts2[0]);
        double lng2 = Integer.parseInt(parts2[1]);

        String dir3 = getIntent().getStringExtra("direccion3");
        String[] parts3 = dir3.split(",");
        double lat3 = Integer.parseInt(parts3[0]);
        double lng3 = Integer.parseInt(parts3[1]);

        LatLng Direct1 = new LatLng(lat1, lng1);
        LatLng Direct2 = new LatLng(lat2, lng2);
        LatLng Direct3 = new LatLng(lat3, lng3);
        mMap.addMarker(new MarkerOptions().position(Direct1) .title("Direccion 1"));
        mMap.addMarker(new MarkerOptions().position(Direct2) .title("Direccion 2"));
        mMap.addMarker(new MarkerOptions().position(Direct3) .title("Direccion 3"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Direct1));
    }
}