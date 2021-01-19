package com.example.dialogcustom;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLogIn = (TextView) findViewById(R.id.txtLogin);

        txtLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogLogIn();
            }
        });
    }

    private void DialogLogIn(){
        Dialog dialog = new Dialog(this);

        // truyen vao layout custom
        dialog.setContentView(R.layout.dialog_custom);

        // khong cho click ben ngoai thi tat dialog
        dialog.setCanceledOnTouchOutside(false);

        dialog.show();

        //vi view can anh xa la thanh phan trong dialog, ma mainActivity mac dinh chi anh xa nhung view co trong main.xml
        // nen khi anh xa can lam nhu sau
        EditText edtUsername = (EditText) dialog.findViewById(R.id.edtUsername);
        EditText edtPass = (EditText) dialog.findViewById(R.id.edtPassword);
        Button btnOk = (Button) dialog.findViewById(R.id.btnOk);
        Button btnCancel = (Button) dialog.findViewById(R.id.btnCancel);

        // giả lập bắt sk đăng nhập
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPass.getText().toString().trim();
                if(username.equals("nguyen") && password.equals("1108")){
                    Toast.makeText(MainActivity.this, "Logged in successfully!", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(MainActivity.this, "Login error!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // co hai cach tat dialog
                // dialog.cancel();
                dialog.dismiss();
            }
        });
    }

}