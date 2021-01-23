package com.example.intentdataresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    Button btnConfirm;
    EditText edtEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        btnConfirm = (Button) findViewById(R.id.btnConfirm);
        edtEdit = (EditText) findViewById(R.id.edtEdit);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newtitle = edtEdit.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("newTitle", newtitle);
                // gan ket qua gui nho qua intent
                setResult(RESULT_OK, intent);

                //dong hoac ket thuc man hinh hien tai
                finish();
            }
        });
    }
}