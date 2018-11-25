package com.example.user.paulitas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.Polyline;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;
import java.util.List;

public class Mapa extends AppCompatActivity {
       private  MapView  mapp;
       private MapController mappp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);


        GeoPoint pau = new GeoPoint(1.216362, -77.286168);
        mapp = (MapView) findViewById(R.id.openmapview);
        mapp.setExpectedCenter(pau);
        mappp = (MapController) mapp.getController();
        mappp.setZoom(4);


        final MyLocationNewOverlay myLocationoverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(getApplicationContext()), mapp);
        mapp.getOverlays().add(myLocationoverlay); //No añadir si no quieres una marc
        myLocationoverlay.enableMyLocation();
        myLocationoverlay.runOnFirstFix(new Runnable() {
            public void run() {
                mappp.animateTo(myLocationoverlay.getMyLocation());
            }
        });

        ArrayList<OverlayItem> puntos = new ArrayList<OverlayItem>();
        puntos.add(new OverlayItem("Paulitas", "Cake Designer", pau));

        ItemizedIconOverlay.OnItemGestureListener<OverlayItem> tap = new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemLongPress(int arg0, OverlayItem arg1) {
                return false;
            }
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }
        };

        ItemizedOverlayWithFocus<OverlayItem> capa = new ItemizedOverlayWithFocus<OverlayItem>(this, puntos, tap);
        capa.setFocusItemsOnTap(true);
        mapp.getOverlays().add(capa);



        Button seJue = (Button) findViewById(R.id.button3);
        seJue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });






    }

}
