package com.qrvillers_les_nancy.qrvln.qrvillers_les_nancy;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;


//Créer un snippet un point rouge sur la map


public class CustomInfoWindowGoogleMap implements GoogleMap.InfoWindowAdapter {
    private Context context;

    public CustomInfoWindowGoogleMap(Context ctx){
        context = ctx;
    }

    @Override
    public View getInfoWindow(Marker marker) {

        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = ((Activity)context).getLayoutInflater()
                .inflate(R.layout.custom_info_contents, null);

        TextView name_tv = view.findViewById(R.id.title);
        TextView details_tv = view.findViewById(R.id.snippet);
        ImageView img = view.findViewById(R.id.placestan);


        name_tv.setText(marker.getTitle());
        details_tv.setText(marker.getSnippet());

        InfoWindowData infoWindowData = (InfoWindowData) marker.getTag();

        int imageId = context.getResources().getIdentifier(infoWindowData.getImage().toLowerCase(),
                "drawable", context.getPackageName());
        img.setImageResource(imageId);

        return view;
    }
}


