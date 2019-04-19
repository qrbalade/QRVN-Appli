package com.qrvillers_les_nancy.qrvln.qrvillers_les_nancy;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.qrvillers_les_nancy.qrvln.qrvillers_les_nancy.b2;


//page 3 balade


public class p3 extends AppCompatActivity {

    final Context context = this;
    SharedPreferences prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recherche);

        ImageButton imagebutton = (ImageButton) findViewById(R.id.im);
        //aide : tuto
        // add button listener
        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle(R.string.choisissez_votre_balade);

                // set dialog message
                alertDialogBuilder
                        .setMessage(R.string.aide1)
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

    @Override
    protected void onResume() {
        super.onResume();
//première ouverture tuto
        if (prefs.getBoolean("firstrun1", true)) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    context);

            // set title
            alertDialogBuilder.setTitle(R.string.choisissez_votre_balade);

            // set dialog message
            alertDialogBuilder
                    .setMessage(R.string.aide1)
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
                    .putBoolean("isFirstRun1", false)
                    .apply();
            prefs.edit().putBoolean("firstrun1", false).apply();
        }

    }

//ouvre les balades
    public void b1(View view) {
        startActivity(new Intent(this, b1.class));
    }

    public void b2(View view) {
        startActivity(new Intent(this, b2.class));

    }

   }





