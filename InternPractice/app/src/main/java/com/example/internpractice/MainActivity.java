package com.example.internpractice;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    // cach khai bao de man hinh khac co the goi thuoc tinh nay
    public static ArrayList<String> arrayImageName;
    ImageView imgDefault, imgReceive;
    int REQUEST_CODE_IMAGE = 1407;
    String originalName = "";
    TextView txtScore;
    int total = 100;
    SharedPreferences savepoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgDefault = (ImageView) findViewById(R.id.imageViewDefault);
        imgReceive = (ImageView) findViewById(R.id.imageViewReceive);
        txtScore = (TextView) findViewById(R.id.textViewScore);

        // lưu điểm: khởi tạo
        savepoint = getSharedPreferences("GamePoint", MODE_PRIVATE);

        //get điểm số
        total = savepoint.getInt("point", 100);

        txtScore.setText(total + "");

        String[] arrImgName = getResources().getStringArray(R.array.list_name);
        arrayImageName = new ArrayList<>(Arrays.asList(arrImgName));

        // trộn mảng: cách này tương tự như random
        Collections.shuffle(arrayImageName);
        originalName = arrayImageName.get(10);

        // gán cứng hình
        //imgDefault.setImageResource(R.drawable.image1);

        // gán động các tấm hình
        int idImage = getResources().getIdentifier(arrayImageName.get(10), "drawable", getPackageName());
        imgDefault.setImageResource(idImage);

        imgReceive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, ImageActivity.class), REQUEST_CODE_IMAGE);
            }
        });
    }

    // nhận các gói dc gửi
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_IMAGE && resultCode == RESULT_OK && data != null){
            String nameImgReceive = data.getStringExtra("NameChose");
            int idImageReceive = getResources().getIdentifier(nameImgReceive, "drawable", getPackageName());
            imgReceive.setImageResource(idImageReceive);
            //so sánh theo tên hình gốc
            if(originalName.equals(nameImgReceive)){
                Toast.makeText(this, "Exactly! \nYou have 10 extra points", Toast.LENGTH_SHORT).show();

                // cong diem
                total += 10;

                savePoint();

                // có thể set đổi hình tự động nếu như đúng
                new CountDownTimer(2000, 100){
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        Collections.shuffle(arrayImageName);
                        originalName = arrayImageName.get(10);
                        int idImage = getResources().getIdentifier(arrayImageName.get(10), "drawable", getPackageName());
                        imgDefault.setImageResource(idImage);
                    }
                }.start();
            } else{
                Toast.makeText(this, "Wrong! \nYou are deducted 5 points", Toast.LENGTH_SHORT).show();
                total -= 5;
                savePoint();
            }
            txtScore.setText(total + "");
        }

        // kiểm tra màn hình thứ 2 không chọn hình: người dùng chơi gian lận khi chưa chọn mà trở về
        if(requestCode == REQUEST_CODE_IMAGE && resultCode == RESULT_CANCELED){
            Toast.makeText(this, "You have not selected image!!! \nYou are deducted 15 points", Toast.LENGTH_SHORT).show();
            total -= 15;
            savePoint();
            txtScore.setText(total + "");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.reload, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //bat su kien cua menu item: đổi hình mặc định cách thủ công
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuReload){
            // trộn mảng: cách này tương tự như random
            Collections.shuffle(arrayImageName);
            originalName = arrayImageName.get(10);
            int idImage = getResources().getIdentifier(arrayImageName.get(10), "drawable", getPackageName());
            imgDefault.setImageResource(idImage);
        }
        return super.onOptionsItemSelected(item);
    }

    private void savePoint(){
        SharedPreferences.Editor editor = savepoint.edit();
        editor.putInt("point", total);
        editor.commit();
    }
}