package com.example.gridviewcustomadapter_appgallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gvImage;
    ArrayList<Image> arrayImage;
    ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        adapter = new ImageAdapter(this, R.layout.image_row, arrayImage);
        gvImage.setAdapter(adapter);

        gvImage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arrayImage.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void AnhXa(){
        gvImage = (GridView) findViewById(R.id.gridviewImage);
        arrayImage = new ArrayList<>();
        arrayImage.add(new Image("Image 1", R.drawable.a));
        arrayImage.add(new Image("Image 2", R.drawable.b));
        arrayImage.add(new Image("Image 3", R.drawable.c));
        arrayImage.add(new Image("Image 4", R.drawable.d));
//        arrayImage.add(new Image("Image 5", R.drawable.e));
//        arrayImage.add(new Image("Image 6", R.drawable.f));
//        arrayImage.add(new Image("Image 7", R.drawable.g));
//        arrayImage.add(new Image("Image 8", R.drawable.h));
//        arrayImage.add(new Image("Image 9", R.drawable.i));
//        arrayImage.add(new Image("Image 10", R.drawable.j));
//        arrayImage.add(new Image("Image 11", R.drawable.k));
//        arrayImage.add(new Image("Image 12", R.drawable.l));
//        arrayImage.add(new Image("Image 13", R.drawable.m));
//        arrayImage.add(new Image("Image 14", R.drawable.n));
//        arrayImage.add(new Image("Image 15", R.drawable.o));
//        arrayImage.add(new Image("Image 16", R.drawable.p));

    }
}