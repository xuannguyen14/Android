package com.example.internpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.Collection;
import java.util.Collections;

public class ImageActivity extends Activity {

    TableLayout tblLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        tblLayout = (TableLayout) findViewById(R.id.tblLayoutImage);

        int columnNumber = 3;
        int rowNumber = 6;

        // trộn mảng
        Collections.shuffle(MainActivity.arrayImageName);

        // tạo số dòng và cột
        for(int i = 1; i <= rowNumber; i++){
            TableRow tableRow = new TableRow(this);

            // tao cot -> imageview
            for(int j = 1; j <= columnNumber; j++) {
                ImageView imageView = new ImageView(this);
                // hinh dang duoc nam trong dong
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(350, 350);
                imageView.setLayoutParams(layoutParams);

                // công thức để hiển thị hết tất cả các hình
                int position = columnNumber * (i - 1) + j - 1;

                int idImage = getResources().getIdentifier(MainActivity.arrayImageName.get(position), "drawable", getPackageName());
                imageView.setImageResource(idImage);
                // add imageview vao TableRow
                tableRow.addView(imageView);

                // bắt sự kiện khi nhấn vào hình
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.putExtra("NameChose", MainActivity.arrayImageName.get(position));
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
            }

            // add TableRow vào Table
            tblLayout.addView(tableRow);
        }
    }
}