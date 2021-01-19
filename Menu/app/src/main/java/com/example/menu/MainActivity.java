package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnPopupMenu, btnContextMenu;
    ConstraintLayout screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPopupMenu = (Button) findViewById(R.id.btnPopupmenu);
        btnContextMenu = (Button) findViewById(R.id.btnChooseColor);
        screen = (ConstraintLayout) findViewById(R.id.screenChange);

        // hien thi popup menu
        btnPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu();
            }
        });

        // dang ky view cho context menu
        registerForContextMenu(btnContextMenu);
    }

    // ham tao menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_constructor, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //ham bat su kien trong menu

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuSettings:
                Toast.makeText(this, "You chose Setting", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuShare:
                Toast.makeText(this, "You chose Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuSearch:
                Toast.makeText(this, "You chose Search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuExit:
                Toast.makeText(this, "You chose Exit", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuEmail:
                Toast.makeText(this, "You chose Email", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuPhone:
                Toast.makeText(this, "You chose Phone", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showMenu(){
        // khoi tao popupmenu
        PopupMenu popupMenu = new PopupMenu(this, btnPopupMenu);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());

        // bat su kien popupmenu
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menupopupAdd:
                        btnPopupMenu.setText("Menu Add");
                        break;
                    case R.id.menupopupEdit:
                        btnPopupMenu.setText("Menu Edit");
                        break;
                    case R.id.menupopupDelete:
                        btnPopupMenu.setText("Menu Delete");
                        break;
                }
                return false;
            }
        });

        // hien thi popupmenu
        popupMenu.show();
    }

    // khoi tao context menu (context menu se xuat hien khi nhan longclick)
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);

        // them cac thuoc tinh tuy chon
        menu.setHeaderTitle("Choose color");
        menu.setHeaderIcon(R.mipmap.ic_launcher);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    // bat su kien trong context menu

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuGreen:
                screen.setBackgroundColor(Color.GREEN);
                break;
            case R.id.menuYellow:
                screen.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.menuBlack:
                screen.setBackgroundColor(Color.BLACK);
                break;
        }

        return super.onContextItemSelected(item);
    }
}