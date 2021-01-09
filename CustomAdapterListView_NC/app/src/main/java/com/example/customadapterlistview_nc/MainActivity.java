package com.example.customadapterlistview_nc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvFruits;
    ArrayList<Fruit> arrayfruits;
    FruitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        adapter = new FruitAdapter(this, R.layout.fruit_row, arrayfruits);
        lvFruits.setAdapter(adapter);
    }

    private void AnhXa(){
        lvFruits = (ListView) findViewById(R.id.lvFruits);
        arrayfruits = new ArrayList<>();

        arrayfruits.add(new Fruit("Apple", "Táo đỏ Mỹ", R.drawable.apple));
        arrayfruits.add(new Fruit("Avocado", "Bơ Australia", R.drawable.avocado));
        arrayfruits.add(new Fruit("Blueberry", "Việt quất Mỹ", R.drawable.blueberry));
        arrayfruits.add(new Fruit("Grapes", "Nho xanh Nhật Bản", R.drawable.grapes));
        arrayfruits.add(new Fruit("Green Apple", "Táo xanh Mỹ", R.drawable.greenapple));
        arrayfruits.add(new Fruit("Kiwi", "Kiwi Australia", R.drawable.kiwi));
        arrayfruits.add(new Fruit("Mango", "Xoài lửa Việt Nam", R.drawable.mango));
        arrayfruits.add(new Fruit("Orange", "Cam Việt Nam", R.drawable.orange));
        arrayfruits.add(new Fruit("Raspberry", "Khúc bồn tử Mỹ", R.drawable.raspberry));
        arrayfruits.add(new Fruit("Strawberry", "Dâu tây Mỹ", R.drawable.strawberry));
    }
}