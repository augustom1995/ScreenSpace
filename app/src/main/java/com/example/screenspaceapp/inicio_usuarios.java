package com.example.screenspaceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class inicio_usuarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_usuarios);

        findViewById(R.id.sign_out_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                singOut();
            }
        });
    }

    public void singOut(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(inicio_usuarios.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}