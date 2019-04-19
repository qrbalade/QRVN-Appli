package com.qrvillers_les_nancy.qrvln.qrvillers_les_nancy;


// Une fois que l'on a cliqué sur "flasher le QR code" on arrive sur cette page


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;




public class c1 extends AppCompatActivity{
    private static final String LOG_TAG = b1.class.getSimpleName();
    private static final int BARCODE_READER_REQUEST_CODE = 1;

    private TextView mResultTextView;
    final Context context = c1.this;
    private Button buttonPlayStop;
    private MediaPlayer mPlayer;
    Button submit;
    ImageButton submit1;
    ImageButton submit3;
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p4);

        final EditText edittext = (EditText) findViewById(R.id.editText2);
        final EditText edittext2 = (EditText) findViewById(R.id.editText3);
        final int[] amount = {Integer.parseInt(edittext.getText().toString())};



        submit3 =  findViewById(R.id.imageButton9);
        submit3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Stop();
            }
        });


        //Boutton pour jouer la partie MP3

        submit1 =  findViewById(R.id.imageButton5);
        submit1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                amount[0] =Integer.parseInt(edittext2.getText().toString());
                if(amount[0] == 1) {
                        playSound(R.raw.remicourt);
                }
                if(amount[0] == 2) {
                    playSound(R.raw.brabois);
                }
                if(amount[0] == 4) {
                    playSound(R.raw.asnee);
                }
                if(amount[0] == 3) {
                    playSound(R.raw.greff);
                }
                if(amount[0] == 5) {
                    playSound(R.raw.graffigny);
                }
                if(amount[0] == 6) {
                    playSound(R.raw.chatellus);
                }
                if(amount[0] == 7) {
                    playSound(R.raw.fiacre);
                }

            }



        });

        //Boutton pour aller sur le site web

        submit = findViewById(R.id.button2);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                amount[0] =Integer.parseInt(edittext.getText().toString());
                if(amount[0] == 4) {
                    Uri uri = Uri.parse("http://qrvn.free.fr/Asnee.php");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);

                }
                if(amount[0] == 3) {
                    Uri uri = Uri.parse("http://qrvn.free.fr/Greff.php");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                if(amount[0] == 5) {
                    Uri uri = Uri.parse("http://qrvn.free.fr/Graffigny.php");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                if(amount[0] == 6) {
                    Uri uri = Uri.parse("http://qrvn.free.fr/Chatellus.php");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                if(amount[0] == 7) {
                    Uri uri = Uri.parse("http://qrvn.free.fr/Saint-Fiacre.php");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                if(amount[0] == 1) {
                    Uri uri = Uri.parse("http://qrvn.free.fr/Remicourt.php");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                if(amount[0] == 2) {
                    Uri uri = Uri.parse("http://qrvn.free.fr/Brabois.php");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            }

        });

        ImageButton scanBarcodeButton = (ImageButton) findViewById(R.id.im);

       // clique sur le bouton pour aller sur la camera
        scanBarcodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ScannedBarcodeActivity.class);
                startActivityForResult(intent, BARCODE_READER_REQUEST_CODE);



            }
    });}



    public void Stop() {
        submit1 =  findViewById(R.id.imageButton5);
        submit1.setImageResource(R.drawable.lecture);
        submit1.setTag(R.drawable.lecture);
        mPlayer.pause();
        mPlayer.seekTo(0);
        }




    //joue le mp3
    private void playSound(int resId) {



        submit1 =  findViewById(R.id.imageButton5);


        if (mPlayer == null || submit1.getTag().equals(R.drawable.lecture)) {
            mPlayer = MediaPlayer.create(this, resId);
            mPlayer.setWakeMode(this.getBaseContext(), PowerManager.PARTIAL_WAKE_LOCK);
            mPlayer.start();
            submit1.setImageResource(R.drawable.pause);
            submit1.setTag(R.drawable.pause);
        }else if (submit1.getTag().equals(R.drawable.pause) && mPlayer.isPlaying()) {
            x = mPlayer.getCurrentPosition();
            mPlayer.pause();
            submit1.setImageResource(R.drawable.lecture);
            submit1.setTag(R.drawable.stop);
        }else if (submit1.getTag().equals(R.drawable.stop)) {
            mPlayer.seekTo(x);
            mPlayer.start();
            submit1.setImageResource(R.drawable.pause);
            submit1.setTag(R.drawable.pause);
        }



    }
}


