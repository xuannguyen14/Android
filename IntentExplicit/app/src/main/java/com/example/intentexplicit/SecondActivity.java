package com.example.intentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {

    Button btnSecond;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnSecond = (Button) findViewById(R.id.btnSecond);
        txtResult = (TextView) findViewById(R.id.txtResult);

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //nhan du lieu tu Intent
        Intent intent = getIntent();

        //nhan dl chuoi
        //String content = intent.getStringExtra("Data");

        //nhan du lieu so
        //int content = intent.getIntExtra("Data", 1234);//khi dữ kiệu được gửi qua không phải int  hoặc không đúng thì default value sẽ được sử dụng để gán vào kết quả

        //txtResult.setText("" + content);

        // nhan du lieu mang
        //String[] arrSubject = intent.getStringArrayExtra("Data");
        //txtResult.setText(arrSubject.length + arrSubject[3]);

        // nhan object
        //Student studentReceive = (Student) intent.getSerializableExtra("Data");
        //txtResult.setText(studentReceive.getName() + " - " + studentReceive.getAge());

        //nhan dl tu Bundle
        Bundle bundle = intent.getBundleExtra("Data");
        //nen kiem tra rong cho Bundle
        if(bundle != null) {
            String name = bundle.getString("String");
            int number = bundle.getInt("Int");
            String[] arr = bundle.getStringArray("Array");
            Student student = (Student) bundle.getSerializable("Object");
            txtResult.setText(name + "\n" + number + "\n" + arr[0] + "\n" + student.getName());
        }

        //Log.d("AAA", "onCreate Second");
    }

    /*
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("AAA", "onStart Second");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("AAA", "onRestart Second");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("AAA", "onResume Second");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("AAA", "onPause Second");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("AAA", "onStop Second");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("AAA", "onDestroy Second");
    }

     */
}