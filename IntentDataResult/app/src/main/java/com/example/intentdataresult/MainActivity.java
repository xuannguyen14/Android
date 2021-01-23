package com.example.intentdataresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnEdit;
    TextView txtTitle;

    int REQUEST_CODE_EDIT = 1407;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEdit = (Button) findViewById(R.id.btnEdit);
        txtTitle = (TextView) findViewById(R.id.txtTitleMain);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditActivity.class);

                // goi va nhan ket qua tu man hinh khac tra ve
                startActivityForResult(intent, REQUEST_CODE_EDIT);
            }
        });
    }

    // nhan ket qua tu mot man hinh khac tro ve Main
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_EDIT && resultCode == RESULT_OK && data != null){
            String title = data.getStringExtra("newTitle");
            txtTitle.setText(title);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}