package com.example.project_pegasus;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class MainActivity4_adapter extends ArrayAdapter<String> {
    Context context;
    //data dat in de list item gaat

    String name [];

    //controller
    public MainActivity4_adapter(@NonNull Context context, String name []){
        super(context,R.layout.activity_main4_list_item,R.id.list, name);

        this.context = context;
        this.name = name;
    }
}
