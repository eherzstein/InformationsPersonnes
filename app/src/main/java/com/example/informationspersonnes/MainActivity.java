package com.example.informationspersonnes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button btnGo;
    private TextView txtLastName;
    private TextView txtName;
    private TextView txtPhone;
    private TextView txtEmail;
    private RadioGroup radioGroup;
    private final int REQUEST_CODE=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtLastName=findViewById(R.id.txtLastName);
        txtName=findViewById(R.id.txtName);
        txtPhone=findViewById(R.id.txtPhone);
        txtEmail=findViewById(R.id.txtEmail);
        radioGroup=findViewById(R.id.radioGroup);
        btnGo=findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);

                RadioButton rb = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());

                intent.putExtra("LastName",String.valueOf(txtLastName.getText()));
                intent.putExtra("Name",String.valueOf(txtName.getText()));
                intent.putExtra("Phone",String.valueOf(txtPhone.getText()));
                intent.putExtra("Email",String.valueOf(txtEmail.getText()));
                intent.putExtra("Type",rb.getText().toString());

                startActivityForResult(intent,REQUEST_CODE);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE)
        {
            if(resultCode==RESULT_OK)
            {
                String result=data.getStringExtra("returnData");
                Toast.makeText(MainActivity.this,result,Toast.LENGTH_LONG).show();
            }
        }
    }
}