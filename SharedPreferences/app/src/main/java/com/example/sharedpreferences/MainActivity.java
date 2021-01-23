package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    Button btnOk;
    CheckBox cbRemember;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);
        //lấy giá trị SharePreferences
        edtUsername.setText(sharedPreferences.getString("account", ""));
        edtPassword.setText(sharedPreferences.getString("password", ""));
        cbRemember.setChecked(sharedPreferences.getBoolean("checked", false));

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString().trim();
                String pass = edtPassword.getText().toString().trim();

                if(username.equals("xuannguyen") && pass.equals("1234")){
                    Toast.makeText(MainActivity.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                    // nếu user check vào remember
                    if(cbRemember.isChecked()){
                        // lưu dữ liệu đã đăng nhập vào
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("account", username);
                        editor.putString("password", pass);
                        //lưu trạng thái của checkbox tùy thuộc vào việc người dùng có muốn check để remember không
                        editor.putBoolean("checked", true);
                        editor.commit(); // xác nhậc việc đưa vào tài khoản mật khẩu
                    } else{ // nếu user bỏ chọn checkbox thì ko remember nữa
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("account");
                        editor.remove("password");
                        editor.remove("checked");
                        editor.commit();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Login error", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void AnhXa(){
        btnOk = (Button) findViewById(R.id.btnOk);
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        cbRemember = (CheckBox) findViewById(R.id.checkBoxRemember);
    }
}