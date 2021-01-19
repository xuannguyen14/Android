package com.example.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewName;
    ArrayList<String> arrayName;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewName = (ListView) findViewById(R.id.listviewName);
        arrayName = new ArrayList<>();
        addArrayName();

        // khoi tao adapter
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayName);
        listViewName.setAdapter(adapter);

        // bat su kien longclick trong listview
        listViewName.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // lam them tuy y
                String name = arrayName.get(position).toString();

                // co the de ham khong co tham so tuy muc dich
                confirmDeletion(position, name);

                return false;
            }
        });
    }

    private void confirmDeletion(final int position, String name){
        //khoi tao alertDialog
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        // set them cac thong tin tuy chon
        alertDialog.setTitle("Notification!");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setMessage("Do you want delete " + name + "?");
        // them button yes or no trong dialog
        // them Yes
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                arrayName.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        // them No
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // boi vi la No cho nen co the ko co noi dung code
            }
        });

        // hien thi dialog
        alertDialog.show();
    }

    private void addArrayName(){
        arrayName.add("Android");
        arrayName.add("iOS");
        arrayName.add("Java");
        arrayName.add("PHP");
        arrayName.add("NodeJS");
        arrayName.add("ASP.NET");
    }
}