package com.qrvillers_les_nancy.qrvln.qrvillers_les_nancy;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.JointType;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;


public class b2 extends AppCompatActivity implements
        OnMapReadyCallback,
        ActivityCompat.OnRequestPermissionsResultCallback {
    private static final String LOG_TAG = b2.class.getSimpleName();
    private static final int BARCODE_READER_REQUEST_CODE = 1;
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b2);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map2);
        mapFragment.getMapAsync(this);
        ImageButton scanBarcodeButton = (ImageButton) findViewById(R.id.buttoncode2);
        scanBarcodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), c2.class);
                startActivityForResult(intent, BARCODE_READER_REQUEST_CODE);
            }
        });
        ImageButton imagebutton = (ImageButton) findViewById(R.id.im);

        // add button listener
        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle(R.string.tbalade);

                // set dialog message
                alertDialogBuilder
                        .setMessage(R.string.abalade)
                        .setCancelable(false)
                        .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }

        });

    }


    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    private boolean mPermissionDenied = false;

    private GoogleMap mMap;


    public static final LatLng asnee = new LatLng(48.6741516787508, 6.1424882146804975);
    public static final LatLng tourgreffe = new LatLng(48.6706747, 6.1424237999999605);
    public static final LatLng mdegraffigny = new LatLng(48.67024958775726, 6.146060875424155);
    public static final LatLng simondechatellus = new LatLng(48.669657967250615, 6.145835569866904);
    public static final LatLng saintfiacre = new LatLng(48.66615061287881, 6.148775270947226);
    public static final LatLng remicourt = new LatLng(48.66641278717732, 6.151318005093344);
    public static final LatLng brabois = new LatLng(48.65628620004921, 6.147262505062827);
    public static final LatLng pepiniere = new LatLng(48.6982007, 6.1811858);
    public static final LatLng pepsud = new LatLng(48.6970532, 6.1820075);
    public static final LatLng placecarriere = new LatLng(48.6955345, 6.1821985);
    public static final LatLng pepsud2 = new LatLng(48.696847, 6.181324);
    public static final LatLng archere2 = new LatLng(48.694632, 6.182531);
    public static final LatLng pv2 = new LatLng(48.694314, 6.181785);


    @Override
    public void onMapReady(GoogleMap map2) {
        mMap = map2;
        String CA = getString(R.string.CA);
        String TG = getString(R.string.TG);
        String MG = getString(R.string.MG);
        String SC = getString(R.string.SC);
        String SF = getString(R.string.SF);
        String CR = getString(R.string.CR);
        String CB = getString(R.string.CB);
        InfoWindowData info = new InfoWindowData();
        MarkerOptions markerOptions = new MarkerOptions();
        CustomInfoWindowGoogleMap customInfoWindow = new CustomInfoWindowGoogleMap(this);
        mMap.setInfoWindowAdapter(customInfoWindow);
        markerOptions
                .position(b1.asnee)
                .title("Château de l'Asnée")
                .snippet(CA)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.number_3));

        InfoWindowData info9 = new InfoWindowData();
        info9.setImage(String.valueOf(R.drawable.ca));
        mMap.setInfoWindowAdapter(customInfoWindow);
        Marker m2 = mMap.addMarker(markerOptions);
        m2.setTag(info9);
        m2.showInfoWindow();
        markerOptions
                .position(b1.tourgreffe)
                .title("La Tour Greff")
                .snippet(TG)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.number_4));
        InfoWindowData info8 = new InfoWindowData();
        info8.setImage(String.valueOf(R.drawable.tg));
        mMap.setInfoWindowAdapter(customInfoWindow);
        Marker m3 = mMap.addMarker(markerOptions);
        m3.setTag(info8);
        m3.showInfoWindow();
        markerOptions
                .position(b1.mdegraffigny)
                .title("Le château Madame de Graffigny (ex GEC)")
                .snippet(MG)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.number_5));
        InfoWindowData info7= new InfoWindowData();
        info7.setImage(String.valueOf(R.drawable.mg));
        mMap.setInfoWindowAdapter(customInfoWindow);
        Marker m4 = mMap.addMarker(markerOptions);
        m4.setTag(info7);
        m4.showInfoWindow();
        markerOptions
                .position(b1.simondechatellus)
                .title("Le château Simon de Chatellus")
                .snippet(SC)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.number_6));
        InfoWindowData info6 = new InfoWindowData();
        info6.setImage(String.valueOf(R.drawable.sc));
        mMap.setInfoWindowAdapter(customInfoWindow);
        Marker m5 = mMap.addMarker(markerOptions);
        m5.setTag(info6);
        m5.showInfoWindow();
        markerOptions
                .position(b1.saintfiacre)
                .title("Le château Saint-Fiacre")
                .snippet(SF)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.number_7));
        InfoWindowData info5 = new InfoWindowData();
        info5.setImage(String.valueOf(R.drawable.stf));
        mMap.setInfoWindowAdapter(customInfoWindow);
        Marker m6 = mMap.addMarker(markerOptions);
        m6.setTag(info5);
        m6.showInfoWindow();
        markerOptions
                .position(b1.remicourt)
                .title("Le château de Rémicourt")
                .snippet(CR)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.number_1));
        InfoWindowData info4 = new InfoWindowData();
        info4.setImage(String.valueOf(R.drawable.rc));
        mMap.setInfoWindowAdapter(customInfoWindow);
        Marker m7 = mMap.addMarker(markerOptions);
        m7.setTag(info4);
        m7.showInfoWindow();
        markerOptions
                .position(b1.brabois)
                .title("Le château de Brabois")
                .snippet(CB)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.number_2));
        InfoWindowData info0 = new InfoWindowData();
        info0.setImage(String.valueOf(R.drawable.cb));
        mMap.setInfoWindowAdapter(customInfoWindow);
        Marker m8 = mMap.addMarker(markerOptions);
        m8.setTag(info0);
        m8.showInfoWindow();
        enableMyLocation();

        PolygonOptions polygonOptions = new PolygonOptions();
        polygonOptions.add(remicourt, remicourt);
        polygonOptions.strokeJointType(JointType.ROUND);
        polygonOptions.strokeColor(Color.BLUE);
        polygonOptions.strokeWidth(5);

        mMap.addPolygon(polygonOptions);
    }


    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission to access the location is missing.
            PermissionUtils.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true);
        } else if (mMap != null) {
            // Access to the location has been granted to the app.
            mMap.setMyLocationEnabled(true);
        }
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        if (mPermissionDenied) {
            // Permission was not granted, display error dialog.
            showMissingPermissionError();
            mPermissionDenied = false;
        }
    }

    private void showMissingPermissionError() {
        PermissionUtils.PermissionDeniedDialog
                .newInstance(true).show(getSupportFragmentManager(), "dialog");
    }


}
















