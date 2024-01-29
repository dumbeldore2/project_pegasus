package com.example.project_pegasus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Arrays;

public class MainActivity3 extends AppCompatActivity {

    //views initen
    ImageView imageView;

    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //imageview conecten
        imageView = findViewById(R.id.imageViewLogo);

        //button conecte
        add = findViewById(R.id.buttonRegister);

        //functions
        backToLogin();
        newUser();
    }

    public void backToLogin(){
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(MainActivity3.this,MainActivity2.class);
                startActivity(intent);
                return false;
            }
        });
    }

    public void addUser(){
        // Replace the uri string with your MongoDB deployment's connection string
        String connectionString = "mongodb+srv://user:user@cluster0.che0uua.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("project_pegasus");
            MongoCollection<Document> collection = database.getCollection("users");
            try {
                // Inserts a sample document describing a movie into the collection
                InsertOneResult result = collection.insertOne(new Document()
                        .append("_id", new ObjectId())
                        .append("username","yago")
                        .append("password", "yago")
                        .append("code", "1711"));
                // Prints the ID of the inserted document
                System.out.println("Success! Inserted document id: " + result.getInsertedId());

                // Prints a message if any exceptions occur during the operation
            } catch (MongoException me) {
                System.err.println("Unable to insert due to an error: " + me);
            }
        }
    }

    public void newUser(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });
    }
}