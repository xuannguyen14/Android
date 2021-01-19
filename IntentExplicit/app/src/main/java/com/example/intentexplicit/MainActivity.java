package com.example.intentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity extends Activity {

    Button btnMain, btnSendData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMain = (Button) findViewById(R.id.btnMain);
        btnSendData = (Button) findViewById(R.id.btnSendData);

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // khai bao man hinh moi, tu Main -> Second
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                startActivity(intent);
            }
        });

        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                // gui du lieu chuoi di kem qua man hinh tiep theo
                // intent.putExtra("Data", "String content");

                //gui du lieu so
                //intent.putExtra("Data", 2021);

                //gui du lieu mang
                String[] arrayCourse = {"Android", "iOS", "PHP", "NodeJS", "Unity"};
                //intent.putExtra("Data", arrayCourse);

                // gui object
                Student student = new Student("Roy Wang", 20);
                //intent.putExtra("Data", student);

                // khi can goi nhieu du lieu cung mot luc thi nen su dung Bundle, Bundle nhu la mot goi lon chua tat ca du lieu cua cac goi du lieu nho
                Bundle bundle = new Bundle();
                bundle.putString("String", "RoyWang");
                bundle.putInt("Int", 1108);
                bundle.putStringArray("Array", arrayCourse);
                bundle.putSerializable("Object", student);
                intent.putExtra("Data", bundle);

                //goi chay intent
                startActivity(intent);
            }
        });

        // kiem tra cach hoat dong cua cac ham
        //Log.d("AAA", "onCreate Main");
    }

    /* kiem tra cach hoat dong cua cac ham
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("AAA", "onStart Main");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("AAA", "onRestart Main");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("AAA", "onResume Main");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("AAA", "onPause Main");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("AAA", "onStop Main");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("AAA", "onDestroy Main");
    }

     */
}