package com.example.generalexercises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Switch swtWifi;
    CheckBox cbAndroid, cbiOS, cbJava;
    Button btnChooseCb, btnChooseRb, btnDownload;
    RadioGroup radioGroupTime;
    RadioButton rdMor, rdAft, rdEve;
    ProgressBar pbDownload;
    SeekBar skSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        // bắt sự kiện khi chọn hoặc không chọn checkbox
        swtWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){ // isChecked == true
                    Toast.makeText(MainActivity.this, "You turn on Wifi", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "You turn off Wifi", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // bắt sự kiện khi chọn hoặc bỏ chọn checkbox
        cbAndroid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "You chose Android", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "You didn't choose Android", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // bắt sự kiện chung của checkbox qua button
        btnChooseCb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject = "Bạn đã chọn môn học: \n";
                if(cbAndroid.isChecked()){
                    subject += cbAndroid.getText() + "\n";
                }
                if(cbiOS.isChecked()){
                    subject += cbiOS.getText() + "\n";
                }
                if(cbJava.isChecked()){
                    subject += cbJava.getText() + "\n";
                }
                Toast.makeText(MainActivity.this, subject, Toast.LENGTH_SHORT).show();
            }
        });

        // bắt sự kiện của radioGroup
        radioGroupTime.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //checkedId trả về id của radioButton được chọn
                switch ((checkedId)){
                    case R.id.radioButtonMorning:
                        Toast.makeText(MainActivity.this, "You chose morning", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButtonAfternoon:
                        Toast.makeText(MainActivity.this, "You chose afternoon", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButtonEvening:
                        Toast.makeText(MainActivity.this, "You chose evening", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        // bắt sự kiện radiobutton thông qua button
        btnChooseRb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rdMor.isChecked()){
                    Toast.makeText(MainActivity.this, rdMor.getText(), Toast.LENGTH_SHORT).show();
                }
                if(rdAft.isChecked()){
                    Toast.makeText(MainActivity.this, rdAft.getText(), Toast.LENGTH_SHORT).show();
                }
                if(rdEve.isChecked()){
                    Toast.makeText(MainActivity.this, rdEve.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        // bắt sự kiện button download khi nháy vào button thì progressbar thay đổi
//        btnDownload.setOnClickListener(new View.OnClickListener() {
//            @Override
//                int current = pbDownload.getProgress();
//                if(current >= pbDownload.getMax()){
//                    current = 0;
//                }
//                pbDownload.setProgress(current + 10);
//            }
//        });

        // bắt sự kiện progress bar, khi nhấn vào button progress bar tự chạy
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 10000: 10 giây -> tổng thời gian đếm ngược
                // 1000: 1 giây -> thời gian lặp lại một hành động nào đó
                CountDownTimer countDownTimer = new CountDownTimer(10000, 10){
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int current = pbDownload.getProgress();
                        if(current >= pbDownload.getMax()){
                            current = 0;
                        }
                        pbDownload.setProgress(current + 10);
                    }

                    @Override
                    public void onFinish() {
                        this.start(); // chạy vô tận
                        Toast.makeText(MainActivity.this, "Time out!", Toast.LENGTH_SHORT).show();
                    }
                };
                countDownTimer.start(); // gọi countdown timer chạy
            }
        });

        // bắt sự kiện của seekbar
        skSound.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // progress: giá trị của seekbar
                Log.d("AAA", "Giá trị: " + progress); // kiểm tra thử giá trị của seekbar trong Run
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("AAA", "START"); // kiểm tra khi chạm vào seekbar sẽ xuất START trong Run
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("AAA", "STOP"); // kiểm tra khi buông seekbar ra sẽ xuất STOP trong Run
            }
        });
    }

    private void AnhXa(){
        swtWifi = (Switch) findViewById(R.id.switchWifi);
        cbAndroid = (CheckBox) findViewById(R.id.checkBoxAndroid);
        cbiOS = (CheckBox) findViewById(R.id.checkBoxiOS);
        cbJava = (CheckBox) findViewById(R.id.checkBoxJava);
        btnChooseCb = (Button) findViewById(R.id.buttonChooseCB);
        radioGroupTime = (RadioGroup) findViewById(R.id.radioGroupTime);
        btnChooseRb = (Button) findViewById(R.id.btnChooseRB);
        rdMor = (RadioButton) findViewById(R.id.radioButtonMorning);
        rdAft = (RadioButton) findViewById(R.id.radioButtonAfternoon);
        rdEve = (RadioButton) findViewById(R.id.radioButtonEvening);
        btnDownload = (Button) findViewById(R.id.btnDownload);
        pbDownload = (ProgressBar) findViewById(R.id.progressBarDownload);
        skSound = (SeekBar) findViewById(R.id.seekBarIcon);
    }
}