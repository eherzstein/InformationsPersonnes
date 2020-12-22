package com.example.informationspersonnes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView txtType;
    private TextView txtFullName2;
    private TextView txtPhone2;
    private TextView txtEmail2;
    private Button boutonRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtType=findViewById(R.id.txtType);
        txtFullName2=findViewById(R.id.txtFullName2);
        txtPhone2=findViewById(R.id.txtPhone2);
        txtEmail2=findViewById(R.id.txtEmail2);
        boutonRetour=findViewById(R.id.boutonRetour);

        Bundle extras=getIntent().getExtras();
        if(extras!=null)
        {
            String name=extras.getString("Name");
            String lastName=extras.getString("LastName");
            String phone=extras.getString("Phone");
            String email=extras.getString("Email");
            String type=extras.getString("Type");
            String fullName=name+" "+lastName;


            //int monInt=extras.getInt("Message3");
            txtFullName2.setText(fullName);
            txtPhone2.setText(String.valueOf(phone));
            txtEmail2.setText(String.valueOf(email));
            txtType.setText(type);
        }

        boutonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // code ici
                Intent returnIntent=getIntent();
                returnIntent.putExtra("returnData", "Bien entendu !");
                setResult(RESULT_OK,returnIntent);
                finish();

            }
        });

        }
    }
