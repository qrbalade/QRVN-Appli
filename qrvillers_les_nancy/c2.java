package com.qrvillers_les_nancy.qrvln.qrvillers_les_nancy;

import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;




public class c2 extends AppCompatActivity{
    private static final String LOG_TAG = b2.class.getSimpleName();
    private static final int BARCODE_READER_REQUEST_CODE = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p4);

        Button submit;
        final EditText edittext = (EditText) findViewById(R.id.editText2);
        final int[] amount = {Integer.parseInt(edittext.getText().toString())};
        submit = findViewById(R.id.button2);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                amount[0] =Integer.parseInt(edittext.getText().toString());
                if(amount[0] == 1) {
                    Uri uri = Uri.parse("http://qrnancy.free.fr/HoteldeVille.html");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);

                }
                if(amount[0] == 2) {
                    Uri uri = Uri.parse("http://qrnancy.free.fr/hoteldelareine.html");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                if(amount[0] == 3) {
                    Uri uri = Uri.parse("http://qrnancy.free.fr/PlaceStanislas.html");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                if(amount[0] == 4) {
                    Uri uri = Uri.parse("http://qrnancy.free.fr/Opera.html");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                if(amount[0] == 5) {
                    Uri uri = Uri.parse("http://qrnancy.free.fr/museedesbeauxarts.html");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                if(amount[0] == 6) {
                    Uri uri = Uri.parse("http://qrnancy.free.fr/ArcHere.html");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                if(amount[0] == 7) {
                    Uri uri = Uri.parse("http://qrnancy.free.fr/tribunaladministratif.html");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                if(amount[0] == 8) {
                    Uri uri = Uri.parse("http://qrnancy.free.fr/30granderue.html");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                if(amount[0] == 9) {
                    Uri uri = Uri.parse("http://qrnancy.free.fr/coursdappeldenancy.html");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                if(amount[0] ==10) {
                    Uri uri = Uri.parse("http://qrnancy.free.fr/PlaceCarriere.html");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            }

        });


        ImageButton scanBarcodeButton = (ImageButton) findViewById(R.id.im);
        scanBarcodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ScannedBarcodeActivity.class);
                startActivityForResult(intent, BARCODE_READER_REQUEST_CODE);

            }
        });}


}
