package com.example.randomorg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtResult;
    EditText minNumber, maxNumber;
    Button buttonRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        buttonRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String minString = minNumber.getText().toString().trim();
                String maxString = maxNumber.getText().toString().trim();



                //1. Khong cho nguoi dung nhap chu de tranh loi khi random, su dung android:inputType="number"
                //2. Kiểm tra rỗng khi nhập min, max
                //cach 1 minString.length() == 0
                //cach 2 minString.isEmpty() == true
                if(minString.length() == 0 || maxString.length() == 0){
                    Toast.makeText(MainActivity.this, "Please enter all numbers!", Toast.LENGTH_LONG).show();
                }
                else {
                    // ep kieu du lieu tu chuoi sang so
                    int min = Integer.parseInt(minString);
                    int max = Integer.parseInt(maxString);
                    //3. Không được nhập min > max
                    if(min > max){
                        Toast.makeText(MainActivity.this, "Error: min > max !!!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        //tao so ngau nhien
                        Random random = new Random();
                        int number = random.nextInt(max - min + 1) + min;

                        //xuat ket qua
                        txtResult.setText(String.valueOf(number));
                    }
                }
            }
        });
    }

    private void anhXa(){
        txtResult = (TextView) findViewById(R.id.txtResult);
        buttonRandom = (Button) findViewById(R.id.buttonRandom);
        minNumber = (EditText) findViewById(R.id.minNumber);
        maxNumber = (EditText) findViewById(R.id.maxNumber);
    }
}