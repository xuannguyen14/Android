package com.example.loadimagefrominternet;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button btnLoad;
    ImageView imgImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoad = (Button) findViewById(R.id.buttonLoad);
        imgImg = (ImageView) findViewById(R.id.imageViewImg);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoadImageInternet().execute("https://www.linefriends.com/im/roy6/slick_img/img_mo1.png");
            }
            // vì load hình từ internet nên cần phải xin quyền trong AndroidManifest
        });
    }

    //quản lý tiến trình load hình trên internet về bằng Asynctask
    private class LoadImageInternet extends AsyncTask<String, Void, Bitmap>{
        Bitmap bitmapImage = null;
        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                //khai báo một đường dẫn nhận vào tham số của mảng strings mặc định
                URL url = new URL(strings[0]);
                // lấy dữ liệu từ URL
                InputStream inputStream = url.openConnection().getInputStream();
                //đổ dữ liệu ra bitmap để decode về
                bitmapImage = BitmapFactory.decodeStream(inputStream);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return bitmapImage;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imgImg.setImageBitmap(bitmap);
        }
    }
}