package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnProcess;
    TextView txtInfor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnProcess = (Button) findViewById(R.id.btnProcess);
        txtInfor = (TextView) findViewById(R.id.txtInfor);

        btnProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Task().execute();
            }
        });
    }

    private class Task extends AsyncTask<Void, String, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtInfor.setText("Start...\n");
        }

        @Override
        protected String doInBackground(Void... voids) {
            for(int i = 1; i <= 5; i++){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress("Complete task: " + i + "\n"); // ...values = array
            }
            return "Complete!\n";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            txtInfor.append(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            txtInfor.append(values[0]);
        }
    }
}