package com.example.intentimplicit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgChrome, imgMessage, imgCall, imgCamera, imgImage;

    int REQUEST_CODE_CAMERA = 1407;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgChrome = (ImageView) findViewById(R.id.imageViewChrome);
        imgMessage = (ImageView) findViewById(R.id.imageViewMessage);
        imgCall = (ImageView) findViewById(R.id.imageViewCall);
        imgCamera = (ImageView) findViewById(R.id.imageViewCamera);
        imgImage = (ImageView) findViewById(R.id.imageViewImage);

        imgChrome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                // tao hanh dong mo trinh duyet bang ACTION_VIEW
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com"));
                startActivity(intent);
            }
        });

        imgMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                //mo qua phan tin nhan
                intent.setAction(Intent.ACTION_SENDTO);
                //gui mot chuoi di: sms_body la mac dinh trong viec gui tin
                intent.putExtra("sms_body", "Hello...");
                //gui toi noi nao: sms:sdt la mac dinh, khong duoc thay doi
                intent.setData(Uri.parse("sms:0123456789"));
                startActivity(intent);
            }
        });

        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                // muốn gọi điện cần phải xin quyền bên AndroidManifest: thêm dòng: <uses-permission android:name="android.permission.CALL_PHONE"/>
                //intent.setAction(Intent.ACTION_CALL);
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0123456789"));
                startActivity(intent);
            }
        });

        imgCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CODE_CAMERA);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data != null){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data"); // default
            imgImage.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}