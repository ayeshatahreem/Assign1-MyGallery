package com.example.hp.assign1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.res.Configuration;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageAdapter customadapter;
    public static ArrayList<Integer> pics;
    GridView customview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         customview= (GridView) findViewById(R.id.gridview);
        pics = new ArrayList<Integer>();
        for(int i = 0 ; i < picsArray.length;i++)
            pics.add(picsArray[i]);
        
        customadapter = new ImageAdapter(this);
        customview.setAdapter(customadapter);


        customview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                // Send intent to SingleViewActivity
                Intent i = new Intent(getApplicationContext(), SingleViewActivity.class);
                // Pass image index
                i.putExtra("position", position);
                startActivityForResult(i,1);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK ){
            int position = data.getExtras().getInt("pos");
            pics.remove(position);
            customadapter = new ImageAdapter(this);
            customview.setAdapter(customadapter);
            customadapter.notifyDataSetChanged();
        }
    }
    public Integer[] picsArray = {
            R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,
            R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8,
            R.drawable.image9, R.drawable.image10 ,R.drawable.image1, R.drawable.image2,
            R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6,
            R.drawable.image7, R.drawable.image8, R.drawable.image9,R.drawable.image10
    };
}
