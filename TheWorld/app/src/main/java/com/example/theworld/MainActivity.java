package com.example.theworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtInfor;
    Button btnSubmit;
    EditText edtName, edtEmai, edtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa() ;

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String email = edtEmai.getText().toString();
                String phone = edtPhone.getText().toString();

                String txtHello = getResources().getString(R.string.text_hello);
                String txtEmail = getResources().getString(R.string.text_email);
                String txtPhone = getResources().getString(R.string.text_phonenum);

                txtInfor.setText(txtHello + ": " + name + "\n" + txtEmail + ": " + email + "\n" + txtPhone + ": " + phone);
            }
        });
    }

    private void AnhXa(){
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        txtInfor = (TextView) findViewById(R.id.txtInfor);
        edtName = (EditText) findViewById(R.id.edtName);
        edtEmai = (EditText) findViewById(R.id.edtEmail);
        edtPhone = (EditText) findViewById(R.id.edtPhone);
    }
}