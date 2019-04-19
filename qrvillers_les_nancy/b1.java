package com.qrvillers_les_nancy.qrvln.qrvillers_les_nancy;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.JointType;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

import java.util.Objects;


//BALADE 1

public class b1 extends AppCompatActivity implements
        OnMapReadyCallback,
        ActivityCompat.OnRequestPermissionsResultCallback,
        LocationListener {
    private static final String LOG_TAG = com.qrvillers_les_nancy.qrvln.qrvillers_les_nancy.b1.class.getSimpleName();
    private static final int BARCODE_READER_REQUEST_CODE = 1;
    private MapView mapView;
    private static final String CHANNEL_ID = "";
    private static final int NOTIFICATION_ID = 0;

    private LocationManager lm;

    private double latitude;
    private double longitude;
    private double altitude;
    private float accuracy;
    SharedPreferences prefs = null;
    final int[] stop = {0};

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.b1);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map2);
        mapFragment.getMapAsync(this);
        Button scanBarcodeButton = (Button) findViewById(R.id.buttoncode2);
        scanBarcodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), c1.class);
                startActivityForResult(intent, BARCODE_READER_REQUEST_CODE);
            }
        });

        ImageButton imagebutton = (ImageButton) findViewById(R.id.im);

        // add button listener
        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                //Créer un msg alert

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

        prefs = getSharedPreferences("com.qrvillers_les_nancy.qrvln.qrvillers_les_nancy", MODE_PRIVATE);


    }

    //Créer un menu : celui-ci créer un menu de 1 à 7 pour affciher les 7 monuments

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //ajoute les entrées de menu_test à l'ActionBar
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        MarkerOptions markerOptions = new MarkerOptions();
        CustomInfoWindowGoogleMap customInfoWindow = new CustomInfoWindowGoogleMap(this);

        switch (item.getItemId()){
            case R.id.un:
                markerOptions
                        .position(b1.remicourt)
                        .title("Le château de Rémicourt")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.number_1));
                InfoWindowData info4 = new InfoWindowData();
                info4.setImage(String.valueOf(R.drawable.rc));
                mMap.setInfoWindowAdapter(customInfoWindow);
                Marker m7 = mMap.addMarker(markerOptions);
                m7.setTag(info4);
                m7.showInfoWindow();
                return true;
            case R.id.deux:
                markerOptions
                        .position(b1.brabois)
                        .title("Le château de Brabois")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.number_2));
                InfoWindowData info0 = new InfoWindowData();
                info0.setImage(String.valueOf(R.drawable.cb));
                mMap.setInfoWindowAdapter(customInfoWindow);
                Marker m8 = mMap.addMarker(markerOptions);
                m8.setTag(info0);
                m8.showInfoWindow();
                return true;
            case R.id.trois:
                mMap.setInfoWindowAdapter(customInfoWindow);
                markerOptions
                        .position(b1.asnee)
                        .title("Château de l'Asnée")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.number_3));
                InfoWindowData info9 = new InfoWindowData();
                info9.setImage(String.valueOf(R.drawable.ca));
                mMap.setInfoWindowAdapter(customInfoWindow);
                Marker m2 = mMap.addMarker(markerOptions);
                m2.setTag(info9);
                m2.showInfoWindow();
                return true;
            case R.id.quatre:
                markerOptions
                        .position(b1.tourgreffe)
                        .title("La Tour Greff")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.number_4));
                InfoWindowData info8 = new InfoWindowData();
                info8.setImage(String.valueOf(R.drawable.tg));
                mMap.setInfoWindowAdapter(customInfoWindow);
                Marker m3 = mMap.addMarker(markerOptions);
                m3.setTag(info8);
                m3.showInfoWindow();
                return true;
            case R.id.cinq:
                markerOptions
                        .position(b1.mdegraffigny)
                        .title("Le château Madame de Graffigny (ex GEC)")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.number_5));
                InfoWindowData info7= new InfoWindowData();
                info7.setImage(String.valueOf(R.drawable.mg));
                mMap.setInfoWindowAdapter(customInfoWindow);
                Marker m4 = mMap.addMarker(markerOptions);
                m4.setTag(info7);
                m4.showInfoWindow();
                return true;

            case R.id.six:
                markerOptions
                        .position(b1.simondechatellus)
                        .title("Le château Simon de Chatellus")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.number_6));
                InfoWindowData info6 = new InfoWindowData();
                info6.setImage(String.valueOf(R.drawable.sc));
                mMap.setInfoWindowAdapter(customInfoWindow);
                Marker m5 = mMap.addMarker(markerOptions);
                m5.setTag(info6);
                m5.showInfoWindow();
                return true;
            case R.id.sept:
                markerOptions
                        .position(b1.saintfiacre)
                        .title("Le château Saint-Fiacre")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.number_7));
                InfoWindowData info5 = new InfoWindowData();
                info5.setImage(String.valueOf(R.drawable.stf));
                mMap.setInfoWindowAdapter(customInfoWindow);
                Marker m6 = mMap.addMarker(markerOptions);
                m6.setTag(info5);
                m6.showInfoWindow();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }





    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    private boolean mPermissionDenied = false;

    private GoogleMap mMap;

    //On initialise les coo des châteaux et d'aures points pour faire passer le polygone sur des routes définies

    public static final LatLng asnee = new LatLng(48.6741516787508, 6.1424882146804975);
    public static final LatLng tourgreffe = new LatLng(48.6691266, 6.1420737);
    public static final LatLng mdegraffigny = new LatLng(48.67024958775726, 6.146060875424155);
    public static final LatLng simondechatellus = new LatLng(48.669657967250615, 6.145835569866904);
    public static final LatLng saintfiacre = new LatLng(48.66615061287881, 6.148775270947226);
    public static final LatLng remicourt = new LatLng(48.66641278717732, 6.151318005093344);
    public static final LatLng brabois = new LatLng(48.65628620004921, 6.147262505062827);


    public static final LatLng p1 = new LatLng(48.666243, 6.151482);
    public static final LatLng p2 = new LatLng(48.666082, 6.150719);
    public static final LatLng p3 = new LatLng(48.665715, 6.150866);
    public static final LatLng p4 = new LatLng(48.664835, 6.151943);
    public static final LatLng p5 = new LatLng(48.664257, 6.152312);
    public static final LatLng p6 = new LatLng(48.663510, 6.151239);
    public static final LatLng p7 = new LatLng(48.663295, 6.151074);
    public static final LatLng p8 = new LatLng(48.663043, 6.151104);
    public static final LatLng p9 = new LatLng(48.662558, 6.151248);
    public static final LatLng p10 = new LatLng(48.662361, 6.151214);
    public static final LatLng p11 = new LatLng(48.661539, 6.150946);
    public static final LatLng p12 = new LatLng(48.661527, 6.150838);
    public static final LatLng p13 = new LatLng(48.661511, 6.150814);
    public static final LatLng p14 = new LatLng(48.660985, 6.150500);
    public static final LatLng p15 = new LatLng(48.659673, 6.149943);
    public static final LatLng p16 = new LatLng(48.659483, 6.149784);
    public static final LatLng p17 = new LatLng(48.659058, 6.149290);
    public static final LatLng p18 = new LatLng(48.658562, 6.148870);
    public static final LatLng p19 = new LatLng(48.658463, 6.148827);
    public static final LatLng p20 = new LatLng(48.658275, 6.148823);
    public static final LatLng p21 = new LatLng(48.658234, 6.148775);
    public static final LatLng p22 = new LatLng(48.657673, 6.148414);
    public static final LatLng p23 = new LatLng(48.657185, 6.148116);
    public static final LatLng p24 = new LatLng(48.656974, 6.148039);
    public static final LatLng p25 = new LatLng(48.656798, 6.147933);
    public static final LatLng p26 = new LatLng(48.656686, 6.147892);
    public static final LatLng p27 = new LatLng(48.656588, 6.147876);
    public static final LatLng p28 = new LatLng(48.656437, 6.147896);
    public static final LatLng p29 = new LatLng(48.656355, 6.147937);
    public static final LatLng p30 = new LatLng(48.656249, 6.148089);
    public static final LatLng p31 = new LatLng(48.656174, 6.148278);
    public static final LatLng p32 = new LatLng(48.656083, 6.148226);
    public static final LatLng p33 = new LatLng(48.656008, 6.148167);
    public static final LatLng p34 = new LatLng(48.655909, 6.148177);
    public static final LatLng p35 = new LatLng(48.655826, 6.148072);
    public static final LatLng p36 = new LatLng(48.656134, 6.147126);

    public static final LatLng p37 = new LatLng(48.656223, 6.146912);
    public static final LatLng p38 = new LatLng(48.656422, 6.147108);
    public static final LatLng p39 = new LatLng(48.656700, 6.146792);
    public static final LatLng p40 = new LatLng(48.657089, 6.146270);
    public static final LatLng p41 = new LatLng(48.658851, 6.141756);
    public static final LatLng p42 = new LatLng(48.659241, 6.140687);
    public static final LatLng p43 = new LatLng(48.659262, 6.140643);
    public static final LatLng p44 = new LatLng(48.659288, 6.140617);
    public static final LatLng p45 = new LatLng(48.659373, 6.140515);
    public static final LatLng p46 = new LatLng(48.659442, 6.140453);
    public static final LatLng p47 = new LatLng(48.659480, 6.140374);
    public static final LatLng p48 = new LatLng(48.660433, 6.141133);
    public static final LatLng p49 = new LatLng(48.660615, 6.141186);
    public static final LatLng p50 = new LatLng(48.661785, 6.141815);
    public static final LatLng p51 = new LatLng(48.662089, 6.141943);
    public static final LatLng p52 = new LatLng(48.662136, 6.141836);
    public static final LatLng p53 = new LatLng(48.662258, 6.141735);
    public static final LatLng p54 = new LatLng(48.662928, 6.141493);
    public static final LatLng p55 = new LatLng(48.668830, 6.141787);
    public static final LatLng p56 = new LatLng(48.669676, 6.142075);
    public static final LatLng p57 = new LatLng(48.670428, 6.143164);
    public static final LatLng p58 = new LatLng(48.670630, 6.142892);
    public static final LatLng p59 = new LatLng(48.670902, 6.142804);
    public static final LatLng p60 = new LatLng(48.671404, 6.142985);
    public static final LatLng p61 = new LatLng(48.670796, 6.142219);
    public static final LatLng p62 = new LatLng(48.671896, 6.143591);
    public static final LatLng p63 = new LatLng(48.672125, 6.144241);
    public static final LatLng p64 = new LatLng(48.673175, 6.144533);
    public static final LatLng p65 = new LatLng(48.673303, 6.144844);
    public static final LatLng p66 = new LatLng(48.673402, 6.145203);
    public static final LatLng p67 = new LatLng(48.673455, 6.145308);
    public static final LatLng p68 = new LatLng(48.673503, 6.145580);
    public static final LatLng p69 = new LatLng(48.673678, 6.146019);
    public static final LatLng p71 = new LatLng(48.674007, 6.145157);
    public static final LatLng p72 = new LatLng(48.674381, 6.144983);
    public static final LatLng p73 = new LatLng(48.675134, 6.145483);
    public static final LatLng p74 = new LatLng(48.675580, 6.145260);
    public static final LatLng p75 = new LatLng(48.675876, 6.145130);

    public static final LatLng p76 = new LatLng(48.673429, 6.146530);
    public static final LatLng p77 = new LatLng(48.672650, 6.147092);
    public static final LatLng p78 = new LatLng(48.672588, 6.146958);
    public static final LatLng p79 = new LatLng(48.672047, 6.146524);
    public static final LatLng p80 = new LatLng(48.671682, 6.146443);
    public static final LatLng p81 = new LatLng(48.671011, 6.146500);
    public static final LatLng p82 = new LatLng(48.670744, 6.146394);
    public static final LatLng p83 = new LatLng(48.670464, 6.146095);
    public static final LatLng p84 = new LatLng(48.670417, 6.146175);

    public static final LatLng p87 = new LatLng(48.670332, 6.146139);
    public static final LatLng p88 = new LatLng(48.670177, 6.146290);
    public static final LatLng p88b = new LatLng(48.666158, 6.142013);
    public static final LatLng p89 = new LatLng(48.669772, 6.145619);

    public static final LatLng p90 = new LatLng(48.670127, 6.146350);
    public static final LatLng p91 = new LatLng(48.670025, 6.146366);
    public static final LatLng p92 = new LatLng(48.669915, 6.146479);
    public static final LatLng p93 = new LatLng(48.669895, 6.146528);
    public static final LatLng p94 = new LatLng(48.669854, 6.147002);
    public static final LatLng p97 = new LatLng(48.669733, 6.147751);
    public static final LatLng p98 = new LatLng(48.668732, 6.147211);
    public static final LatLng p99 = new LatLng(48.668422, 6.147355);
    public static final LatLng p100 = new LatLng(48.668268, 6.147566);
    public static final LatLng p101 = new LatLng(48.668139, 6.147988);
    public static final LatLng p102 = new LatLng(48.668047, 6.148253);
    public static final LatLng p103 = new LatLng(48.667654, 6.149137);
    public static final LatLng p104 = new LatLng(48.667398, 6.149478);
    public static final LatLng p107 = new LatLng(48.667167, 6.149666);

    public static final LatLng p108 = new LatLng(48.666801, 6.148264);
    public static final LatLng p109 = new LatLng(48.666701, 6.148205);

    public static final LatLng p110 = new LatLng(48.666783, 6.149951);
    public static final LatLng p111 = new LatLng(48.666337, 6.150613);


    @Override
    protected void onResume() {
        super.onResume();

        //on active la position du tel en demandant la perm

        lm = (LocationManager) this.getSystemService(LOCATION_SERVICE);
        if (lm.isProviderEnabled(LocationManager.GPS_PROVIDER))
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0,
                this);
        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000, 0,
                this);
        super.onResume();

        // si c'est la première ouverture de l'appli on affiche le tuto

        if (prefs.getBoolean("firstrun2", true)) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    context);

            // set title
            alertDialogBuilder.setTitle(R.string.tbalade);

            // set dialog message
            alertDialogBuilder
                    .setMessage(R.string.abalade)
                    .setCancelable(false)
                    .setNegativeButton("OK",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, just close
                            // the dialog box and do nothing
                            dialog.cancel();
                        }
                    });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putBoolean("isFirstRun2", false)
                    .apply();
            prefs.edit().putBoolean("firstrun2", false).apply();
        }
    }

    //arrête la localisation

    @Override
    protected void onPause() {
        super.onPause();
        lm.removeUpdates(this);
    }


    protected boolean isRouteDisplayed() {
        return false;
    }


    private void createNotificationChannel() {
        // Créer le NotificationChannel, seulement pour API 26+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Notification channel name";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription("Notification channel description");
            // Enregister le canal sur le système : attention de ne plus rien modifier après
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            Objects.requireNonNull(notificationManager).createNotificationChannel(channel);
        }
    }

    private void createNotification() {

        Intent intent = new Intent(this, b1.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.logor)
                .setContentIntent(pendingIntent)
                .setContentTitle("Notification de balade")
                .setContentText("Vous êtes proche d'un point de visite !")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        createNotificationChannel();
        // notificationId est un identificateur unique par notification qu'il vous faut définir
        notificationManager.notify(NOTIFICATION_ID, notifBuilder.build());
    }

    //Détection de la localisation pour savoir si on se trouve a côté d'un châteaux

    @Override
    public void onLocationChanged(Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        altitude = location.getAltitude();
        accuracy = location.getAccuracy();
        long [] tmp ={1,100,200,100};
        final Vibrator vib=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);


        Intent intent = new Intent(getApplicationContext(), c1.class);



        if(stop[0] !=2) {
        if(latitude>=48.6741  && latitude<=48.6758 && longitude>=6.1449 && longitude<=6.1454){
            vib.vibrate(tmp,-1);
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    context);

            // set title
            alertDialogBuilder.setTitle("Vous êtes arrivé à un lieu de la balade.");

            // set dialog message
            alertDialogBuilder
                    .setCancelable(true)
                    .setNeutralButton("Je veux aller sur le site web", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            Uri uri = Uri.parse("http://qrvn.free.fr/Asnee.html");
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                            vib.cancel();
                            stop[0] = 2;
                        }
                    })
                    .setNegativeButton("Je ne veux pas aller sur le site web", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // if this button is clicked, just close
                            // the dialog box and do nothing
                            dialog.cancel();
                            vib.cancel();
                            stop[0] = 2;
                        }
                    });


            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        }}

        if(stop[0] !=3) {
        if(latitude>=48.6688    && latitude<=48.6693    && longitude>=6.1418 && longitude<=6.142){
            vib.vibrate(tmp,-1);
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    context);

            // set title
            alertDialogBuilder.setTitle("Vous êtes arrivé à un lieu de la balade.");

            // set dialog message
            alertDialogBuilder
                    .setCancelable(true)
                    .setNeutralButton("Je veux aller sur le site web", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            Uri uri = Uri.parse("http://qrvn.free.fr/Greff.html");
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                            vib.cancel();
                            stop[0] = 3;
                        }
                    })
                    .setNegativeButton("Je ne veux pas aller sur le site web", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // if this button is clicked, just close
                            // the dialog box and do nothing
                            dialog.cancel();
                            vib.cancel();
                            stop[0] = 3;
                        }
                    });


            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        }}

        if(stop[0] !=4) {
            if (latitude >= 48.67015 && latitude <= 48.67038 && longitude >= 6.1462 && longitude <= 6.1468) {
                vib.vibrate(tmp, -1);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle("Vous êtes arrivé à un lieu de la balade.");

                // set dialog message
                alertDialogBuilder
                        .setCancelable(true)
                        .setNeutralButton("Je veux aller sur le site web", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                Uri uri = Uri.parse("http://qrvn.free.fr/Graffigny.html");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                startActivity(intent);
                                vib.cancel();
                                stop[0] = 4;
                            }
                        })
                        .setNegativeButton("Je ne veux pas aller sur le site web", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                                vib.cancel();
                                stop[0] = 4;
                            }
                        });


                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        }

        if(stop[0] !=5) {
            if (latitude >= 48.66961 && latitude <= 48.670105 && longitude >= 6.145476 && longitude <= 6.14625) {
                vib.vibrate(tmp, -1);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle("Vous êtes arrivé à un lieu de la balade.");

                // set dialog message
                alertDialogBuilder
                        .setCancelable(true)
                        .setNeutralButton("Je veux aller sur le site web", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                Uri uri = Uri.parse("http://qrvn/Chatellus.html");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                startActivity(intent);
                                vib.cancel();
                                stop[0] = 5;
                            }
                        })
                        .setNegativeButton("Je ne veux pas aller sur le site web", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                                vib.cancel();
                                stop[0] = 5;
                            }
                        });


                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        }

        if(stop[0] !=6) {
            if (latitude >= 48.66695 && latitude <= 48.6672 && longitude >= 6.1497 && longitude <= 6.14953) {
                vib.vibrate(tmp, -1);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle("Vous êtes arrivé à un lieu de la balade.");

                // set dialog message
                alertDialogBuilder
                        .setCancelable(true)
                        .setNeutralButton("Je veux aller sur le site web", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                Uri uri = Uri.parse("http://qrvn.free.fr/Saint-Fiacre.html");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                startActivity(intent);
                                vib.cancel();
                                stop[0] = 6;
                            }
                        })
                        .setNegativeButton("Je ne veux pas aller sur le site web", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                                vib.cancel();
                                stop[0] = 6;
                            }
                        });


                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        }

        if(stop[0] !=7) {
            if (latitude >= 48.6660 && latitude <= 48.6662 && longitude >= 6.1506 && longitude <= 6.1508) {
                vib.vibrate(tmp, -1);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle("Vous êtes arrivé à un lieu de la balade.");

                // set dialog message
                alertDialogBuilder
                        .setCancelable(true)
                        .setNeutralButton("Je veux aller sur le site web", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                Uri uri = Uri.parse("http://qrvn.free.fr/Remicourt.html");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                startActivity(intent);
                                vib.cancel();
                                stop[0] = 7;
                            }
                        })
                        .setNegativeButton("Je ne veux pas aller sur le site web", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                                vib.cancel();
                                stop[0] = 7;
                            }
                        });


                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        }

        if(stop[0] !=8) {
            if (latitude >= 48.6558 && latitude <= 48.6563 && longitude >= 6.148 && longitude <= 6.14695) {
                vib.vibrate(tmp, -1);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle("Vous êtes arrivé à un lieu de la balade.");

                // set dialog message
                alertDialogBuilder
                        .setCancelable(true)
                        .setNeutralButton("Je veux aller sur le site web", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                Uri uri = Uri.parse("http://qrvn.free.fr/Brabois.html");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                startActivity(intent);
                                stop[0] = 8;
                            }
                        })
                        .setNegativeButton("Je ne veux pas aller sur le site web", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                                stop[0] = 8;
                            }
                        });


                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        }

    }

    //msg si la localisation est desactivée parcequ'elle ne trouve pas de satellite
    @Override
    public void onProviderDisabled(String provider) {
        String msg = String.format(
                getResources().getString(R.string.provider_disabled), provider);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT);
    }

    // msg quand la localisation est activée elle a trouvé un satellite

    @Override
    public void onProviderEnabled(String provider) {
        String msg = String.format(
                getResources().getString(R.string.provider_enabled), provider);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        String newStatus = "";
        switch (status) {
            case LocationProvider.OUT_OF_SERVICE:
                newStatus = "OUT_OF_SERVICE";
                break;
            case LocationProvider.TEMPORARILY_UNAVAILABLE:
                newStatus = "TEMPORARILY_UNAVAILABLE";
                break;
            case LocationProvider.AVAILABLE:
                newStatus = "AVAILABLE";
                break;
        }
        @SuppressLint("StringFormatMatches") String msg = String.format(
                getResources().getString(R.string.provider_disabled), provider,
                newStatus);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT);
    }



//initialisation de la map et création des fenêtres d'infos

    @Override
    public void onMapReady(GoogleMap map2) {
        mMap = map2;

        MarkerOptions markerOptions = new MarkerOptions();
        CustomInfoWindowGoogleMap customInfoWindow = new CustomInfoWindowGoogleMap(this);

        mMap.setInfoWindowAdapter(customInfoWindow);
        markerOptions
                .position(b1.asnee)
                .title("Château de l'Asnée")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.number_4));
        InfoWindowData info9 = new InfoWindowData();
        info9.setImage(String.valueOf(R.drawable.ca));
        mMap.setInfoWindowAdapter(customInfoWindow);
        Marker m2 = mMap.addMarker(markerOptions);
        m2.setTag(info9);
        m2.showInfoWindow();

        markerOptions
                .position(b1.tourgreffe)
                .title("La Tour Greff")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.number_3));
        InfoWindowData info8 = new InfoWindowData();
        info8.setImage(String.valueOf(R.drawable.tg));
        mMap.setInfoWindowAdapter(customInfoWindow);
        Marker m3 = mMap.addMarker(markerOptions);
        m3.setTag(info8);
        m3.showInfoWindow();

        markerOptions
                .position(b1.mdegraffigny)
                .title("Le château Madame de Graffigny (ex GEC)")
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
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.number_7));
        InfoWindowData info5 = new InfoWindowData();
        info5.setImage(String.valueOf(R.drawable.stf));
        mMap.setInfoWindowAdapter(customInfoWindow);
        Marker m6 = mMap.addMarker(markerOptions);
        m6.setTag(info5);
        m6.showInfoWindow();

        markerOptions
                .position(b1.brabois)
                .title("Le château de Brabois")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.number_2));
        InfoWindowData info0 = new InfoWindowData();
        info0.setImage(String.valueOf(R.drawable.cb));
        mMap.setInfoWindowAdapter(customInfoWindow);
        Marker m8 = mMap.addMarker(markerOptions);
        m8.setTag(info0);
        m8.showInfoWindow();

        markerOptions
                .position(b1.remicourt)
                .title("Le château de Rémicourt")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.number_1));
        InfoWindowData info4 = new InfoWindowData();
        info4.setImage(String.valueOf(R.drawable.rc));
        mMap.setInfoWindowAdapter(customInfoWindow);
        Marker m7 = mMap.addMarker(markerOptions);
        m7.setTag(info4);
        m7.showInfoWindow();



        enableMyLocation();

        PolygonOptions polygonOptions = new PolygonOptions();
        polygonOptions.add(remicourt, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p33, p34,
                p35, p36, brabois, p37,  p38, p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50, p51, p52, p53, p54, p88b, p55, tourgreffe, p56, p57, p58, p59, p60, p62, p63, p64, p65, p66, p67, p68, p69, p71, p72, p73, p74, p75, asnee, p75, p74, p73, p72, p71, p69, p76, p77, p78, p79, p80, p81, p82, p83, p84, mdegraffigny, p87, p88, p89,
                simondechatellus, p89, p88, p89, p90, p91, p92, p93, p94, p97, p98, p99, p100, p101, p102, p103, p104, p107, p108, p109, saintfiacre, p109, p108, p107, p110, p111, p2, p1, remicourt);
        polygonOptions.strokeJointType(JointType.ROUND);
        polygonOptions.strokeColor(Color.BLUE);
        polygonOptions.strokeWidth(5);

        mMap.addPolygon(polygonOptions);



    }

// permissions pour la localisation
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
