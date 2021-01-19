package com.example.datetimepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText edtDate;
    TextView txtTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtDate = (EditText) findViewById(R.id.edtDate);
        txtTime = (TextView) findViewById(R.id.txtChooseHour);

        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseADay();
            }
        });

        txtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseTheHour();
            }
        });
    }

    private void chooseADay(){
        // lay ngay thang hien tai
        Calendar calendar = Calendar.getInstance();
        int default_date = calendar.get(Calendar.DATE);
        int default_month = calendar.get(calendar.MONTH);
        int default_year = calendar.get(calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
                edtDate.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, default_year, default_month, default_date);
        datePickerDialog.show();
    }

    private void chooseTheHour(){
        //lay thoi gian hien tai
        Calendar calendar = Calendar.getInstance();
        int default_hour = calendar.get(Calendar.HOUR_OF_DAY);
        int defaule_minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                calendar.set(0,0,0 , hourOfDay, minute);

                txtTime.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, 14, 55, true);
        timePickerDialog.show();
    }
}