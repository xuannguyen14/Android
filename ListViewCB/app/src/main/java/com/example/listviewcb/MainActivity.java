package com.example.listviewcb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvSubject;
    ArrayList<String> arraySubject;
    EditText edtSubject;
    Button btnAdd, btnUpdate;

    int positionArr = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvSubject = (ListView) findViewById(R.id.listviewSubject);
        edtSubject = (EditText) findViewById(R.id.edtSubject);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);

        //* Cau hinh listview
        arraySubject = new ArrayList<>();

        arraySubject.add("Android");
        arraySubject.add("Java");
        arraySubject.add("iOS");
        arraySubject.add("Unity");
        arraySubject.add("ASP.NET");

        //Khoi tao Adapter: bộ chuyển đổi có sẵn sử dụng cho listview cơ bản
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arraySubject);

        lvSubject.setAdapter(adapter);
        //*

        //bat su kien click tren listview
        lvSubject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // position: tra ve vi tri click tren Listview -> 0
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                // lay gia tri tai vi tri position
                Toast.makeText(MainActivity.this, arraySubject.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        // bat su kien nhan giu lau tren Listview
        lvSubject.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Long click: " + position, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // them
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject = edtSubject.getText().toString();
                arraySubject.add(subject);

                // cap nhat lai du lieu trong listview qua adapter
                adapter.notifyDataSetChanged();
            }
        });

        // cap nhap
        lvSubject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //khi click vao mot dong trong listview thi noi dung cua dong do se hien thi trong edittext
                edtSubject.setText(arraySubject.get(position));
                positionArr = position;
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arraySubject.set(positionArr, edtSubject.getText().toString());
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "You have successfully updated", Toast.LENGTH_SHORT).show();
            }
        });

        //xoa
        lvSubject.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arraySubject.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "You have successfully deleted", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}