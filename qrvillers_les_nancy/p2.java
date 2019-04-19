package com.qrvillers_les_nancy.qrvln.qrvillers_les_nancy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


//page 2 en savoir plus


public class p2 extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plus);
    }
    public void share(View view)
    {
       /* ACTION_SEND: Deliver some data to someone else.
        createChooser (Intent target, CharSequence title): Here, target- The Intent that the user will be selecting an activity to perform.
            title- Optional title that will be displayed in the chooser.
        Intent.EXTRA_TEXT: A constant CharSequence that is associated with the Intent, used with ACTION_SEND to supply the literal data to be sent.
        */
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Télécharge toi aussi l'appli que je viens de découvrir ! J'ai pu découvrir Villers-lès-Nancy grâce à celle-ci !");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}



