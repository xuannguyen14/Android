package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView  txtTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTime = (TextView) findViewById(R.id.txtTime);

        // khoi tao calender nen chon thu vien java.until
        Calendar calendar = Calendar.getInstance();

        txtTime.append(calendar.getTime() + "\n");
        txtTime.append(calendar.get(Calendar.DATE) + "\n");
        txtTime.append(calendar.get(Calendar.MONTH) + "\n");
        txtTime.append(calendar.get(Calendar.YEAR) + "\n");

        // Dinh dang lai ngay or gio
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        txtTime.append(dateFormat.format(calendar.getTime()) + "\n");
        txtTime.append(calendar.get(Calendar.HOUR) + "\n");
        txtTime.append(calendar.get(Calendar.HOUR_OF_DAY) + "\n");

        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");// a danh dau am or pm
        txtTime.append(timeFormat.format(calendar.getTime()) + "\n");
    }
}