package com.qrvillers_les_nancy.qrvln.qrvillers_les_nancy;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


//Page principale


public class MainActivity extends AppCompatActivity{


    private static final int CODE_DRAW_OVER_OTHER_APP_PERMISSION = 2084;
    private static final int REQUEST_CAMERA_PERMISSION = 201;
    final Context context = MainActivity.this;
    SharedPreferences prefs = null;
    private static final int LENGHT_LONG = 2750;
    private LocationManager lm;
    View im;
    ImageView f1;
    ImageView f2;
    ImageView f3;
    TextView t1;
    TextView t2;
    TextView t3;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA,Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CAMERA_PERMISSION);
        im = findViewById(R.id.rV);
        f1 = findViewById(R.id.f1);
        f2 = findViewById(R.id.f2);
        f3 = findViewById(R.id.f3);
        t1 = findViewById(R.id.textView14);
        t2 = findViewById(R.id.textView15);
        t3 = findViewById(R.id.textView16);
        b1 = findViewById(R.id.button);
        im.setVisibility(View.GONE);
        f1.setVisibility(View.GONE);
        f2.setVisibility(View.GONE);
        f3.setVisibility(View.GONE);
        b1.setVisibility(View.GONE);
        t1.setVisibility(View.GONE);
        t2.setVisibility(View.GONE);
        t3.setVisibility(View.GONE);
        prefs = getSharedPreferences("com.qrvillers_les_nancy.qrvln.qrvillers_les_nancy", MODE_PRIVATE);



    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    public boolean checkLocationPermission()
    {
        String permission = "android.permission.ACCESS_FINE_LOCATION";
        int res = this.checkCallingOrSelfPermission(permission);

        return (res == PackageManager.PERMISSION_GRANTED);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //ajoute les entrées de menu_test à l'ActionBar
        getMenuInflater().inflate(R.menu.menub, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        //Vérifie si l'appli peut afficher la bubble par rapport à la version Android

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {

            LayoutInflater li = getLayoutInflater();
            View customToast = li.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.toast_layout_root));
            TextView text = (TextView) customToast.findViewById(R.id.text);
            text.setText(R.string.f2);

            Toast toast = new Toast(this);
            Toast toast1 = new Toast(this);
            Toast toast2 = new Toast(this);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(customToast);
            toast.show();
            toast1.setDuration(Toast.LENGTH_LONG);
            toast1.setView(customToast);
            toast1.show();
            toast2.setDuration(Toast.LENGTH_LONG);
            toast2.setView(customToast);
            toast2.show();



            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, CODE_DRAW_OVER_OTHER_APP_PERMISSION);

        } else {
            setContentView(R.layout.activity_main);
        }
        prefs = getSharedPreferences("com.qrvillers_les_nancy.qrvln.qrvillers_les_nancy", MODE_PRIVATE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Settings.canDrawOverlays(this)) {
                startService(new Intent(this, FloatingFaceBubbleService.class));
            }
        }
        return true;

    }




//Si c'est la première ouverture d'appli depuis le téléchargement on affiche le tuto

    @Override
    protected void onResume() {
        super.onResume();
        im = findViewById(R.id.rV);
        f1 = findViewById(R.id.f1);
        f2 = findViewById(R.id.f2);
        f3 = findViewById(R.id.f3);
        t1 = findViewById(R.id.textView14);
        t2 = findViewById(R.id.textView15);
        t3 = findViewById(R.id.textView16);
        b1 = findViewById(R.id.button);

        if (prefs.getBoolean("firstrun", true)) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    context);

            // set title
            alertDialogBuilder.setTitle(R.string.acc);

            // set dialog message
            alertDialogBuilder
                    .setMessage(R.string.f1)
                    .setCancelable(false)
                    .setNegativeButton("OK",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            im.setVisibility(View.VISIBLE);
                            dialog.cancel();
                            f1.setVisibility(View.VISIBLE);
                            t1.setVisibility(View.VISIBLE);

                            b1.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    f1.setVisibility(View.GONE);
                                    t1.setVisibility(View.GONE);
                                    f2.setVisibility(View.VISIBLE);
                                    t2.setVisibility(View.VISIBLE);
                                    b1.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View v) {
                                            f2.setVisibility(View.GONE);
                                            t2.setVisibility(View.GONE);
                                            f3.setVisibility(View.VISIBLE);
                                            t2.setVisibility(View.VISIBLE);
                                            b1.setOnClickListener(new View.OnClickListener() {
                                                public void onClick(View v) {
                                                    f3.setVisibility(View.GONE);
                                                    t2.setVisibility(View.GONE);
                                                    im.setVisibility(View.GONE);
                                                }
                                            });
                                        }
                                    });
                                }
                            });
                        }
                    });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();




            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putBoolean("isFirstRun", false)
                    .apply();
            prefs.edit().putBoolean("firstrun", false).apply();
            im.setVisibility(View.GONE);
        }

    }

// ouvre page balade et bubble
    public void page3bis (View view){
        startActivity(new Intent(MainActivity.this, p3.class));}

    // ouvre page map
    public void page1 (View view) {
        startActivity(new Intent(this, p2.class));}
    // ouvre page balade et bubble
    public void page2 (View view) {
        startActivity(new Intent(this, p3.class));}
    // ouvre page en savoir plus
    public void page3 (View view) {
        startActivity(new Intent(this, p1.class));}

// sécurité du code
        public class MD5 {
            private static final String TAG = "MD5";

            public boolean checkMD5(String md5, File updateFile) {
                if (TextUtils.isEmpty(md5) || updateFile == null) {
                    Log.e(TAG, "MD5 string empty or updateFile null");
                    return false;
                }

                String calculatedDigest = calculateMD5(updateFile);
                if (calculatedDigest == null) {
                    Log.e(TAG, "calculatedDigest null");
                    return false;
                }

                Log.v(TAG, "Calculated digest: " + calculatedDigest);
                Log.v(TAG, "Provided digest: " + md5);

                return calculatedDigest.equalsIgnoreCase(md5);
            }

            String calculateMD5(File updateFile) {
                MessageDigest digest;
                try {
                    digest = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException e) {
                    Log.e(TAG, "Exception while getting digest", e);
                    return null;
                }

                InputStream is;
                try {
                    is = new FileInputStream(updateFile);
                } catch (FileNotFoundException e) {
                    Log.e(TAG, "Exception while getting FileInputStream", e);
                    return null;
                }

                byte[] buffer = new byte[8192];
                int read;
                try {
                    while ((read = is.read(buffer)) > 0) {
                        digest.update(buffer, 0, read);
                    }
                    byte[] md5sum = digest.digest();
                    BigInteger bigInt = new BigInteger(1, md5sum);
                    String output = bigInt.toString(16);
                    // Fill to 32 chars
                    output = String.format("%32s", output).replace(' ', '0');
                    return output;
                } catch (IOException e) {
                    throw new RuntimeException("Unable to process file for MD5", e);
                } finally {
                    try {
                        is.close();
                    } catch (IOException e) {
                        Log.e(TAG, "Exception on closing MD5 input stream", e);
                    }
                }
            }
        }

        //si la permission n'est pas activée ferme dit qu'il faut l'activée pour aller sur l'appli
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CODE_DRAW_OVER_OTHER_APP_PERMISSION) {

            //Check if the permission is granted or not.
            if (Settings.canDrawOverlays(this)) {
                setContentView(R.layout.activity_main);
                startService(new Intent(this, FloatingFaceBubbleService.class));
            } else {
                Toast.makeText(this,
                        "Draw over other app permission not available.",
                        Toast.LENGTH_SHORT).show();
                setContentView(R.layout.activity_main);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


}


