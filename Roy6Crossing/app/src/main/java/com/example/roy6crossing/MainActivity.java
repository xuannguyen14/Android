package com.example.roy6crossing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtScore;
    CheckBox cbRoyan, cbEddy, cbLonglong, cbT2000;
    SeekBar skRoyan, skEddy, skLonglong, skT2000;
    ImageButton ibtnPlay;
    int score = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        // không cho người dùng đụng vào seekbar
        skRoyan.setEnabled(false);
        skEddy.setEnabled(false);
        skLonglong.setEnabled(false);
        skT2000.setEnabled(false);

        txtScore.setText(score + "");
        final CountDownTimer countDownTimer = new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long millisUntilFinished) {
                //khai báo random và khởi chạy ngẫu nhiên các bé
                int number = 4;
                Random random = new Random();
                int royan = random.nextInt(number);
                int eddy = random.nextInt(number);
                int longlong = random.nextInt(number);
                int t2000 = random.nextInt(number);

                // kiểm tra WIN
                if(skRoyan.getProgress() >= skRoyan.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this, "ROYAN WIN!!!", Toast.LENGTH_SHORT).show();
                    ibtnPlay.setVisibility(View.VISIBLE);

                    //kiểm tra đặt cược
                    if(cbRoyan.isChecked()){
                        score += 10;
                        Toast.makeText(MainActivity.this, "You guessed it right!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        score -= 5;
                        Toast.makeText(MainActivity.this, "You guessed wrong!", Toast.LENGTH_SHORT).show();
                    }
                    txtScore.setText(score + "");
                    EnableCheckBox();
                }
                if(skEddy.getProgress() >= skEddy.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this, "EDDY WIN!!!", Toast.LENGTH_SHORT).show();
                    ibtnPlay.setVisibility(View.VISIBLE);

                    //kiểm tra đặt cược
                    if(cbEddy.isChecked()){
                        score += 10;
                        Toast.makeText(MainActivity.this, "You guessed it right!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        score -= 5;
                        Toast.makeText(MainActivity.this, "You guessed wrong!", Toast.LENGTH_SHORT).show();
                    }
                    txtScore.setText(score + "");
                    EnableCheckBox();
                }
                if(skLonglong.getProgress() >= skLonglong.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this, "LONGLONG WIN!!!", Toast.LENGTH_SHORT).show();
                    ibtnPlay.setVisibility(View.VISIBLE);

                    //kiểm tra đặt cược
                    if(cbLonglong.isChecked()){
                        score += 10;
                        Toast.makeText(MainActivity.this, "You guessed it right!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        score -= 5;
                        Toast.makeText(MainActivity.this, "You guessed wrong!", Toast.LENGTH_SHORT).show();
                    }
                    txtScore.setText(score + "");
                    EnableCheckBox();
                }
                if(skT2000.getProgress() >= skT2000.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this, "T2000 WIN!!!", Toast.LENGTH_SHORT).show();
                    ibtnPlay.setVisibility(View.VISIBLE);

                    //kiểm tra đặt cược
                    if(cbT2000.isChecked()){
                        score += 10;
                        Toast.makeText(MainActivity.this, "You guessed it right!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        score -= 5;
                        Toast.makeText(MainActivity.this, "You guessed wrong!", Toast.LENGTH_SHORT).show();
                    }
                    txtScore.setText(score + "");
                    EnableCheckBox();
                }

                // cho các seekbar chạy
                skRoyan.setProgress(skRoyan.getProgress() + royan);
                skEddy.setProgress(skEddy.getProgress() + eddy);
                skLonglong.setProgress(skLonglong.getProgress() + longlong);
                skT2000.setProgress(skT2000.getProgress() + t2000);
            }

            @Override
            public void onFinish() {

            }
        };

        ibtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // bắt buộc phải chọn một trong những checkbox thì mới khởi chạy
                if(cbRoyan.isChecked() || cbEddy.isChecked() || cbLonglong.isChecked() || cbT2000.isChecked()){
                    // set các seekbar về vị trí ban đầu trước khi khởi chạy
                    skRoyan.setProgress(0);
                    skEddy.setProgress(0);
                    skLonglong.setProgress(0);
                    skT2000.setProgress(0);

                    //ẩn image button play khi nhấn vào nó
                    ibtnPlay.setVisibility(View.INVISIBLE);
                    //khởi chạy ngẫu nhiên các bé
                    countDownTimer.start();


                    // hàm để khi khởi chạy user ko được thay đổi sự lựa chọn ở checkbox
                    DisableCheckBox();
                }
                else{
                    Toast.makeText(MainActivity.this, "Please choose one of the Roy6", Toast.LENGTH_SHORT).show();
                }

            }
        });

        cbRoyan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    // bỏ các check còn lại
                    cbEddy.setChecked(false);
                    cbLonglong.setChecked(false);
                    cbT2000.setChecked(false);
                }
            }
        });
        cbEddy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    // bỏ các check còn lại
                    cbRoyan.setChecked(false);
                    cbLonglong.setChecked(false);
                    cbT2000.setChecked(false);
                }
            }
        });
        cbLonglong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    // bỏ các check còn lại
                    cbEddy.setChecked(false);
                    cbRoyan.setChecked(false);
                    cbT2000.setChecked(false);
                }
            }
        });
        cbT2000.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    // bỏ các check còn lại
                    cbEddy.setChecked(false);
                    cbLonglong.setChecked(false);
                    cbRoyan.setChecked(false);
                }
            }
        });
    }

    private  void EnableCheckBox(){
        cbRoyan.setEnabled(true);
        cbEddy.setEnabled(true);
        cbLonglong.setEnabled(true);
        cbT2000.setEnabled(true);
    }
    private  void DisableCheckBox(){
        cbRoyan.setEnabled(false);
        cbEddy.setEnabled(false);
        cbLonglong.setEnabled(false);
        cbT2000.setEnabled(false);
    }

    private void AnhXa(){
        txtScore   = (TextView) findViewById(R.id.txtScore);
        ibtnPlay   = (ImageButton) findViewById(R.id.ibtnPlay);
        cbRoyan    = (CheckBox) findViewById(R.id.cbRoyan);
        cbEddy     = (CheckBox) findViewById(R.id.cbEddy);
        cbLonglong = (CheckBox) findViewById(R.id.cbLonglong);
        cbT2000    = (CheckBox) findViewById(R.id.cbT2000);
        skRoyan    = (SeekBar) findViewById(R.id.skRoyan);
        skEddy     = (SeekBar) findViewById(R.id.skEddy);
        skLonglong = (SeekBar) findViewById(R.id.skLonglong);
        skT2000    = (SeekBar) findViewById(R.id.skT2000);
    }
}