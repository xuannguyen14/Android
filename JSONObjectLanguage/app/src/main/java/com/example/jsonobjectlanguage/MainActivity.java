package com.example.jsonobjectlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageButton imgbtnVN, imgbtnEN;
    TextView txtInfor;
    String contentS = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();

        new ReadJSON().execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo3.json");

        imgbtnEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadJSONLanguage("en");
            }
        });

        imgbtnVN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadJSONLanguage("vn");
            }
        });
    }

    private class  ReadJSON extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... strings) {

            StringBuilder content = new StringBuilder();

            try {
                URL url = new URL(strings[0]);

                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());

                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";
                while((line = bufferedReader.readLine()) != null){
                    content.append(line);
                }

                bufferedReader.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            contentS = s;

            // default
            ReadJSONLanguage("vn");
        }
    }

    private void ReadJSONLanguage(String lang){
        try {
            JSONObject object = new JSONObject(contentS);

            JSONObject objectLanguage = object.getJSONObject("language");

            JSONObject objectVN = objectLanguage.getJSONObject(lang);

            String ten = objectVN.getString("name");
            String diachi = objectVN.getString("address");
            String khoahoc1 = objectVN.getString("course1");
            String khoahoc2 = objectVN.getString("course2");
            String khoahoc3 = objectVN.getString("course3");

            txtInfor.setText(ten + "\n" + diachi + "\n" + khoahoc1 + "\n" + khoahoc2 + "\n" + khoahoc3);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void Anhxa(){
        imgbtnEN = (ImageButton) findViewById(R.id.imageButtonEN);
        imgbtnVN = (ImageButton) findViewById(R.id.imageButtonVN);
        txtInfor = (TextView) findViewById(R.id.textViewInfor);
    }
}