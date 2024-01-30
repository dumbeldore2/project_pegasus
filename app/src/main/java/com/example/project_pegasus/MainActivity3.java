package com.example.project_pegasus;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity3 extends AppCompatActivity {
    FirebaseAuth mAuth;
    //views initen
    ImageView imageView;
    EditText editTextEmail, editTextPassword;

    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        //imageview conecten
        imageView = findViewById(R.id.imageViewLogo);

        //button conecte
        add = findViewById(R.id.buttonRegister);

        //edittexten connecten
        editTextEmail = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
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
        System.out.println(getEmail());
        System.out.println(getPassword());
        System.out.println("TEST");
        if(getEmail().length()>0 && getPassword().length()>0){
            mAuth.createUserWithEmailAndPassword(getEmail(), getPassword())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                System.out.println("createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                            } else {
                                // If sign in fails, display a message to the user.
                                System.out.println("createUserWithEmail:failure + " + task.getException());
                                Toast.makeText(MainActivity3.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
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

    public String getEmail(){
        String out = "";
        if (editTextEmail.getText().length() == 0){
            editTextEmail.setHintTextColor(getResources().getColor(R.color.c1));
        } else {
            out = editTextEmail.getText().toString();
        }
        return out;
    }
    public String getPassword(){
        String out = "";
        if (editTextPassword.getText().length() == 0){
            editTextPassword.setHintTextColor(getResources().getColor(R.color.c1));
        } else {
            out = editTextPassword.getText().toString();
        }
        return out;
    }
}