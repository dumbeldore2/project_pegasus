package com.example.project_pegasus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.project_pegasus.R;

public class MainActivity4 extends AppCompatActivity {
    //init van de listview
    MainActivity4_adapter mainActivity4Adapter;

    //inten van de views
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //views connecten
        listView = findViewById(R.id.list);
        String name [] = new String[2];
        name[1] = "project1";
        name[2] = "project1";

        mainActivity4Adapter = new MainActivity4_adapter(MainActivity4.this,name);

        listView.setAdapter(mainActivity4Adapter);
    }
}