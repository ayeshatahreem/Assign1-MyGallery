package com.example.hp.assign1;

import android.support.v7.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;
import android.widget.Toast;
import android.app.WallpaperManager;
import java.io.IOException;

public class SingleViewActivity extends AppCompatActivity {

    int position;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_view);
        // Get intent data
        Intent i = getIntent();
        // Selected image id
        position = i.getIntExtra("position", 0);
        ImageAdapter imageAdapter = new ImageAdapter(this);
        ImageView imageView = (ImageView) findViewById(R.id.SingleView);
        imageView.setImageResource(MainActivity.pics.get(position));
    }
    public void goBack(View v) {
        // onDestroy();
        finish();
    }
    public void setAsHomeScreen(View v)
    {
        // Get intent data
        Intent i = getIntent();
        // Selected image id
        position = i.getIntExtra("position", 0);
        ImageAdapter imageAdapter = new ImageAdapter(this);
        WallpaperManager myWallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        try
        {
           myWallpaperManager.setResource(MainActivity.pics.get(position));
            Toast.makeText(this, "Wallpaper has been set on home screen", Toast.LENGTH_SHORT).show();
        } catch (IOException exception)
        {
            exception.printStackTrace();
            Toast.makeText(this, "Wallpaper has not been set on home screen", Toast.LENGTH_SHORT).show();
        }
    }
    public void deleteImage (View v)
    {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                    {
                        Intent i = new Intent();
                        i.putExtra("pos",position);
                        setResult(RESULT_OK,i);
                        finish();
                        break;
                    }
                    case DialogInterface.BUTTON_NEGATIVE: {
                        dialog.cancel();
                        //No button clicked
                        break;
                    }
                }
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to delete this image ?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }
}
