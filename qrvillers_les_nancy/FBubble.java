package com.qrvillers_les_nancy.qrvln.qrvillers_les_nancy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


//Permet de revenir sur la selection camera ou chiffre pour aller sur site

public class FBubble  extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fbubble);
}

    public void b1(View view) {
        startActivity(new Intent(this, c1.class));
    }

    public void b2(View view) {
        startActivity(new Intent(this, c2.class));

    }




}
