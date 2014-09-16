package com.example.jarod.sharepreferenceanna;


import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyActivity extends Activity {

    TextView nama,warna ;
    LinearLayout backgroud;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String WarnaKey = "warnaKey";
    public static final String Ground = "ground";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        nama = (TextView) findViewById(R.id.editTextName);
        warna = (TextView)findViewById(R.id.editTextwarna);
        backgroud = (LinearLayout)findViewById(R.id.background);
        Button save = (Button)findViewById(R.id.button1);


        backgroud.setBackgroundColor(sharedpreferences.getInt(Ground,0));
        nama.setText(sharedpreferences.getString(Name, ""));

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n  = nama.getText().toString();
                int warna = 0xff900000;
                Editor editor = sharedpreferences.edit();
                editor.putString(Name, n);
                editor.putInt(Ground,warna);
                editor.commit();
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

}