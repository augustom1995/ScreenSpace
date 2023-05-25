package com.example.screenspaceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class crear_cuenta extends AppCompatActivity {

    EditText inputEmail, inputPassword;
    Button btnRegister;
    String emailPattern= "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressBar progressBar;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);




        inputEmail=findViewById(R.id.inputEmail);
        inputPassword=findViewById(R.id.inputPassword);
        btnRegister=findViewById(R.id.btnRegister);
        progressBar= new ProgressBar(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerforAuth();
            }
        });






    }

    private void PerforAuth() {

        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();

        if(!email.matches(emailPattern)){

            inputEmail.setError("Enter an email");
        } else if(password.isEmpty() || password.length()<8){
            inputPassword.setError("Enter a password with 8 or more digits");
        } else{
            //progressBar.show();////////////////////////////////////////////////////////////////


            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        sendUserToNextActivity();
                        Toast.makeText(crear_cuenta.this,"Successful registration",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(crear_cuenta.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

    }

    private void sendUserToNextActivity() {

        Intent intent= new Intent(crear_cuenta.this,exito_crear_cuenta.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}