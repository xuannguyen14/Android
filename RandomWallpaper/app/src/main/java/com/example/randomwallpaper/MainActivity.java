package com.example.randomwallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    ArrayList<Integer> arrayImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
        arrayImage = new ArrayList<>();
        arrayImage.add(R.drawable.background1);
        arrayImage.add(R.drawable.background2);
        arrayImage.add(R.drawable.background3);
        arrayImage.add(R.drawable.background4);
        arrayImage.add(R.drawable.background5);

        Random random = new Random();
        int index = random.nextInt(arrayImage.size());
        linearLayout.setBackgroundResource(arrayImage.get(index));
    }
}