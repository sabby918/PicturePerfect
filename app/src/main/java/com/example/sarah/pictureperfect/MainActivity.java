package com.example.sarah.pictureperfect;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.util.Log;

public class MainActivity extends AppCompatActivity  {

    private static final String TAG = "update";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"onCreate");



        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Hello! Welcome to Picture Perfect. Click 'Okay' to begin")
                .setCancelable(false)
                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();




        View filterButton = findViewById(R.id.filter_button);
        registerForContextMenu(filterButton);

    }




    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Filter Options");
        menu.add(0, v.getId(), 0, "Black and White");
        menu.add(0, v.getId(), 0, "Inverted");
    }

}
