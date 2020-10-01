package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.net.URI;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);


    }

    public void createMapIntent(View view){
        String STORE_GEO_LOCATION = "geo:0,0?q=618 E South St Orlando, FL 32801";
        Uri uri = Uri.parse(STORE_GEO_LOCATION);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
        String GOOGLE_MAPS_PACKAGE = "com.google.android.apps.maps";
        mapIntent.setPackage(GOOGLE_MAPS_PACKAGE);
        if(mapIntent.resolveActivity(getPackageManager()) != null){
            startActivity(mapIntent);
        }
    }

    public void createPhoneIntent(View view){
        String telephoneNumber = "tel:0123456789";
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        dialIntent.setData(Uri.parse(telephoneNumber));
        startActivity(dialIntent);
    }
}
