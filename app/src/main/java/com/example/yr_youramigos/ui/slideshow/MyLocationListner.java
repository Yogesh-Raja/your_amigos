package com.example.yr_youramigos.ui.slideshow;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.example.yr_youramigos.ui.gallery.User;

public class MyLocationListner implements LocationListener {
    private Context context=null;
    public MyLocationListner(Context context)
    {
        this.context=context;
    }
    @Override
    public void onLocationChanged(@NonNull Location location) {
        String Lat= String.valueOf(location.getLatitude());
        String Lon=String.valueOf(location.getLongitude());
        Intent intent=new Intent("com.sankar.app");
        intent.putExtra("com.sankar.lat",Lat);
        intent.putExtra("com.sankar.lon",Lon);
        User.setMsg(Lat+":"+Lon);
        if(context!=null)
        {
            context.sendBroadcast(intent);
        }


    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }
}
